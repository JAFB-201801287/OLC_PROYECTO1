/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto1;


import com.proyecto1.view.EditorTexto;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 *
 * @author Jose Andres Flores Barco 
 * @carne 201801257
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception { 
        //generar1();
        generar2();
        
        EditorTexto editorTexto = new EditorTexto();
        editorTexto.setVisible(true);
       
    }
    
    public static void generar1() throws IOException, Exception{
        String ruta1 = "/home/jafb/NetBeansProjects/OLC_PROYECTO1/src/com/proyecto1/compiler/analyzer/reporteria/Lexer.flex";
        String ruta2 = "/home/jafb/NetBeansProjects/OLC_PROYECTO1/src/com/proyecto1/compiler/analyzer/reporteria/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "/home/jafb/NetBeansProjects/OLC_PROYECTO1/src/com/proyecto1/compiler/analyzer/reporteria/Sintax.cup"};
        File archivo;
        
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("/home/jafb/NetBeansProjects/OLC_PROYECTO1/src/com/proyecto1/compiler/analyzer/reporteria/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("/home/jafb/NetBeansProjects/OLC_PROYECTO1/sym.java"), 
                Paths.get("/home/jafb/NetBeansProjects/OLC_PROYECTO1/src/com/proyecto1/compiler/analyzer/reporteria/sym.java")
        );
        
        Path rutaSin = Paths.get("/home/jafb/NetBeansProjects/OLC_PROYECTO1/src/com/proyecto1/compiler/analyzer/reporteria/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("/home/jafb/NetBeansProjects/OLC_PROYECTO1/Sintax.java"), 
                Paths.get("/home/jafb/NetBeansProjects/OLC_PROYECTO1/src/com/proyecto1/compiler/analyzer/reporteria/Sintax.java")
        );
       
    }
    
    public static void generar2() throws IOException, Exception{
        String ruta1 = "/home/jafb/NetBeansProjects/OLC_PROYECTO1/src/com/proyecto1/compiler/analyzer/javascript/Lexer.flex";
        String ruta2 = "/home/jafb/NetBeansProjects/OLC_PROYECTO1/src/com/proyecto1/compiler/analyzer/javascript/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "/home/jafb/NetBeansProjects/OLC_PROYECTO1/src/com/proyecto1/compiler/analyzer/javascript/Sintax.cup"};
        File archivo;
        
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("/home/jafb/NetBeansProjects/OLC_PROYECTO1/src/com/proyecto1/compiler/analyzer/javascript/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("/home/jafb/NetBeansProjects/OLC_PROYECTO1/sym.java"), 
                Paths.get("/home/jafb/NetBeansProjects/OLC_PROYECTO1/src/com/proyecto1/compiler/analyzer/javascript/sym.java")
        );
        
        Path rutaSin = Paths.get("/home/jafb/NetBeansProjects/OLC_PROYECTO1/src/com/proyecto1/compiler/analyzer/javascript/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("/home/jafb/NetBeansProjects/OLC_PROYECTO1/Sintax.java"), 
                Paths.get("/home/jafb/NetBeansProjects/OLC_PROYECTO1/src/com/proyecto1/compiler/analyzer/javascript/Sintax.java")
        );
       
    }
    
}
