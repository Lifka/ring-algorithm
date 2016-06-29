package modelo;

import java.lang.management.ManagementFactory;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.rmi.server.UnicastRemoteObject;

public class Proceso implements Proceso_I{
    private static String POLICY = "modelo/server.policy";
    private static String HOST = "localhost";
    private String host_registry;
    private static Tag marca;
    private static long id;
    private boolean es_coordinador;
    private boolean alived;
    
    private boolean servidor_activo; 
    
    private ArrayList<String> listaProcesos;
    private static int mi_posicion;
    private static int pos_coordinador;
    private long pidCoordinador;
    
    private static Proceso_I siguiente_proceso;
    private static Simulador_I server; // encargado de registrar los procesos y actualizar la lista de de procesos de todos ellos
    
    
    public Proceso(String host_registry){
        alived = true;
        
        pidCoordinador = -1;
        pos_coordinador = -1;
        this.host_registry = host_registry;
        // Inicialmente, cada proceso está marcado como no-participante
        marca = Tag.NOPARTICIPANTE;
        
        String pid = ManagementFactory.getRuntimeMXBean().getName();
        id = Long.parseLong(pid.split("@")[0]);
        
        // Al principio no es coordinador
        es_coordinador = false;
        
        // El servidor está activo
        servidor_activo = true;
        
    }

    public int getTamLista(){
        return listaProcesos.size();
    }

    public int getPos(){
        return mi_posicion;
    }
    
    public String getCoordinador(){
        return listaProcesos.get(pos_coordinador);
    }

    public ArrayList<String> getLista(){
        return listaProcesos;
    }

    public long getPid(){
        return id;
    }

    public long getPidCoord(){
        return pidCoordinador;
    }
    
    public int getPosCoord(){
        return pos_coordinador;
    }

    public boolean isAlived(){
        return alived;
    }

    public void aniadirAServidor(){
        //extraemos el objeto remoto del servidor re registro
       if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        
        try {
            Registry registry = LocateRegistry.getRegistry();
            String nom_objeto_remoto = "remote_server";
            server = (Simulador_I) registry.lookup(nom_objeto_remoto);
            server.addProceso(String.valueOf(id));
            
        }catch (RemoteException | NotBoundException ex) {
            System.err.println("No se ha podido conectar al servidor");
            System.exit(-1);
        }
               
    }
    
    private void enviarMensaje(TipoMensaje tip, long mensaje){
        long timeStart = System.currentTimeMillis();
        long timeFinal = 0;

        //do{
        //    timeFinal = System.currentTimeMillis();
        //}while((timeFinal - timeStart) <  ((long) 2250 + (int)(Math.random()*2300)));
        
        
        try{
            System.out.println("Enviado: mipos:"+mi_posicion + " miId" + id + " tipo: " + String.valueOf(tip) + " maxId:" + mensaje);
             enviar_mensaje(tip,mensaje);
        }catch (RemoteException ex) {
            System.err.println("No se ha podido conectar al servidor");
            System.exit(-1);
        }

    }
    
            
            
   

    @Override
    public void enviar_mensaje(TipoMensaje tip, long mensaje) throws RemoteException {
        boolean enviado = false;
        int posicion = mi_posicion;
        Proceso_I proc;

        try {
            String nom_objeto_remoto = "";
            do{
                posicion ++;
                int pos =(posicion)%listaProcesos.size();

                if(System.getSecurityManager() == null){
                    System.setSecurityManager(new SecurityManager());
                }
                
                Registry registry = LocateRegistry.getRegistry();
                nom_objeto_remoto = listaProcesos.get(pos);
                proc = (Proceso_I) registry.lookup(nom_objeto_remoto);
                
                if (proc.coordinadorIsAlived()){
                    /** NOTIFICAR INTERFAZ **/
                    String[] notificacion = new String[6];
                    notificacion[0] = Integer.toString(mi_posicion);
                    notificacion[1] = Long.toString(id);
                    notificacion[2] = String.valueOf(tip);
                    notificacion[3] = Long.toString(mensaje);
                    notificacion[4] = nom_objeto_remoto;
                    notificacion[5] = String.valueOf(marca);
                    server.notificar(Evento.ENVIARMENSAJE, notificacion);
                    /*************************/
                }

            }while(!proc.recibirMensaje(tip,mensaje));
            
            
            
        }catch (RemoteException | NotBoundException ex) {
            System.err.println("No se ha podido conectar al servidor");
            System.exit(-1);
        }
    }
        
