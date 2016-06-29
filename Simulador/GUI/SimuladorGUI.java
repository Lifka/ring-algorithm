package GUI;

import java.awt.Color;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Evento;
import modelo.Observador;
import modelo.Simulador;

public class SimuladorGUI extends javax.swing.JFrame implements Observador {

	public SimuladorGUI() {
		initComponents();
                Simulador.getInstance().observar(this);
                
                try{
                    Simulador.getInstance().connect();
                } catch(Exception e){
                    
                }
                
            desactivarPasosMensajes();
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextArea();
        panelSimulacion = new javax.swing.JPanel();
        PID0 = new javax.swing.JButton();
        PID1 = new javax.swing.JButton();
        PID5 = new javax.swing.JButton();
        PID2 = new javax.swing.JButton();
        PID3 = new javax.swing.JButton();
        PID4 = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        MARCA0 = new javax.swing.JLabel();
        COORDINADOR0 = new javax.swing.JLabel();
        MARCA1 = new javax.swing.JLabel();
        COORDINADOR1 = new javax.swing.JLabel();
        MARCA2 = new javax.swing.JLabel();
        COORDINADOR2 = new javax.swing.JLabel();
        MARCA3 = new javax.swing.JLabel();
        COORDINADOR3 = new javax.swing.JLabel();
        MARCA4 = new javax.swing.JLabel();
        COORDINADOR4 = new javax.swing.JLabel();
        MARCA5 = new javax.swing.JLabel();
        COORDINADOR5 = new javax.swing.JLabel();
        flecha12 = new javax.swing.JLabel();
        flecha61 = new javax.swing.JLabel();
        flecha23 = new javax.swing.JLabel();
        flecha34 = new javax.swing.JLabel();
        flecha45 = new javax.swing.JLabel();
        flecha56 = new javax.swing.JLabel();
        ID5 = new javax.swing.JLabel();
        ID0 = new javax.swing.JLabel();
        MENSAJE2 = new javax.swing.JLabel();
        ID1 = new javax.swing.JLabel();
        MENSAJE3 = new javax.swing.JLabel();
        ID4 = new javax.swing.JLabel();
        MENSAJE5 = new javax.swing.JLabel();
        MENSAJE0 = new javax.swing.JLabel();
        MENSAJE1 = new javax.swing.JLabel();
        ID2 = new javax.swing.JLabel();
        ID3 = new javax.swing.JLabel();
        MENSAJE4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jButton4.setText("PID");
        jButton4.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton4.setMinimumSize(new java.awt.Dimension(30, 30));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        log.setEditable(false);
        log.setColumns(20);
        log.setRows(5);
        jScrollPane1.setViewportView(log);

        panelSimulacion.setBackground(new java.awt.Color(250, 250, 250));
        panelSimulacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        PID0.setBackground(new java.awt.Color(150, 150, 240));
        PID0.setText("PID");
        PID0.setMaximumSize(new java.awt.Dimension(30, 30));
        PID0.setMinimumSize(new java.awt.Dimension(30, 30));
        PID0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PID0ActionPerformed(evt);
            }
        });

        PID1.setBackground(new java.awt.Color(150, 150, 240));
        PID1.setText("PID");
        PID1.setMaximumSize(new java.awt.Dimension(30, 30));
        PID1.setMinimumSize(new java.awt.Dimension(30, 30));
        PID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PID1ActionPerformed(evt);
            }
        });

        PID5.setBackground(new java.awt.Color(150, 150, 240));
        PID5.setText("PID");
        PID5.setMaximumSize(new java.awt.Dimension(30, 30));
        PID5.setMinimumSize(new java.awt.Dimension(30, 30));
        PID5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PID5ActionPerformed(evt);
            }
        });

        PID2.setBackground(new java.awt.Color(150, 150, 240));
        PID2.setText("PID");
        PID2.setMaximumSize(new java.awt.Dimension(30, 30));
        PID2.setMinimumSize(new java.awt.Dimension(30, 30));
        PID2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PID2ActionPerformed(evt);
            }
        });

        PID3.setBackground(new java.awt.Color(150, 150, 240));
        PID3.setText("PID");
        PID3.setMaximumSize(new java.awt.Dimension(30, 30));
        PID3.setMinimumSize(new java.awt.Dimension(30, 30));
        PID3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PID3ActionPerformed(evt);
            }
        });

        PID4.setBackground(new java.awt.Color(150, 150, 240));
        PID4.setText("PID");
        PID4.setMaximumSize(new java.awt.Dimension(30, 30));
        PID4.setMinimumSize(new java.awt.Dimension(30, 30));
        PID4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PID4ActionPerformed(evt);
            }
        });

        MARCA0.setText("part1");

        COORDINADOR0.setText("coord1");

        MARCA1.setText("part2");

        COORDINADOR1.setText("coord2");

        MARCA2.setText("part3");

        COORDINADOR2.setText("coord3");

        MARCA3.setText("part4");

        COORDINADOR3.setText("coord4");

        MARCA4.setText("part5");

        COORDINADOR4.setText("coord5");

        MARCA5.setText("part6");

        COORDINADOR5.setText("coord6");

        flecha12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/izquierdaDerecha.png"))); // NOI18N

        flecha61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/izquierdaArriba.png"))); // NOI18N

        flecha23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/izquierdaAbajo.png"))); // NOI18N

        flecha34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/derechaAbajo.png"))); // NOI18N

        flecha45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/derechaIzquierda.png"))); // NOI18N

        flecha56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/derechaArriba.png"))); // NOI18N

        ID5.setText("ID61");

        ID0.setText("ID12");

        MENSAJE2.setText("tipoMensaje");

        ID1.setText("ID21");

        MENSAJE3.setText("tipoMensaje");

        ID4.setText("ID56");

        MENSAJE5.setText("tipoMensaje");

        MENSAJE0.setText("tipoMensaje");

        MENSAJE1.setText("tipoMensaje");

        ID2.setText("ID34");

        ID3.setText("ID45");

        MENSAJE4.setText("tipoMensaje");

        jButton1.setText("TIRAR COORDINADOR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSimulacionLayout = new javax.swing.GroupLayout(panelSimulacion);
        panelSimulacion.setLayout(panelSimulacionLayout);
        panelSimulacionLayout.setHorizontalGroup(
            panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSimulacionLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSimulacionLayout.createSequentialGroup()
                        .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MARCA1)
                            .addComponent(COORDINADOR1))
                        .addGap(145, 145, 145))
                    .addGroup(panelSimulacionLayout.createSequentialGroup()
                        .addComponent(flecha61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MENSAJE5)
                            .addComponent(ID5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSimulacionLayout.createSequentialGroup()
                                    .addComponent(ID1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(flecha23)
                                    .addGap(62, 62, 62))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSimulacionLayout.createSequentialGroup()
                                    .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(panelSimulacionLayout.createSequentialGroup()
                                            .addComponent(ID2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(flecha34))
                                        .addComponent(MENSAJE1))
                                    .addGap(81, 81, 81))
                                .addGroup(panelSimulacionLayout.createSequentialGroup()
                                    .addComponent(MENSAJE2)
                                    .addContainerGap()))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSimulacionLayout.createSequentialGroup()
                                .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(COORDINADOR2)
                                    .addComponent(MARCA2)
                                    .addComponent(PID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))))))
            .addGroup(panelSimulacionLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSimulacionLayout.createSequentialGroup()
                        .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(flecha56)
                            .addGroup(panelSimulacionLayout.createSequentialGroup()
                                .addComponent(COORDINADOR5)
                                .addGap(31, 31, 31)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MENSAJE4)
                            .addComponent(ID4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelSimulacionLayout.createSequentialGroup()
                        .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MARCA5)
                            .addComponent(PID5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSimulacionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSimulacionLayout.createSequentialGroup()
                        .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MENSAJE0)
                            .addComponent(flecha12)
                            .addComponent(ID0))
                        .addGap(288, 288, 288))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSimulacionLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(246, 246, 246))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSimulacionLayout.createSequentialGroup()
                .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSimulacionLayout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MARCA4)
                            .addComponent(PID4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(COORDINADOR4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                        .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ID3)
                            .addComponent(flecha45)
                            .addComponent(MENSAJE3))
                        .addGap(67, 67, 67))
                    .addGroup(panelSimulacionLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MARCA0)
                            .addComponent(PID0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(COORDINADOR0))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(COORDINADOR3)
                    .addComponent(MARCA3)
                    .addGroup(panelSimulacionLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PID3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(165, 165, 165))
        );
        panelSimulacionLayout.setVerticalGroup(
            panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSimulacionLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSimulacionLayout.createSequentialGroup()
                        .addComponent(PID0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MARCA0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(COORDINADOR0))
                    .addGroup(panelSimulacionLayout.createSequentialGroup()
                        .addComponent(PID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MARCA1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(COORDINADOR1))
                    .addGroup(panelSimulacionLayout.createSequentialGroup()
                        .addComponent(flecha12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ID0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MENSAJE0)))
                .addGap(54, 54, 54)
                .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID5)
                    .addComponent(ID1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MENSAJE5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
            .addGroup(panelSimulacionLayout.createSequentialGroup()
                .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSimulacionLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(flecha23)
                        .addGap(3, 3, 3)
                        .addComponent(MENSAJE1)
                        .addGap(104, 104, 104))
                    .addGroup(panelSimulacionLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(flecha61)
                        .addGap(58, 58, 58)
                        .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PID5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MARCA5)
                            .addComponent(MARCA2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(COORDINADOR5)
                            .addComponent(jButton1)
                            .addComponent(COORDINADOR2))))
                .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelSimulacionLayout.createSequentialGroup()
                        .addComponent(MENSAJE3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ID3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(flecha45))
                    .addGroup(panelSimulacionLayout.createSequentialGroup()
                        .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelSimulacionLayout.createSequentialGroup()
                                .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelSimulacionLayout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(flecha56))
                                    .addGroup(panelSimulacionLayout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(MENSAJE2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ID2)
                                            .addGroup(panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(flecha34)
                                                .addGroup(panelSimulacionLayout.createSequentialGroup()
                                                    .addComponent(ID4)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(MENSAJE4))))))
                                .addGap(65, 65, 65)
                                .addComponent(COORDINADOR3)
                                .addGap(10, 10, 10)
                                .addComponent(PID3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MARCA3))
                            .addGroup(panelSimulacionLayout.createSequentialGroup()
                                .addComponent(COORDINADOR4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PID4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MARCA4)))
                        .addGap(6, 6, 6)))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelSimulacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(panelSimulacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PID0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PID0ActionPerformed
     /*  if(!PID0.getBackground().equals(Color.RED)){
            setAlive(0, false, PID0.getText());
        }/* else {
            setAlive(0, false, PID0.getText());
        }*/
    }//GEN-LAST:event_PID0ActionPerformed

    private void PID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PID1ActionPerformed
       /* if(!PID1.getBackground().equals(Color.RED)){
            setAlive(1, false, PID1.getText());
        }/* else {
            setAlive(1, false, PID1.getText());
        }*/
    }//GEN-LAST:event_PID1ActionPerformed

    private void PID2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PID2ActionPerformed
        if(!PID2.getBackground().equals(Color.RED)){
            setAlive(2, false, PID2.getText());
        } /*else {
            setAlive(2, false, PID2.getText());
        }*/
    }//GEN-LAST:event_PID2ActionPerformed

    private void PID3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PID3ActionPerformed
      /*  if(!PID3.getBackground().equals(Color.RED)){
            setAlive(3, false, PID3.getText());
        }/* else {
            setAlive(3, false, PID3.getText());
        }*/
    }//GEN-LAST:event_PID3ActionPerformed

    private void PID4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PID4ActionPerformed
       /* if(!PID4.getBackground().equals(Color.RED)){
            setAlive(4, false, PID4.getText());
        }/* else {
            setAlive(4, false, PID4.getText());
        }*/
    }//GEN-LAST:event_PID4ActionPerformed

    private void PID5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PID5ActionPerformed
      /*  if(!PID5.getBackground().equals(Color.RED)){
            setAlive(5, false, PID5.getText());
        }/* else {
            setAlive(5, false, PID5.getText());
        }*/
    }//GEN-LAST:event_PID5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        String tag = "Coordinador";
        if (COORDINADOR0.getText().equals(tag)){
            setAlive(0, false, PID0.getText());
        }
        
        if (COORDINADOR1.getText().equals(tag)){
            setAlive(1, false, PID1.getText());
        }
        
        if (COORDINADOR2.getText().equals(tag)){
            setAlive(2, false, PID2.getText());
        }
        
        if (COORDINADOR3.getText().equals(tag)){
            setAlive(3, false, PID3.getText());
        }
        
        if (COORDINADOR4.getText().equals(tag)){
            setAlive(4, false, PID4.getText());
        }
        
        if (COORDINADOR5.getText().equals(tag)){
            setAlive(5, false, PID5.getText());
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
            
                Simulador.getInstance().fin();
    }//GEN-LAST:event_formWindowClosing

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(SimuladorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(SimuladorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(SimuladorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(SimuladorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new SimuladorGUI().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel COORDINADOR0;
    private javax.swing.JLabel COORDINADOR1;
    private javax.swing.JLabel COORDINADOR2;
    private javax.swing.JLabel COORDINADOR3;
    private javax.swing.JLabel COORDINADOR4;
    private javax.swing.JLabel COORDINADOR5;
    private javax.swing.JLabel ID0;
    private javax.swing.JLabel ID1;
    private javax.swing.JLabel ID2;
    private javax.swing.JLabel ID3;
    private javax.swing.JLabel ID4;
    private javax.swing.JLabel ID5;
    private javax.swing.JLabel MARCA0;
    private javax.swing.JLabel MARCA1;
    private javax.swing.JLabel MARCA2;
    private javax.swing.JLabel MARCA3;
    private javax.swing.JLabel MARCA4;
    private javax.swing.JLabel MARCA5;
    private javax.swing.JLabel MENSAJE0;
    private javax.swing.JLabel MENSAJE1;
    private javax.swing.JLabel MENSAJE2;
    private javax.swing.JLabel MENSAJE3;
    private javax.swing.JLabel MENSAJE4;
    private javax.swing.JLabel MENSAJE5;
    private javax.swing.JButton PID0;
    private javax.swing.JButton PID1;
    private javax.swing.JButton PID2;
    private javax.swing.JButton PID3;
    private javax.swing.JButton PID4;
    private javax.swing.JButton PID5;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel flecha12;
    private javax.swing.JLabel flecha23;
    private javax.swing.JLabel flecha34;
    private javax.swing.JLabel flecha45;
    private javax.swing.JLabel flecha56;
    private javax.swing.JLabel flecha61;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea log;
    private javax.swing.JPanel panelSimulacion;
    // End of variables declaration//GEN-END:variables

 private void log(String msg){
     log.setText(log.getText() + "[*] " + msg + "\n");
 }
 
 private void setAlive(int pos, boolean estado, String pid){
     
     try{
        Simulador.getInstance().setAlive(estado, pid);
     } catch (Exception e){
         
     }
     
    
     switch (pos){
         case 0:
            if (!estado)
                PID0.setBackground(Color.RED);
            else
                PID0.setBackground(Color.GREEN);
            break;
         case 1:
            if (!estado)
                PID1.setBackground(Color.RED);
            else
                PID1.setBackground(Color.GREEN);
            break;
         case 2:
            if (!estado)
                PID2.setBackground(Color.RED);
            else
                PID2.setBackground(Color.GREEN);
            break;
         case 3:
            if (!estado)
                PID3.setBackground(Color.RED);
            else
                PID3.setBackground(Color.GREEN);
            break;
         case 4:
            if (!estado)
                PID4.setBackground(Color.RED);
            else
                PID4.setBackground(Color.GREEN);
            break;
         case 5:
            if (!estado)
                PID5.setBackground(Color.RED);
            else
                PID5.setBackground(Color.GREEN);
            break;
        default:
            break;
         
     }
    repaint();
 }
 
 private void actualizarPid(int pos, String PID){
    switch (pos){
         case 0:
            PID0.setText(PID);
            break;
         case 1:
            PID1.setText(PID);
            break;
         case 2:
            PID2.setText(PID);
            break;
         case 3:
            PID3.setText(PID);
            break;
         case 4:
            PID4.setText(PID);
            break;
         case 5:
            PID5.setText(PID);
            break;
        default:  
            break;
         
     }
    repaint();
 }
 
 private void actualizarMarca(int pos, String marca){
    switch (pos){
         case 0:
            MARCA0.setText(marca);
            break;
         case 1:
            MARCA1.setText(marca);
            break;
         case 2:
            MARCA2.setText(marca);
            break;
         case 3:
            MARCA3.setText(marca);
            break;
         case 4:
            MARCA4.setText(marca);
            break;
         case 5:
            MARCA5.setText(marca);
            break;
        default:
            break;
     }
    repaint();
 }
 
 private void actualizarCoordinador(int pos){
     COORDINADOR0.setText("");
     COORDINADOR1.setText("");
     COORDINADOR2.setText("");
     COORDINADOR3.setText("");
     COORDINADOR4.setText("");
     COORDINADOR5.setText("");
     
     String tag = "Coordinador";
     
    switch (pos){
         case 0:
            COORDINADOR0.setText(tag);
            COORDINADOR0.setForeground(Color.CYAN);
            PID0.setBackground(Color.CYAN);
            break;
         case 1:
            COORDINADOR1.setText(tag);
            COORDINADOR1.setForeground(Color.CYAN);
            PID1.setBackground(Color.CYAN);
            break;
         case 2:
            COORDINADOR2.setText(tag);
            COORDINADOR2.setForeground(Color.CYAN);
            PID2.setBackground(Color.CYAN);
            break;
         case 3:
            COORDINADOR3.setText(tag);
            COORDINADOR3.setForeground(Color.CYAN);
            PID3.setBackground(Color.CYAN);
            break;
         case 4:
            COORDINADOR4.setText(tag);
            COORDINADOR4.setForeground(Color.CYAN);
            PID4.setBackground(Color.CYAN);
            break;
         case 5:
            COORDINADOR5.setText(tag);
            COORDINADOR5.setForeground(Color.CYAN);
            PID5.setBackground(Color.CYAN);
            break;
        default:
            break;
     }
    
    
    repaint();
 }
 
 private void desactivarPasosMensajes(){
     
     
                flecha12.setVisible(false);
                flecha23.setVisible(false);
                flecha34.setVisible(false);
                flecha45.setVisible(false);
                flecha56.setVisible(false);
                flecha61.setVisible(false);
                
                ID0.setVisible(false);
                ID1.setVisible(false);
                ID2.setVisible(false);
                ID3.setVisible(false);
                ID4.setVisible(false);
                ID5.setVisible(false);
                
                MENSAJE0.setVisible(false);
                MENSAJE1.setVisible(false);
                MENSAJE2.setVisible(false);
                MENSAJE3.setVisible(false);
                MENSAJE4.setVisible(false);
                MENSAJE5.setVisible(false);
    repaint();
     
 }
 
 private void actualizarPasoDeMensaje(int pos, String mensaje, String tipo){
     
    switch (pos){
         case 0:
            MENSAJE0.setText(mensaje);
            ID0.setText(tipo);
            desactivarPasosMensajes();
            flecha12.setVisible(true);
            ID0.setVisible(true);
            MENSAJE0.setVisible(true);
            break;
         case 1:
            MENSAJE1.setText(mensaje);
            ID1.setText(tipo);
            desactivarPasosMensajes();
            flecha23.setVisible(true);
            ID1.setVisible(true);
            MENSAJE1.setVisible(true);
            break;
         case 2:
            MENSAJE2.setText(mensaje);
            ID2.setText(tipo);
            desactivarPasosMensajes();
            flecha34.setVisible(true);
            ID2.setVisible(true);
            MENSAJE2.setVisible(true);
            break;
         case 3:
            MENSAJE3.setText(mensaje);
            ID3.setText(tipo);
            desactivarPasosMensajes();
            flecha45.setVisible(true);
            ID3.setVisible(true);
            MENSAJE3.setVisible(true);
            break;
         case 4:
            MENSAJE4.setText(mensaje);
            ID4.setText(tipo);
            desactivarPasosMensajes();
            flecha56.setVisible(true);
            ID4.setVisible(true);
            MENSAJE4.setVisible(true);
            break;
         case 5:
            MENSAJE5.setText(mensaje);
            ID5.setText(tipo);
            desactivarPasosMensajes();
            flecha61.setVisible(true);
            ID5.setVisible(true);
            MENSAJE5.setVisible(true);
            break;
        default:
            break;
     }
    
    repaint();
 }
 
 private void iniciarColor(int pos){
     switch (pos){
         case 0:
                PID0.setBackground(Color.GREEN);
            break;
         case 1:
                PID1.setBackground(Color.GREEN);
            break;
         case 2:
                PID2.setBackground(Color.GREEN);
            break;
         case 3:
                PID3.setBackground(Color.GREEN);
            break;
         case 4:
                PID4.setBackground(Color.GREEN);
            break;
         case 5:
                PID5.setBackground(Color.GREEN);
            break;
        default:
            break;
         
     }
    repaint();
 }
    
 
 private void creadoProceso(int pos, String PID, String marca){
     actualizarPid(pos, PID);
     actualizarMarca(pos, marca);
     iniciarColor(pos);
 }
    
 @Override
    public void notify(Evento event, String[] notificacion) {
        String mi_posicion;
        String id;
        String tipo;
        String mensaje;
        String id_siguiente;
        String marca;
        String pid_coordinador;
        String pos_coordinador;
                
        if (null != event)switch (event) {
            case CONECTADO:
                log("[SIMULADOR] Simulador iniciado correctamente.");
                break;
            case ERROR:
                log("[SIMULADOR] Ha ocurrido un error, el simulador ha devuelto: " + notificacion[0] +".");
                break;
            case PROCESO_ANIADIDO:
                log("[SIMULADOR] Se ha añadido un nuevo proceso. ID=" + notificacion[0] +".");
                break;
            case DIFUNDIDO_CORRECTO:
                log("[SIMULADOR] Se ha enviado la lista de procesos al proceso ID=" + notificacion[0] +".");
                break;
                
            case RECIBIRMENSAJE:
                mi_posicion = notificacion[0];
                id = notificacion[1];
                tipo = notificacion[2];
                mensaje = notificacion[3];
                log("[P-"+ id + "] Ha recibido el mensaje \"" + mensaje + "\" de tipo " + tipo);
                
                break;
                
            case ENVIARMENSAJE:
                mi_posicion = notificacion[0];
                id = notificacion[1];
                tipo = notificacion[2];
                mensaje = notificacion[3];
                id_siguiente = notificacion[4];
                marca = notificacion[5];
                log("[P-"+ id + "] Envía el mensaje \"" + mensaje + "\" de tipo " + 
                        tipo + " a P-" + id_siguiente + ".");
                
                actualizarPasoDeMensaje(Integer.valueOf(mi_posicion), mensaje, tipo);
                
                break;
                
            case CREADO:
                mi_posicion = notificacion[0];
                id = notificacion[1];
                marca = notificacion[2];
                log("[P-"+ id + "] Inicializado. Marcado como " + "\"" + marca +"\".");
                
                creadoProceso(Integer.valueOf(mi_posicion), id, marca);
                
                break;
                
            case REVIVIR:
                mi_posicion = notificacion[0];
                id = notificacion[1];
                log("[P-"+ id + "] Activado.");
                break;
                
            case DORMIR:
                mi_posicion = notificacion[0];
                id = notificacion[1];
                log("[P-"+ id + "] Desactivado.");
                break;
            case ACTUALIZARCOORDINADOR:
                mi_posicion = notificacion[0];
                id = notificacion[1];
                log("[P-"+ id + "] Coordinador elegido P-" + id + ".");
                actualizarCoordinador(Integer.valueOf(mi_posicion));
                break;
                
            case ACTUALIZARMARCA:
                mi_posicion = notificacion[0];
                id = notificacion[1];
                marca = notificacion[2];
                log("[P-"+ id + "] Marca actual \"" + marca + "\".");
                
                actualizarMarca(Integer.valueOf(mi_posicion), marca);
                break;
                
            case CONFIRMADO:
                mi_posicion = notificacion[0];
                id = notificacion[1];
                log("[P-"+ id + "] SE CONFIRMA COMO COORDINADOR.");
                desactivarPasosMensajes();
                repaint();
                
                break;
                
                
            default:
                break;
        }
    }


}
