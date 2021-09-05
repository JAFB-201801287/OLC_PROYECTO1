/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto1.model;

import java.util.ArrayList;

/**
 *
 * @author jafb
 */
public class Archivo {
    private String nombre;
    private ArrayList<Clase1> clase;
    private ArrayList<Metodo> metodo;
    private ArrayList<String> variable;
    private ArrayList<String> comentario;
    private int lineas;
    

    public Archivo() {
        this.nombre = "";
        this.clase = new ArrayList<Clase1>();
        this.metodo = new ArrayList<Metodo>();
        this.variable = new ArrayList<String>();
        this.comentario = new ArrayList<String>();
        this.lineas = 0;
    }
    
    public Archivo(ArrayList<ReporteToken> listaTokens) {
        this.nombre = "";
        this.clase = new ArrayList<Clase1>();
        this.metodo = new ArrayList<Metodo>();
        this.variable = new ArrayList<String>();
        this.comentario = new ArrayList<String>();
        this.lineas = 0;
    }

    public Archivo(String nombre, ArrayList<Clase1> clase, ArrayList<Metodo> metodo, ArrayList<String> funcion, ArrayList<String> comentario, int lineas) {
        this.nombre = nombre;
        this.clase = clase;
        this.metodo = metodo;
        this.variable = funcion;
        this.comentario = comentario;
        this.lineas = lineas;
    }

    public Archivo(String nombre, ArrayList<Clase1> clase, ArrayList<Metodo> metodo, ArrayList<String> variable, ArrayList<String> comentario, ArrayList<ReporteToken> listaTokens, int lineas) {
        this.nombre = nombre;
        this.clase = clase;
        this.metodo = metodo;
        this.variable = variable;
        this.comentario = comentario;
        this.lineas = lineas;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Clase1> getClase() {
        return clase;
    }

    public void setClase(Clase1 clase) {
        this.clase.add(clase);
    }

    public ArrayList<Metodo> getMetodo() {
        return metodo;
    }

    public void setMetodo(Metodo metodo) {
        this.metodo.add(metodo);
    }

    public ArrayList<String> getFuncion() {
        return variable;
    }

    public void setFuncion(String funcion) {
        this.variable.add(funcion);
    }

    public ArrayList<String> getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario.add(comentario);
    }

    public int getLineas() {
        return lineas;
    }

    public void setLineas(int lineas) {
        this.lineas = lineas;
    }

    public ArrayList<String> getVariable() {
        return variable;
    }

    public void setVariable(ArrayList<String> variable) {
        this.variable = variable;
    }
    
    public void setVariable(String variable) {
        this.variable.add(variable);
    }
    
}
