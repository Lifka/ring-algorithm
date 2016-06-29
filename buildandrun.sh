#!/bin/bash

cd Proceso;
javac ./modelo/*.java;
cd ../Simulador;
javac ./modelo/Evento.java; 
javac ./modelo/*.java;
javac ./GUI/*.java;
cd ..;

cd Simulador;
java -cp . GUI/SimuladorGUI &

sleep 5;

cd ..;
cd Proceso;
java -cp . modelo/Proceso &
sleep 1;
java -cp . modelo/Proceso &
sleep 1;
java -cp . modelo/Proceso &
sleep 1;
java -cp . modelo/Proceso &
sleep 1;
java -cp . modelo/Proceso &
sleep 1;
java -cp . modelo/Proceso &

