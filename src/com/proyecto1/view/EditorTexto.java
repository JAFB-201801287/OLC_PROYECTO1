/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto1.view;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author jafb
 */
public class EditorTexto extends javax.swing.JFrame {
    
    private int idPestana;
    private JTextArea editor;
    private JScrollPane panelEditor;

    /**
     * Creates new form EditorTexto
     */
    public EditorTexto() {
        idPestana = 1;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        archivo = new javax.swing.JButton();
        crearPestana = new javax.swing.JButton();
        eliminarPestana = new javax.swing.JButton();
        ejecutar = new javax.swing.JButton();
        reportes = new javax.swing.JButton();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" PROYECTO 1 - FIUSAC COPY ANALYZER FIUSAC");
        setBackground(java.awt.Color.lightGray);
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setSize(new java.awt.Dimension(1400, 900));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 25)); // NOI18N
        jLabel1.setText(" PROYECTO 1 - FIUSAC COPY ANALYZER FIUSAC");

        jToolBar1.setRollover(true);
        jToolBar1.setPreferredSize(new java.awt.Dimension(100, 50));

        archivo.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        archivo.setText("ARCHIVO");
        archivo.setFocusable(false);
        archivo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        archivo.setMargin(new java.awt.Insets(0, 20, 0, 20));
        archivo.setMinimumSize(new java.awt.Dimension(150, 50));
        archivo.setPreferredSize(new java.awt.Dimension(150, 50));
        archivo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivoActionPerformed(evt);
            }
        });
        jToolBar1.add(archivo);
        archivo.getAccessibleContext().setAccessibleName("archivo");

        crearPestana.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        crearPestana.setText("CREAR PESTAÑA");
        crearPestana.setFocusable(false);
        crearPestana.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        crearPestana.setMargin(new java.awt.Insets(0, 20, 0, 20));
        crearPestana.setMinimumSize(new java.awt.Dimension(150, 50));
        crearPestana.setPreferredSize(new java.awt.Dimension(150, 50));
        crearPestana.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        crearPestana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearPestanaActionPerformed(evt);
            }
        });
        jToolBar1.add(crearPestana);

        eliminarPestana.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        eliminarPestana.setText("ELIMINAR PESTAÑA");
        eliminarPestana.setFocusable(false);
        eliminarPestana.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eliminarPestana.setMargin(new java.awt.Insets(0, 20, 0, 20));
        eliminarPestana.setMinimumSize(new java.awt.Dimension(150, 50));
        eliminarPestana.setPreferredSize(new java.awt.Dimension(150, 50));
        eliminarPestana.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        eliminarPestana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPestanaActionPerformed(evt);
            }
        });
        jToolBar1.add(eliminarPestana);

        ejecutar.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        ejecutar.setText("EJECUTAR");
        ejecutar.setFocusable(false);
        ejecutar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ejecutar.setMargin(new java.awt.Insets(0, 20, 0, 20));
        ejecutar.setMinimumSize(new java.awt.Dimension(150, 50));
        ejecutar.setPreferredSize(new java.awt.Dimension(150, 50));
        ejecutar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutarActionPerformed(evt);
            }
        });
        jToolBar1.add(ejecutar);

        reportes.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        reportes.setText("REPORTES");
        reportes.setFocusable(false);
        reportes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        reportes.setMargin(new java.awt.Insets(0, 20, 0, 20));
        reportes.setMinimumSize(new java.awt.Dimension(150, 50));
        reportes.setPreferredSize(new java.awt.Dimension(150, 50));
        reportes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportesActionPerformed(evt);
            }
        });
        jToolBar1.add(reportes);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 25)); // NOI18N
        jLabel2.setText("CONSOLA");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane2.setRightComponent(jPanel2);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 25)); // NOI18N
        jLabel3.setText("EDITOR DE TEXTO");

        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane2.setLeftComponent(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSplitPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1009, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 682, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void archivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivoActionPerformed
        System.out.println("ARCHIVO");
    }//GEN-LAST:event_archivoActionPerformed

    private void crearPestanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearPestanaActionPerformed
        editor = new JTextArea();
        panelEditor = new JScrollPane();
        
        editor.setColumns(20);
        editor.setRows(5);
        panelEditor.setViewportView(editor);

        jTabbedPane1.addTab("PESTAÑA " + idPestana, panelEditor);
        idPestana++;
    }//GEN-LAST:event_crearPestanaActionPerformed

    private void eliminarPestanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPestanaActionPerformed
        int tabIndex = jTabbedPane1.getSelectedIndex();
        jTabbedPane1.remove(tabIndex);
    }//GEN-LAST:event_eliminarPestanaActionPerformed

    private void ejecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarActionPerformed
        System.out.println("EJECUTAR");
    }//GEN-LAST:event_ejecutarActionPerformed

    private void reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportesActionPerformed
        System.out.println("REPORTES");
    }//GEN-LAST:event_reportesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton archivo;
    private javax.swing.JButton crearPestana;
    private javax.swing.JButton ejecutar;
    private javax.swing.JButton eliminarPestana;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton reportes;
    // End of variables declaration//GEN-END:variables
}
