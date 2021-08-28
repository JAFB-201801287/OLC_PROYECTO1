/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto1.controller;

import com.proyecto1.model.Elemento;
import com.proyecto1.model.Grafica;
import com.proyecto1.model.Puntaje;
import java.util.ArrayList;
import java.io.File;

/**
 *
 * @author jafb
 */
public class GraficaController {
    private static GraficaController instancia = null;
    private ArrayList<Grafica> lista = new ArrayList<Grafica>();
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

    public void add() {
        //this.lista = lista;
    }

    public void addTitulo(String valor, String nombreVariable, int linea) {
        this.titulo = new Elemento<String>("STRING", valor, nombreVariable, linea);
    }

    public void addArchivo(String valor, String nombreVariable, int linea) {
        this.archivo = new Elemento<String>("STRING", valor, nombreVariable, linea);
    }

    public void addTitulox(String valor, String nombreVariable, int linea) {
        this.titulox = new Elemento<String>("STRING", valor, nombreVariable, linea);
    }

    public void addTituloy(String valor, String nombreVariable, int linea) {
        this.tituloy = new Elemento<String>("STRING", valor, nombreVariable, linea);
    }

    public void addEjeX(String valor, String nombreVariable, int linea) {
        this.ejeX.add(new Elemento<String>("STRING", valor, nombreVariable, linea) );
    }
    
    public void addValor(Double valor, String nombreVariable, int linea) {
        this.valores.add(new Elemento<Double>("Double", valor, nombreVariable, linea) );
    }
    
    public void addValor(Puntaje puntaje, int linea) {
        this.valores.add(new Elemento<Double>("Double", puntaje, linea) );
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