     public void comenzarEleccion() throws RemoteException{
        /*
            Cualquiera puede comenzar la elección 
        */
        
        // Se marca como participante
        marca = Tag.PARTICIPANTE;
        pidCoordinador = -1;
        pos_coordinador = -1;
        enviarMensaje(TipoMensaje.ELECCION, id);
        
    }
   
     
     /*****************************
      *     PROBLEMA:
      *     EL PROGRAMA ES UNA PILA
      *     LA FLECHA IBA AL REVÉS PORQUE ES UNA PILA
      *     RECIBIR LLAMA A ENVIAR, ESE ENVIAR A OTRO, Y ASÍ
      *     Y AL FINAL LAS NOTIFICACIONES ACABAN LLEGANDO CUANDO SE HAN RESUELTO OTRAS QUE IBAN DESPUÉS
      * 
      * 
      */
     
     
    @Override
    public boolean recibirMensaje(TipoMensaje tipo, long mensaje) throws RemoteException{
        boolean result = false;
        
        if(alived){
            
            
                /** NOTIFICAR INTERFAZ **/
                String[] notificacion = new String[4];
                notificacion[0] = Integer.toString(mi_posicion);
                notificacion[1] = Long.toString(id);
                notificacion[2] = String.valueOf(tipo);
                notificacion[3] = Long.toString(mensaje);
                server.notificar(Evento.RECIBIRMENSAJE, notificacion);
                /*************************/
            
            
            TipoMensaje tip = tipo;
            long mens = mensaje;

            if ((tip == TipoMensaje.ELECCION) || (tip == TipoMensaje.COORDINADOR && mens != id))
                System.out.println("Recibido: mipos:"+mi_posicion + " miId" + id + " tipo: " + String.valueOf(tipo) + " maxId:" + mensaje);
                


            // Si recibe un mensaje de “elección”, compara su id con el del mensaje
            if (tipo == TipoMensaje.ELECCION){
                 pidCoordinador = -1;
                 pos_coordinador = -1;
                 
                // Si es mayor que el del mensaje
                if (id > mensaje){
                    
                    Tag marca_anterior = this.marca ;
                    
                    // Si está marcado como participante, no envía el mensaje
                    
                    // En cualquier caso, si no lo estaba, se marca como participante
                    marca = Tag.PARTICIPANTE;
                    /** NOTIFICAR INTERFAZ **/
                    String[] notificacion2 = new String[3];
                    notificacion2[0] = Integer.toString(mi_posicion);
                    notificacion2[1] = Long.toString(id);
                    notificacion2[2] = String.valueOf(marca);
                    server.notificar(Evento.ACTUALIZARMARCA, notificacion2);
                    /*************************/
                    
                    
                    // Si está marcado como no participante, sustituye el id del mensaje de elección por el suyo y lo envía
                    if (marca_anterior == Tag.NOPARTICIPANTE){
                        mens = id;
                        enviarMensaje(tip,mens);
                    }
                   
                } else if (id < mens){
                    
                    // En cualquier caso, si no lo estaba, se marca como participante
                    marca = Tag.PARTICIPANTE;
                    /** NOTIFICAR INTERFAZ **/
                    String[] notificacion2 = new String[3];
                    notificacion2[0] = Integer.toString(mi_posicion);
                    notificacion2[1] = Long.toString(id);
                    notificacion2[2] = String.valueOf(marca);
                    server.notificar(Evento.ACTUALIZARMARCA, notificacion2);
                    /*************************/
                    
                    
                    // Si es menor --> pasa el mensaje de “elección” recibido a su vecino
                    enviarMensaje(tip,mens);
                    
                } else {
                    //Si el id recibido es el del propio receptor (igual)  es el proceso con
                    //    mayor id y se convierte en coordinador
                    es_coordinador = true;
                    
                    System.out.println("***** SOY EL COORDINADOR " + id + "*********");
                    
                    /** NOTIFICAR INTERFAZ **/
                    String[] notificacion3 = new String[2];
                    notificacion3[0] = Integer.toString(mi_posicion);
                    notificacion3[1] = Long.toString(id);
                    server.notificar(Evento.ACTUALIZARCOORDINADOR,notificacion3);
                    /*************************/
                    
                    // Se marca como noparticipante
                    marca = Tag.NOPARTICIPANTE;
                    /** NOTIFICAR INTERFAZ **/
                    String[] notificacion2 = new String[3];
                    notificacion2[0] = Integer.toString(mi_posicion);
                    notificacion2[1] = Long.toString(id);
                    notificacion2[2] = String.valueOf(marca);
                    server.notificar(Evento.ACTUALIZARMARCA, notificacion2);
                    /*************************/
                    
                   // envía un mensaje de “coordinador” a su vecino con su id
                   pidCoordinador = id;
                   this.actualizaPosCoordinador();
                   enviarMensaje(TipoMensaje.COORDINADOR,id);
                }
            } else if (tip == TipoMensaje.COORDINADOR){
                //  Si se recibe un mensaje de “coordinador”, se marca como noparticipante
                // y reenvía dicho mensaje a su vecino
                if(!es_coordinador){
                    pidCoordinador = mens;
                    marca = Tag.NOPARTICIPANTE;
                    
                    /** NOTIFICAR INTERFAZ **/
                    String[] notificacion2 = new String[3];
                    notificacion2[0] = Integer.toString(mi_posicion);
                    notificacion2[1] = Long.toString(id);
                    notificacion2[2] = String.valueOf(marca);
                    server.notificar(Evento.ACTUALIZARMARCA, notificacion2);
                    /*************************/
                    
                    this.actualizaPosCoordinador();
                    enviarMensaje(tip,mens);
                }  else {
                    
                    /** NOTIFICAR INTERFAZ **/
                    String[] notificacion2 = new String[2];
                    notificacion2[0] = Integer.toString(mi_posicion);
                    notificacion2[1] = Long.toString(id);
                    server.notificar(Evento.CONFIRMADO, notificacion2);
                    /*************************/
                    
                }
                
            }
            
            result = true;
        
        }
        
        
        return result;
    }

