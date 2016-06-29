/****************************************
 *      Izquierdo Vera, Javier
 *      javierizquierdovera@gmail.com
 ***************************************/
package modelo;

public class Utils {

    private static Utils instance = new Utils();
    public static final String CODEBASE ="java.rmi.server.codebase";
    public static final String POLICY ="java.security.policy";
    public static final String HOSTNAME ="java.rmi.server.hostname";
    
    private Utils(){}
    
    public static Utils getInstance(){
        return instance;
    }
    
    private static String getClassPath(Class clase, String propiedad){
        String class_path = clase.getProtectionDomain().getCodeSource().getLocation().toString();
        
        // Comprobar que no se ha asignado ya 
        boolean hay_class_path = (System.getProperty(propiedad) != null && !System.getProperty(propiedad).isEmpty());
        
        if(hay_class_path){
            class_path = System.getProperty(propiedad) + " " + class_path;
        }
        
        return class_path;
    }
    
    public static void setCodeBase(Class clase){
        System.setProperty(CODEBASE, getClassPath(clase, CODEBASE));
    }
    
    public static void setPolicy(String name){
        System.setProperty(POLICY, name);
    }
    
    public static void setHostName(String url){
        System.setProperty(HOSTNAME, url);
    }
    
}
