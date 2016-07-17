# Ring-Algorithm
Ring Algorithm - Distributed Algorithms for Elections	
Trabajo tema 3 UGR grado de Ingeniería Informática asignatura Diseño de Sistemas Distribuidos (DSD)

## Autores:	
    Javier Izquierdo Vera	
    Miguel Medina Ballesteros	
    Gregorio Vidoy Fajardo	
    Juan Carlos Gallardo Morales	
   
## Sobre el algoritmo:  
-Se ha optado por implementar el algoritmo mediante Java RMI.	    
-Los procesos se conectan al servidor para notificarle sobre su estado, y se comunican entre ellos como en el chat descentralizado P2P.	
-Cada proceso simula un servidor.	    
-El identificador del servidor es el PID del proceso.	    
-Utilizamos el PID como criterio de selección de líder.	    

## Sobre la simulación:	
-Se ha implementado una simulación gráfica en JSwing.	    
-El programa simulador, al que se conectan los procesos por RMI, consta de:     	
            - Un log	    
            - Representación gráfica del algoritmo (únicamente reacciona al estado de los servidores y sus mensajes mediante un patrón Observable Observador).	      
            - Un botón para matar al coordinador y que vuelva a comenzar el algoritmo.        	
-Inicialmente, los servidores están todos desconectados y ninguno de ellos es líder. Se comienza la búsqueda del líder cuando se conectan 6 servidores.	        
    
La simulación gráfica está limitada a 6 servidores, por una razón muy sencilla: no teníamos tiempo de aprender JSwing lo suficiente como para construir una interfaz en anillo que se adaptase al número de servidores conectados. Por ello, el algoritmo no comienza la búsqueda de líder hasta que no hay 6 servidores conectados.	

## Instrucciones para ejecutar el programa:	
   1- Script para simulación automática: ./buildandrun	
