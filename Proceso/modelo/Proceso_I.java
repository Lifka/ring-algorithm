package modelo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Proceso_I extends Remote{
    public void enviar_mensaje(TipoMensaje t, long mensaje) throws RemoteException;
    public boolean recibirMensaje(TipoMensaje t, long mensaje) throws RemoteException;
    public void addProceso(String idProceso) throws RemoteException;
    public void setListaProcesos(ArrayList<String> procesos) throws RemoteException;
    public void setAlive(boolean estado) throws RemoteException;
    public boolean coordinadorIsAlived() throws RemoteException;
    public void notificarInicializado() throws RemoteException;
    public void fin() throws RemoteException;
}
