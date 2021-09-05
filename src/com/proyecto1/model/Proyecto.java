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
public class Proyecto {
    private String direccion;
    private ArrayList<Archivo> archivos;
    private ArrayList<ReporteToken> listaTokens;

    public Proyecto() {
        this.direccion = "";
        this.archivos = new ArrayList<Archivo>();
        this.listaTokens = new ArrayList<ReporteToken>();
    }
    
    public Proyecto(String direccion) {
        this.direccion = direccion;
        this.archivos = new ArrayList<Archivo>();
        this.listaTokens = new ArrayList<ReporteToken>();
    }

    public Proyecto(String direccion, ArrayList<Archivo> archivos) {
        this.direccion = direccion;
        this.archivos = archivos;
        this.listaTokens = new ArrayList<ReporteToken>();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Archivo> getArchivos() {
        return archivos;
    }
    
    public void setArchivo(Archivo archivo) {
        this.archivos.add(archivo);
    }

    public void setArchivos(ArrayList<Archivo> archivos) {
        this.archivos = archivos;
    }

    public ArrayList<ReporteToken> getListaTokens() {
        return listaTokens;
    }

    public void setListaTokens(ArrayList<ReporteToken> listaTokens) {
        this.listaTokens = listaTokens;
    }

    public void setListaTokens(ReporteToken token) {
        this.listaTokens.add(token);
    }
    
    
    
}
