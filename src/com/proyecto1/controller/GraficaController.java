/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto1.controller;

import com.proyecto1.model.Elemento;
import com.proyecto1.model.Grafica;
import com.proyecto1.model.Puntaje;
import com.proyecto1.model.ReporteToken;
import java.util.ArrayList;
import java.io.File;

/**
 *
 * @author jafb
 */
public class GraficaController {
    private static GraficaController instancia = null;
    private ArrayList<Grafica> lista = new ArrayList<Grafica>();
    private ArrayList<ReporteToken> listaTokens = new ArrayList<ReporteToken>();
    private Elemento<String> titulo;
    private Elemento<String> archivo;
    private Elemento<String> titulox;
    private Elemento<String> tituloy;
    private ArrayList<Elemento<String>> ejeX = new ArrayList<Elemento<String>>(); 
    private ArrayList<Elemento<Double>> valores = new ArrayList<Elemento<Double>>();
    private String rutaProyecto1;
    private String rutaProyecto2;

    public GraficaController() {
        
    }
    
    public static synchronized GraficaController getInstance() {
      if(instancia == null) {
         instancia = new GraficaController();
      }
      return instancia;
    }
    
    public void addToken(String lexema, String token, int linea) {
        ReporteToken reporte = new ReporteToken(lexema, token, linea);
        listaTokens.add(reporte);
    }
    
    public String[][] getReporteToken() {
        int tamanio = this.listaTokens.size();
        String[][] temp = new String[tamanio][3];
        
        for (int i = 0; i < tamanio; i++) {
            temp[i][0] = this.listaTokens.get(i).getLexema().toString();
            temp[i][1] = this.listaTokens.get(i).getToken().toString();
            temp[i][2] = "" + this.listaTokens.get(i).getLinea();
        }
        
        return  temp;
    }

    public void addTitulo(String valor, String nombreVariable, int linea, int columna) {
        this.titulo = new Elemento<String>("STRING", valor, nombreVariable, linea, columna);
    }

    public void addArchivo(String valor, String nombreVariable, int linea, int columna) {
        this.archivo = new Elemento<String>("STRING", valor, nombreVariable, linea, columna);
    }

    public void addTitulox(String valor, String nombreVariable, int linea, int columna) {
        this.titulox = new Elemento<String>("STRING", valor, nombreVariable, linea, columna);
    }

    public void addTituloy(String valor, String nombreVariable, int linea, int columna) {
        this.tituloy = new Elemento<String>("STRING", valor, nombreVariable, linea, columna);
    }

    public void addEjeX(String valor, String nombreVariable, int linea, int columna) {
        this.ejeX.add(new Elemento<String>("STRING", valor, nombreVariable, linea, columna) );
    }
    
    public void addValor(Double valor, String nombreVariable, int linea, int columna) {
        this.valores.add(new Elemento<Double>("Double", valor, nombreVariable, linea, columna) );
    }
    
    public void addValor(Puntaje puntaje, int linea, int columna) {
        this.valores.add(new Elemento<Double>("Double", puntaje, linea, columna) );
    }
    
    public void addRutaProyecto1(String rutaProyecto1) {
        this.rutaProyecto1 = rutaProyecto1;
    }

    public void addRutaProyecto2(String rutaProyecto2) {
        this.rutaProyecto2 = rutaProyecto2;
    }
    
    public void addGraficaBarras() {
        lista.add(new Grafica("GRAFICA_BARRAS", titulo, titulox, tituloy, ejeX, valores));
        limpiarGrafica();
    }
    
    public void addGraficaPie() {
        lista.add(new Grafica("GRAFICA_PIE", titulo, ejeX, valores));
        limpiarGrafica();
    }
    
    public void addGraficaLineas() {
        lista.add(new Grafica("GRAFICA_LINEAS", titulo, archivo));
        limpiarGrafica();
    }
    
    public File buscarFichero(String directorio, String archivo) {
        File carpeta = new File(directorio);
        
        if(carpeta.exists()) {
            for (File f: carpeta.listFiles()) {
                
                if(f.getName().equals(archivo)) {
                    return f;
                }
                
                if(f.isDirectory()) {
                    File temp = buscarFichero(f.getAbsolutePath(), archivo);
                    
                    if(temp != null) {
                        return temp;
                    }
                }
            }
        } else {
            System.out.println("CARPETA DE PROYECTO NO ENCONTRADA.");
        }

        return null; 
    }
    
    private void limpiarGrafica() {
        titulo = new Elemento<String>();
        archivo = new Elemento<String>();
        titulox = new Elemento<String>();
        tituloy = new Elemento<String>();
        ejeX = new ArrayList<Elemento<String>>(); 
        valores = new ArrayList<Elemento<Double>>();
    }
 
    public void limpiar() {
        lista = new ArrayList<Grafica>();
        listaTokens = new ArrayList<ReporteToken>();
        titulo = new Elemento<String>();
        archivo = new Elemento<String>();
        titulox = new Elemento<String>();
        tituloy = new Elemento<String>();
        ejeX = new ArrayList<Elemento<String>>(); 
        valores = new ArrayList<Elemento<Double>>();
        rutaProyecto1 = "";
        rutaProyecto2 = "";
    }
}
