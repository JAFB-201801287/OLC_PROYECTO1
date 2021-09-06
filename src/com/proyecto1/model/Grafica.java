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
public class Grafica {
    String tipo;
    Elemento<String> titulo;
    Elemento<String> tituloX;
    Elemento<String> tituloY;
    Elemento<String> archivo;
    ArrayList<Elemento<String>> ejeX;
    ArrayList<Elemento<Double>> valores;

    public Grafica() {
        this.tipo = "";
        this.titulo = new Elemento<String>();
        this.tituloX = new Elemento<String>();
        this.tituloY = new Elemento<String>();
        this.archivo = new Elemento<String>();
        this.ejeX = new ArrayList<Elemento<String>>();
        this.valores = new ArrayList<Elemento<Double>>();
    }

    public Grafica(String tipo, Elemento<String> titulo, ArrayList<Elemento<String>> ejeX, ArrayList<Elemento<Double>> valores) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.ejeX = ejeX;
        this.valores = valores;
    }

    public Grafica(String tipo, Elemento<String> titulo, Elemento<String> archivo) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.archivo = archivo;
    }

    public Grafica(String tipo, Elemento<String> titulo, Elemento<String> tituloX, Elemento<String> tituloY, ArrayList<Elemento<String>> ejeX, ArrayList<Elemento<Double>> valores) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.tituloX = tituloX;
        this.tituloY = tituloY;
        this.ejeX = ejeX;
        this.valores = valores;
    }
    
    

    public Grafica(String tipo, Elemento<String> titulo, Elemento<String> tituloX, Elemento<String> tituloY, Elemento<String> archivo, ArrayList<Elemento<String>> ejeX, ArrayList<Elemento<Double>> valores) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.tituloX = tituloX;
        this.tituloY = tituloY;
        this.archivo = archivo;
        this.ejeX = ejeX;
        this.valores = valores;
    }

    public Elemento<String> getTitulo() {
        return titulo;
    }

    public void setTitulo(Elemento<String> titulo) {
        this.titulo = titulo;
    }

    public Elemento<String> getTituloX() {
        return tituloX;
    }

    public void setTituloX(Elemento<String> tituloX) {
        this.tituloX = tituloX;
    }

    public Elemento<String> getTituloY() {
        return tituloY;
    }

    public void setTituloY(Elemento<String> tituloY) {
        this.tituloY = tituloY;
    }

    public Elemento<String> getArchivo() {
        return archivo;
    }

    public void setArchivo(Elemento<String> archivo) {
        this.archivo = archivo;
    }

    public ArrayList<Elemento<String>> getEjeX() {
        return ejeX;
    }
    
    public void setEjeX(Elemento<String> ejex) {
        this.ejeX.add(ejex);
    }


    public void setEjeX(ArrayList<Elemento<String>> ejeX) {
        this.ejeX = ejeX;
    }

    public ArrayList<Elemento<Double>> getValores() {
        return valores;
    }

    public void setValor(Elemento<Double> valor) {
        this.valores.add(valor) ;
    } 
   
    public void setValores(ArrayList<Elemento<Double>> valores) {
        this.valores = valores;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
