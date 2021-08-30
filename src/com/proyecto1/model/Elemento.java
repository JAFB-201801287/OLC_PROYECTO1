/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto1.model;

/**
 *
 * @author jafb
 */
public class Elemento<T> {
    String tipo;
    T valor;
    String nombreVariable;
    int linea;
    int columna;
    Puntaje puntaje;

    public Elemento() {
        this.tipo = "";
        this.nombreVariable = "";
        this.linea = 0;
        this.puntaje = new Puntaje();
        this.columna = 0;
    }
    
    public Elemento(String tipo, Puntaje puntaje, int line, int columna) {
        this.tipo = tipo;
        this.nombreVariable = "";
        this.linea = 0;
        this.puntaje = puntaje;
        this.columna = columna;
    }


    public Elemento(String tipo, T valor, String nombreVariable, int linea, int columna) {
        this.tipo = tipo;
        this.valor = valor;
        this.nombreVariable = nombreVariable;
        this.linea = linea;
        this.columna = columna;
        this.puntaje = null;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public String getNombreVariable() {
        return nombreVariable;
    }

    public void setNombreVariable(String nombreVariable) {
        this.nombreVariable = nombreVariable;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public Puntaje getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Puntaje puntaje) {
        this.puntaje = puntaje;
    }
    
    
}