    private void actualizaPosCoordinador(){
        boolean encontrado = false;
        for (int i=0;i<listaProcesos.size() && !encontrado;i++){
            if (listaProcesos.get(i).equals(String.valueOf(pidCoordinador))){
                encontrado = true;
                pos_coordinador = i;
            }
        }
        System.out.println("**** ID: " + id + " pos_coordinador" + pos_coordinador);
    }
    
    public boolean esCoordinador(){
        return es_coordinador;
    }
    
    public long getID(){
        long result = -1;
        
        if (servidor_activo){
            result = id;
        }
        
        return result;
    }

    @Override
    public void addProceso(String idProceso) throws RemoteException {
        listaProcesos.add(idProceso);
    }


    @Override
    public void setListaProcesos(ArrayList<String> procesos) throws RemoteException{
        listaProcesos = procesos;
        actualizarPosId();
    }

    private void actualizarPosId(){
        for (int i=0; i<listaProcesos.size(); i++){
            if (listaProcesos.get(i).equals(String.valueOf(id)))
                mi_posicion = i;
        }
    }

    @Override
    public void setAlive(boolean estado) throws RemoteException{
        
        /** NOTIFICAR INTERFAZ **/
    	String[] notificacion = new String[2];
        notificacion[0] = Integer.toString(mi_posicion);
        notificacion[1] = Long.toString(id);
        
        
        if (estado){
            alived = true;
            comenzarEleccion();
            server.notificar(Evento.REVIVIR, notificacion);
        }else{
            alived = false;
            server.notificar(Evento.DORMIR, notificacion);
            
        }
    }
    
