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
public class Clase1 {
    private String identificador;
    private ArrayList<String> metodos;
    private int lineas;

    public Clase1() {
        this.identificador = "";
        this.metodos = new ArrayList<String>();
        this.lineas = 0;
    }

    public Clase1(String identificador, ArrayList<String> metodos, int lineas) {
        this.identificador = identificador;
        this.metodos = metodos;
        this.lineas = lineas;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public ArrayList<String> getMetodos() {
        return metodos;
    }

    public void setMetodos(ArrayList<String> metodos) {
        this.metodos = metodos;
    }

    public void setMetodos(String metodo) {
        this.metodos.add(metodo);
    }
    
    public int getLineas() {
        return lineas;
    }

    public void setLineas(int lineas) {
        this.lineas = lineas;
    }
    
    
}
