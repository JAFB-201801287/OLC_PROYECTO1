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
public class ReporteToken {
    String lexema;
    String token;
    int linea;
    int columna;
    String archivo;

    public ReporteToken() {
        this.lexema = "";
        this.token = "";
        this.linea = 0;
        this.columna = 0;
        this.archivo = "";
    }

    public ReporteToken(String lexema, String token, int linea) {
        this.lexema = lexema;
        this.token = token;
        this.linea = linea;
        this.columna = columna;
    }

    public ReporteToken(String lexema, String token, int linea, String archivo) {
        this.lexema = lexema;
        this.token = token;
        this.linea = linea;
        this.columna = 0;
        this.archivo = archivo;
    }
    
    public ReporteToken(String lexema, String token, int linea, int columna, String archivo) {
        this.lexema = lexema;
        this.token = token;
        this.linea = linea;
        this.columna = columna;
        this.archivo = archivo;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    
    
}