    @Override
    public boolean coordinadorIsAlived() throws RemoteException{
        return isAlived();
    }
    
    
    
    @Override
    public void notificarInicializado(){
        
        try{
        
            /** NOTIFICAR INTERFAZ **/
            String[] notificacion = new String[3];
            notificacion[0] = Integer.toString(mi_posicion);
            notificacion[1] = Long.toString(id);
            notificacion[2] = String.valueOf(marca);
            server.notificar(Evento.CREADO, notificacion);
            /*************************/
        } catch(Exception e){
            
        }
    }
    
   public static void main(String[] args) throws RemoteException {
        Utils.getInstance().setPolicy(POLICY);
        Utils.getInstance().setCodeBase(Proceso_I.class);
        
        Proceso_I proceso;
        proceso = new Proceso(HOST);
        
        

        if (System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        try{
            
            Proceso_I stub = (Proceso_I) UnicastRemoteObject.exportObject(proceso, 0);
            Registry registry = LocateRegistry.getRegistry();
            String nombre_objeto_remoto = String.valueOf(id);
            registry.rebind(nombre_objeto_remoto, stub);
            ((Proceso)proceso).aniadirAServidor();
        }catch (Exception ex) {
            System.err.println("No se ha podido conectar al servidor");
            System.exit(-1);
        }
        
        proceso.notificarInicializado();

        long timeStart = System.currentTimeMillis();
        long timeFinal = 0;

        while(true){
            timeFinal = System.currentTimeMillis();
            if (timeFinal - timeStart > 3053){
                System.out.println("(1)Pos:" + ((Proceso)proceso).getPos() + " pid:" + ((Proceso)proceso).getPid() +" pos_coord:" + ((Proceso)proceso).getPosCoord());
                if((((Proceso)proceso).getPidCoord() == -1 && ((Proceso)proceso).getTamLista() >= 6) ){
                    ((Proceso)proceso).comenzarEleccion();
                }else if ((((Proceso)proceso).getPosCoord() != -1 && ((Proceso)proceso).getTamLista() >= 6) && ((Proceso)proceso).getPos() != ((Proceso)proceso).getPosCoord()){
                    //System.out.println("(2)Soy: " + ((Proceso)proceso).getPos() + " pos_coord: " + ((Proceso)proceso).getPosCoord());
                    if(System.getSecurityManager() == null){
                        System.setSecurityManager(new SecurityManager());
                    }
            
                    try {
                        Registry registry = LocateRegistry.getRegistry();
                        String nom_objeto_remoto = ((Proceso)proceso).getCoordinador();
                        Proceso_I proc = (Proceso_I) registry.lookup(nom_objeto_remoto);
                        System.out.println("Alived: " + proc.coordinadorIsAlived());
                        if(!proc.coordinadorIsAlived()){
                            System.out.println("NO ALIVED");
                            ((Proceso)proceso).comenzarEleccion();
                        }
                    }catch (RemoteException | NotBoundException ex) {
                        System.err.println("No se ha podido conectar al servidor");
                        System.exit(-1);
                    }
                }
                
                timeStart = System.currentTimeMillis();
            }
        }

    }

    @Override
    public void fin() throws RemoteException {
        System.err.println("Simulador detenido, cerrando servidor " + id);
        System.exit(0);
    }
    
  
    
}
