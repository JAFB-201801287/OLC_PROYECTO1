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
public class Metodo {
    private String identificador;
    private ArrayList<String> paramentros;
    private int lineas;

    public Metodo() {
        this.identificador = "";
        this.paramentros = new ArrayList<String>();
        this.lineas = 0;
    }

    public Metodo(String identificador, ArrayList<String> paramentros, int lineas) {
        this.identificador = identificador;
        this.paramentros = paramentros;
        this.lineas = lineas;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public ArrayList<String> getParamentros() {
        return paramentros;
    }

    public void setParamentros(ArrayList<String> paramentros) {
        this.paramentros = paramentros;
    }

    public void setParamentros(String paramentro) {
        this.paramentros.add(paramentro);
    }
    
    public int getLineas() {
        return lineas;
    }

    public void setLineas(int lineas) {
        this.lineas = lineas;
    }
    
    
}
