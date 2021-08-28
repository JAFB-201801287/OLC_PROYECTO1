/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto1.controller;

import com.proyecto1.model.Puntaje;
import com.proyecto1.model.Variable;
import java.util.ArrayList;

/**
 *
 * @author jafb
 */
public class VariableController {
    private static VariableController instancia = null;
    private ArrayList<Variable> lista = new ArrayList<Variable>();
    private String rutaProyecto1;
    private String rutaProyecto2;

    public VariableController() {
        
    }
    
    public static synchronized VariableController getInstance() {
      if(instancia == null) {
         instancia = new VariableController();
      }
      return instancia;
   }

    public ArrayList<Variable> getLista() {
        return lista;
    }
    
    public void add(Double valor, String nombreVariable, int linea) {
        Variable<Double> variable = new Variable<Double>("DOUBLE", valor, nombreVariable, linea);
        lista.add(variable);
    }
    
    public void add(String valor, String nombreVariable, int linea) {
        Variable<String> variable = new Variable<String>("STRING", valor, nombreVariable, linea);
        lista.add(variable);
    }
    
    public void add(Puntaje puntaje, int linea) {
        Variable<String> variable = new Variable<String>("DOUBLE", puntaje, linea);
        lista.add(variable);
    }

    public void addRutaProyecto1(String rutaProyecto1) {
        this.rutaProyecto1 = rutaProyecto1;
    }

    public void addRutaProyecto2(String rutaProyecto2) {
        this.rutaProyecto2 = rutaProyecto2;
    }
    
    public void limpiar() {
        lista = new ArrayList<Variable>();
        rutaProyecto1 = "";
        rutaProyecto2 = "";
    }
    
}