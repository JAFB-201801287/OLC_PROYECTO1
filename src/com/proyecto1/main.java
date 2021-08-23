/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto1;

import java.io.File;

/**
 *
 * @author Jose Andres Flores Barco 
 * @carne 201801257
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Sirve");
        String ruta = "/home/jafb/NetBeansProjects/OLC_PROYECTO1/src/com/proyecto1/compiler/analyzer/Lexer.flex";
        generarLexer(ruta);
        
    }
    
    public static void generarLexer(String ruta) {
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
    
}
