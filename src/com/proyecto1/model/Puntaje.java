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
public class Puntaje {
    String tipoPuntaje;
    String nombreArchivo;
    String valor;
    String identificador;

    public Puntaje() {
        this.tipoPuntaje = "";
        this.nombreArchivo = "";
        this.identificador = "";
        this.valor = "";
    }
    
    public Puntaje(String tipoPuntaje) {
        this.tipoPuntaje = tipoPuntaje;
        this.nombreArchivo = "";
        this.identificador = "";
        this.valor = "";
    }

    public Puntaje(String tipoPuntaje, String nombreArchivo, String valor, String identificador) {
        this.tipoPuntaje = tipoPuntaje;
        this.nombreArchivo = nombreArchivo;
        this.valor = valor;
        this.identificador = identificador;
    }

    public String getTipoPuntaje() {
        return tipoPuntaje;
    }

    public void setTipoPuntaje(String tipoPuntaje) {
        this.tipoPuntaje = tipoPuntaje;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    
    
}
