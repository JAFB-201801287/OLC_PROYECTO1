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
public class Variable<T> extends  Elemento<T> {

    public Variable() {
        super();
    }
    
    public Variable(String tipo,Puntaje puntaje, int line, int columna) {
        super(tipo, puntaje, line, columna);
    }
    
    public Variable(String tipo,Puntaje puntaje, String nombreVariable, int line, int columna) {
        super(tipo, puntaje, nombreVariable, line, columna);
    }

    public Variable(String tipo, T valor, String nombreVariable, int linea, int columna) {
        super(tipo, valor, nombreVariable, linea, columna);
    }

}
