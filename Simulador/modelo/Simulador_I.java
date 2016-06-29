package modelo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Simulador_I extends Remote{
    public boolean addProceso(String idProceso) throws RemoteException;
    public void setAlive(boolean estado, String pid) throws RemoteException;
    public void notificar(Evento event, String[] notificacion) throws RemoteException;
}
