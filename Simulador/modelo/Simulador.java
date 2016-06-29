package modelo;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Simulador implements Simulador_I{
    ArrayList<String> procesos;
    private static String POLICY = "modelo/server.policy";
    private static String HOST = "localhost";
    
    /***************    Observador  *******************/
    private static ArrayList<Observador> observadores = new ArrayList();
    
    /***************    Singleton  *******************/
    private static Simulador instance = new Simulador();
    
    private Simulador(){
        procesos = new ArrayList<>();
    }
    
    public static Simulador getInstance(){
        return instance;
    }
    
    @Override
    public boolean addProceso(String idProceso) throws RemoteException{
        boolean exito = false;
        if (!procesos.contains(idProceso)){
            procesos.add(idProceso);
            for(String p : procesos)
                difundirListaProcesos(p);
            
            exito = true;
        }
        
        notificar(Evento.PROCESO_ANIADIDO, new String[]{idProceso});
        return exito;
    }
    
    
    
    private void difundirListaProcesos(String idProceso) throws RemoteException{
        if (System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        try{
            Registry registry = LocateRegistry.getRegistry(HOST);
            Proceso_I proceso = (Proceso_I) registry.lookup(idProceso);
            proceso.setListaProcesos(procesos);
            
            notificar(Evento.DIFUNDIDO_CORRECTO, new String[]{idProceso});
        } catch (RemoteException | NotBoundException ex) {
            System.err.println("No se ha podido conectar al proceso");
            
            notificar(Evento.ERROR, new String[]{"Error al difundir lista de procesos"});
        }
    }
    
    public void connect() throws RemoteException{
        Utils.getInstance().setPolicy(POLICY);
        Utils.getInstance().setCodeBase(Simulador_I.class);
        
        if (System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        try{
            Simulador_I stub = (Simulador_I) UnicastRemoteObject.exportObject(this, 0);
            Registry registry = LocateRegistry.getRegistry();
            String nombre_objeto_remoto = "remote_server";
            registry.rebind(nombre_objeto_remoto, stub);
            System.out.println("Server bound");
            
            notificar(Evento.CONECTADO, new String[]{});
        } catch (Exception ex) {
            System.err.println("No se ha podido iniciar");
            
            notificar(Evento.ERROR, new String[]{"Error al iniciar"});
        }
    }
    
    public void fin(){
        for(String p : procesos){
            try{
                    Registry registry = LocateRegistry.getRegistry(HOST);
                    Proceso_I proceso = (Proceso_I) registry.lookup(p);
                    proceso.fin();
                    UnicastRemoteObject.unexportObject(proceso, true);
                    
            } catch (Exception e){
            }
        }
    }
    
    
    /***************    Observador  *******************/
    public static void observar(Object observador){
        if (!observadores.contains(observador))
            observadores.add((Observador)observador);
    }
    
    public static void eliminarObservador(Object observador){
        observadores.remove((Observador)observador);
    }
    
    @Override
    public void notificar(Evento event, String[] notificacion){
        for(int i = 0; i < observadores.size(); i++)
            observadores.get(i).notify(event, notificacion);
    }

    @Override
    public void setAlive(boolean estado, String pid) throws RemoteException{
        try{
            Registry registry = LocateRegistry.getRegistry(HOST);
            Proceso_I proceso = (Proceso_I) registry.lookup(pid);
            proceso.setAlive(estado);
            
            
        } catch (RemoteException | NotBoundException ex) {
            System.err.println("No se ha podido conectar al proceso");
            notificar(Evento.ERROR, new String[]{"Error setAlive"});
        }
    }
    
    
    
    
}
