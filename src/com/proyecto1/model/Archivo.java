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
    private Elemento<String> clase;
    private Elemento<String> metodo;
    private Elemento<String> funcion;
    private Elemento<String> comentario;
    private ArrayList<ReporteToken> listaTokens;
    private int lineas;
    

    public Archivo() {
        this.nombre = "";
        this.clase = new Elemento<String>();
        this.metodo = new Elemento<String>();
        this.funcion = new Elemento<String>();
        this.comentario = new Elemento<String>();
        this.listaTokens = new ArrayList<ReporteToken>();
        this.lineas = 0;
    }

    public Archivo(String nombre, Elemento<String> clase, Elemento<String> metodo, Elemento<String> funcion, Elemento<String> comentario, int lineas) {
        this.nombre = nombre;
        this.clase = clase;
        this.metodo = metodo;
        this.funcion = funcion;
        this.comentario = comentario;
        this.listaTokens = new ArrayList<ReporteToken>();
        this.lineas = lineas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Elemento<String> getClase() {
        return clase;
    }

    public void setClase(Elemento<String> clase) {
        this.clase = clase;
    }

    public Elemento<String> getMetodo() {
        return metodo;
    }

    public void setMetodo(Elemento<String> metodo) {
        this.metodo = metodo;
    }

    public Elemento<String> getFuncion() {
        return funcion;
    }

    public void setFuncion(Elemento<String> funcion) {
        this.funcion = funcion;
    }

    public Elemento<String> getComentario() {
        return comentario;
    }

    public void setComentario(Elemento<String> comentario) {
        this.comentario = comentario;
    }

    public ArrayList<ReporteToken> getListaTokens() {
        return listaTokens;
    }

    public void setListaTokens(ArrayList<ReporteToken> listaTokens) {
        this.listaTokens = listaTokens;
    }

    public int getLineas() {
        return lineas;
    }

    public void setLineas(int lineas) {
        this.lineas = lineas;
    }
    
    
}
