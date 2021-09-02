/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto1.view;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.io.IOException;
import java.io.StringReader;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;

import com.proyecto1.controller.VariableController;
import com.proyecto1.controller.GraficaController;
import javax.swing.table.DefaultTableModel;

import com.proyecto1.compiler.analyzer.reporteria.Lexer;
import com.proyecto1.compiler.analyzer.reporteria.Sintax;
import com.proyecto1.compiler.analyzer.reporteria.Tokens;
import com.proyecto1.compiler.analyzer.reporteria.LexicoCup;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author jafb
 */
public class EditorTexto extends javax.swing.JFrame {
    
    private int idPestana;
    private JTextArea editor;
    private JScrollPane panelEditor;
    private DefaultTableModel modeloTabla;

    /**
     * Creates new form EditorTexto
     */
    public EditorTexto() {
        idPestana = 0;
        initComponents();
        crearPestana();
        //initTable();
        
        //ImageIcon imagen = new ImageIcon("src/com/proyecto1/resorces/archivos.png");
        //this.btnArchivo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(this.btnArchivo.getWidth(), this.btnArchivo.getHeight(), Image.SCALE_SMOOTH)));
        //this.btnArchivo.setToolTipText("ARCHIVO");
    }
    
    private void initTable() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("LEXEMA");
        modeloTabla.addColumn("TOKEN");
        modeloTabla.addColumn("LINEA");
        tableLex.setModel(modeloTabla);
    }
    
    private void analizadorLexico() throws IOException {
        int linea = 1;
        JScrollPane panelTemp = (JScrollPane) jTabbedPane1.getSelectedComponent();
        JTextArea editorTemp = (JTextArea) panelTemp.getViewport().getView();
        String consola = "";
        String tempText = editorTemp.getText().replace(",","<COMA8264>");
        Lexer lexer = new Lexer(new StringReader(tempText));
        Formatter formatoLinea = new Formatter();

        consola += " INICIANDO ANALISIS LEXICO\n";
        consola += "     LINEA \t "  + String.format("%-40s", "TOKEN") + "\t" + "LEXEMA\n" ;
        
        while (true) {
            Tokens token = lexer.yylex();
            formatoLinea = new Formatter();
            formatoLinea.format("%05d", linea);
            String tipoToken = "";
            boolean bandera = true;
            
            if (token == null) {
                break;
            }

            switch (token) {
                case Linea:
                    linea++;
                    bandera = false;
                    break;
                case STRING:
                    tipoToken = "TIPO_DE_DATO_STRING";
                    break;
                case DOUBLE:
                    tipoToken = "TIPO_DE_DOUBLE";
                    break;
                case Igual:
                    tipoToken = "IGUAL";
                    break;
                case ParentesisInicio:
                    tipoToken = "PARENTESIS_INICIO";
                    break;
                case ParentesisFinal:
                    tipoToken = "PARENTESIS_FINAL";
                    break;
                case LlaveInicio:
                    tipoToken = "LLAVE_INICIO";
                    break;
                case LlaveFinal:
                    tipoToken = "LLAVE_CIERRE";
                    break;
                case CorcheteInicio:
                    tipoToken = "CORCHETE_INICIO";
                    break;
                case CorcheteFinal:
                    tipoToken = "CORCHETE_FINAL";
                    break;
                case Coma:
                    tipoToken = "COMA";
                    break;
                case PuntoComa:
                    tipoToken = "PUNTO_Y_COMA";
                    break;
                case DosPuntos:
                    tipoToken = "DOS_PUNTOS";
                    break;
                case Dollar:
                    tipoToken = "DOLLAR";
                    break;
                case PuntajeGeneral:
                    tipoToken = "PUNTAJE_GENERAL";
                    break;
                case PuntajeEspecifico:
                    tipoToken = "PUNTAJE_ESPECIFICO";
                    break;
                case DefinirGlobales:
                    tipoToken = "DEFINIR_GLOBALES";
                    break;
                case GenerarReporteEstadistico:
                    tipoToken = "GENERAR_REPORTES_ESTADISTICO";
                    break;
                case GraficaBarras:
                    tipoToken = "GRAFICA_BARRAS";
                    break;
                case GraficaPie:
                    tipoToken = "GRAFICA_PIE";
                    break;
                case GraficaLineas:
                    tipoToken = "GRAFICA_LINEAS";
                    break;
                case Compare:
                    tipoToken = "COMPARE";
                    break;
                case Titulo:
                    tipoToken = "TITULO";
                    break;
                case Archivo:
                    tipoToken = "ARCHIVO";
                    break;
                case EjeX:
                    tipoToken = "EJE_X";
                    break;
                case TituloX:
                    tipoToken = "TITULO_X";
                    break;
                case TituloY:
                    tipoToken = "TITULO_Y";
                    break;
                case Valores:
                    tipoToken = "VALORES";
                    break;
                case Decimal:
                    tipoToken = "NUMERO_DECIMAL";
                    break;
                case Ruta:
                    tipoToken = "RUTA";
                    break;
                case Cadena:
                    tipoToken = "CADENA_DE_TEXTO";
                    break;
                case Identificador:
                    tipoToken = "IDENTIFICADOR";
                    break;
                case ERROR:
                    tipoToken = "ERROR";
                    break;
                default:
                    bandera = false;
                    break;
            }
            if(bandera) {
                //consola += "     " + formatoLinea + "\t" + String.format("%-40s", tipoToken) + "\t" + lexer.lexeme + "\n";
                GraficaController.getInstance().addToken(lexer.lexeme, tipoToken, linea);
            }
            
        };
        consola += " FIN ANALISIS LEXICO\n";
        
        tableLex.setModel(new javax.swing.table.DefaultTableModel(
            GraficaController.getInstance().getReporteToken(),
            new String [] {
                "LEXEMA", "TOKEN", "LINEA"
            }
        ));
    }
    
    private void analizadorSintactico() throws IOException {
        VariableController.getInstance().limpiar();
        GraficaController.getInstance().limpiar();
        String consola = "";
        JScrollPane panelTemp = (JScrollPane) jTabbedPane1.getSelectedComponent();
        JTextArea editorTemp = (JTextArea) panelTemp.getViewport().getView();
        String tempText = editorTemp.getText().replace(",","<COMA8264>");
        tempText = tempText.replace("“", "\"");
        tempText = tempText.replace("”", "\"");
        tempText = tempText.replace("‘", "\'");
        tempText = tempText.replace("’", "\'");
        Sintax sintax = new Sintax(new LexicoCup(new StringReader(tempText)));
        
        try {
            sintax.parse();
            txtSintatico.setForeground(Color.GREEN);
            txtSintatico.setText("ANALISIS SINTACTICO REALIZADO CORRECTAMENTE."); 
            analizadorSemantico();
        } catch (Exception ex) {
            Symbol sym = sintax.getSimbolo();     
            txtSintatico.setForeground(Color.RED);
            txtSintatico.setText("ERROR SINTACTICO. LINEA: " + (sym.right + 1) + ", TEXTO: \"" + sym.value + "\"");
        }
       
    }
    
    private void analizadorSemantico() throws IOException {
        VariableController.getInstance().inicializarVariables();
    }
    
    private void crearPestana() {
        editor = new JTextArea();
        panelEditor = new JScrollPane();
        
        editor.setColumns(20);
        editor.setRows(5);
        panelEditor.setViewportView(editor);

        jTabbedPane1.addTab("PESTAÑA " + idPestana, panelEditor);
        idPestana++;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnArchivo = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        crearPestana = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        eliminarPestana = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        ejecutar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        reportes = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnGuardar = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btnGuardar1 = new javax.swing.JButton();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableLex = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSintatico = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtLector = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" PROYECTO 1 - FIUSAC COPY ANALYZER FIUSAC");
        setBackground(java.awt.Color.lightGray);
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setSize(new java.awt.Dimension(1400, 900));

        jLabel1.setFont(new java.awt.Font("Ubuntu Light", 1, 30)); // NOI18N
        jLabel1.setText(" PROYECTO 1 - FIUSAC COPY ANALYZER FIUSAC");

        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setRollover(true);
        jToolBar1.setPreferredSize(new java.awt.Dimension(100, 50));
        jToolBar1.add(jSeparator1);

        btnArchivo.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        btnArchivo.setText("ARCHIVO");
        btnArchivo.setFocusable(false);
        btnArchivo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnArchivo.setMargin(new java.awt.Insets(0, 20, 0, 20));
        btnArchivo.setMinimumSize(new java.awt.Dimension(150, 50));
        btnArchivo.setPreferredSize(new java.awt.Dimension(150, 50));
        btnArchivo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnArchivo);
        jToolBar1.add(jSeparator7);

        crearPestana.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        crearPestana.setText("CREAR PESTAÑA");
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
        jToolBar1.add(jSeparator2);

        eliminarPestana.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        eliminarPestana.setText("ELIMINAR PESTAÑA");
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
        jToolBar1.add(jSeparator3);

        ejecutar.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        ejecutar.setText("EJECUTAR");
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
        jToolBar1.add(jSeparator4);

        reportes.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        reportes.setText("REPORTES");
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
        jToolBar1.add(jSeparator5);

        btnGuardar.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setMargin(new java.awt.Insets(0, 20, 0, 20));
        btnGuardar.setMinimumSize(new java.awt.Dimension(150, 50));
        btnGuardar.setPreferredSize(new java.awt.Dimension(150, 50));
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);
        jToolBar1.add(jSeparator6);

        btnGuardar1.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        btnGuardar1.setText(" GUARDAR COMO");
        btnGuardar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar1.setMargin(new java.awt.Insets(0, 20, 0, 20));
        btnGuardar1.setMinimumSize(new java.awt.Dimension(150, 50));
        btnGuardar1.setPreferredSize(new java.awt.Dimension(150, 50));
        btnGuardar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar1);

        jSplitPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 25)); // NOI18N
        jLabel2.setText("CONSOLA");

        tableLex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "LEXEMA", "TOKEN", "LINEA"
            }
        ));
        jScrollPane2.setViewportView(tableLex);

        jLabel4.setText("ANALIZADOR SINTÁCTICO");

        txtSintatico.setColumns(20);
        txtSintatico.setRows(5);
        jScrollPane1.setViewportView(txtSintatico);

        jLabel5.setText("ANALIZADOR LÉXICO");

        jLabel6.setText("LECTOR DE ARCHIVO");

        txtLector.setColumns(20);
        txtLector.setRows(5);
        jScrollPane3.setViewportView(txtLector);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(jLabel5)
                    .addContainerGap(543, Short.MAX_VALUE)))
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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane2.setLeftComponent(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSplitPane2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1078, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 701, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void crearPestanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearPestanaActionPerformed
        crearPestana();
    }//GEN-LAST:event_crearPestanaActionPerformed

    private void eliminarPestanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPestanaActionPerformed
        int tabIndex = jTabbedPane1.getSelectedIndex();
        jTabbedPane1.remove(tabIndex);
    }//GEN-LAST:event_eliminarPestanaActionPerformed

    private void ejecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarActionPerformed
        try {
            analizadorLexico();
            analizadorSintactico();

        } catch (IOException ex) {
            Logger.getLogger(EditorTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ejecutarActionPerformed

    private void reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportesActionPerformed
        System.out.println("REPORTES");
    }//GEN-LAST:event_reportesActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton crearPestana;
    private javax.swing.JButton ejecutar;
    private javax.swing.JButton eliminarPestana;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton reportes;
    private javax.swing.JTable tableLex;
    private javax.swing.JTextArea txtLector;
    private javax.swing.JTextArea txtSintatico;
    // End of variables declaration//GEN-END:variables
}
