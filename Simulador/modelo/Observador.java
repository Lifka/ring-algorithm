/****************************************
 *      Izquierdo Vera, Javier
 *      javierizquierdovera@gmail.com
 ***************************************/
package modelo;

public interface Observador {
    public void notify(Evento event, String[] notificacion);
}
