/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto1.controller;

import com.proyecto1.model.Proyecto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import com.proyecto1.compiler.analyzer.javascript.Lexer;
import com.proyecto1.compiler.analyzer.javascript.Sintax;
import com.proyecto1.compiler.analyzer.javascript.Tokens;
import com.proyecto1.compiler.analyzer.javascript.LexicoCup;
import com.proyecto1.model.Archivo;
import com.proyecto1.model.ReporteToken;
import java.io.StringReader;
import java.util.ArrayList;
import java_cup.runtime.Symbol;

/**
 *
 * @author jafb
 */
public class ProyectoController {
    private static ProyectoController instancia = null;
    private Proyecto proyecto1;
    private Proyecto proyecto2;
    private boolean esProyecto1;
    private Archivo archivo;
    
    public static synchronized ProyectoController getInstance() {
      if(instancia == null) {
         instancia = new ProyectoController();
      }
      return instancia;
    }

    private void setEsProyecto1(boolean esProyecto1) {
        this.esProyecto1 = esProyecto1;
    }
    
    public void addProyecto1(String direccion) throws IOException {
        this.proyecto1 = new Proyecto(direccion);
        setEsProyecto1(true);
        reccorrerFichero(direccion);
    }

    public void addProyecto2(String direccion) throws IOException {
        this.proyecto2 = new Proyecto(direccion);
        setEsProyecto1(false);
        reccorrerFichero(direccion);
    }
    
    public File reccorrerFichero(String directorio) throws FileNotFoundException, IOException {
        File carpeta = new File(directorio);
        
        if(carpeta.exists()) {
            for (File f: carpeta.listFiles()) {
                
                if(f.isDirectory()) {
                    File temp = reccorrerFichero(f.getAbsolutePath());
                    
                    if(temp != null) {
                        return temp;
                    }
                } else {
                    if(f.getName().endsWith(".js")) {
                        lectorArchivo(f);
                    }
                }
            }
        } else {
            System.out.println("CARPETA DE PROYECTO NO ENCONTRADA.");
        }

        return null; 
    }
    
    private void lectorArchivo(File file) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
        String temp = "";
        String linea = "";
        
        while((linea = br.readLine()) != null) {
            temp += (linea + "\n");
        }
        
        archivo = new Archivo();
        analizadorLexico(temp, file);
        analizadorSintatico(temp, file);
        if(esProyecto1) {
            this.proyecto1.setArchivo(archivo);
        } else {
            this.proyecto2.setArchivo(archivo);
        }
    }
    
    private void analizadorLexico(String texto, File file) throws IOException {
        int linea = 1;
        String consola = "";
        String tempText = texto.replace(",","#COMA8264#");
        Lexer lexer = new Lexer(new StringReader(tempText));
        ArrayList<ReporteToken> listaTokens = new ArrayList<ReporteToken>();
        archivo.setNombre(file.getName());
        
        while (true) {
            Tokens token = lexer.yylex();
            String tipoToken = "";
            boolean bandera = true;
            
            if (token == null) {
                break;
            }

            switch (token) {
                case Linea:
                    linea++;
                    bandera = false;
                    break;
                case Coma:
                    tipoToken = "COMA";
                    break;
                case Igual:
                    tipoToken = "IGUAL";
                    break;
                case ParentesisInicio:
                    tipoToken = "PARENTESIS_INICIO";
                    break;
                case ParentesisFinal:
                    tipoToken = "PARENTESIS_FINAL";
                    break;
                case LlaveInicio:
                    tipoToken = "LLAVE_INICIO";
                    break;
                case LlaveFinal:
                    tipoToken = "LLAVE_CIERRE";
                    break;
                case PuntoComa:
                    tipoToken = "PUNTO_Y_COMA";
                    break;
                case DosPuntos:
                    tipoToken = "DOS_PUNTOS";
                    break;
                case OperadorRelacional:
                    tipoToken = "OPERADOR_RELACIONAL";
                    break;
                case OperadorLogico:
                    tipoToken = "OPERADOR_LOGICO";
                    break;
                case OperadorAritmetico:
                    tipoToken = "OPERADOR_ARITMETICO";
                    break;
                case Clase:
                    tipoToken = "CLASE";
                    break;
                case Funcion:
                    tipoToken = "FUNCION";
                    break;
                case NivelAccesoVariable:
                    tipoToken = "NIVEL_ACCESO_VARIABLE";
                    break;
                case ElseIf:
                    tipoToken = "ELSE_IF";
                    break;
                case If:
                    tipoToken = "IF";
                    break;
                case Else:
                    tipoToken = "ELSE";
                    break;
                case For:
                    tipoToken = "FOR";
                    break;
                case Do:
                    tipoToken = "DO";
                    break;
                case While:
                    tipoToken = "WHILE";
                    break;
                case Case:
                    tipoToken = "CASE";
                    break;
                case Default:
                    tipoToken = "DEFAULT";
                    break;
                case Switch:
                    tipoToken = "SWITCH";
                    break;
                case Consola:
                    tipoToken = "CONSOLA";
                    break;
                case Break:
                    tipoToken = "CONSOLA";
                    break;
                case Require:
                    tipoToken = "REQUIRE";
                    break;
                case BOOLEAN:
                    tipoToken = "BOOLEAN";
                    break;
                case DOUBLE:
                    tipoToken = "DOUBLE";
                    break;
                case INTEGER:
                    tipoToken = "INTEGER";
                    break;
                case STRING:
                    tipoToken = "STRING";
                    break;
                case Identificador:
                    tipoToken = "IDENTIFICADOR";
                    break;
                case ERROR:
                    tipoToken = "ERROR";
                    break;
                default:
                    bandera = false;
                    break;
            }
            if(bandera) {
                listaTokens.add(new ReporteToken(lexer.lexeme, tipoToken, linea));
                //System.out.println(linea + "\t" + String.format("%-40s", tipoToken) + "\t" + lexer.lexeme + "\n");
            }
        };
        
        archivo.setLineas(linea);
        archivo.setListaTokens(listaTokens);

    }
    
    private void analizadorSintatico(String texto, File file) {
        String tempText = texto.replace(",","#COMA8264#");
        tempText = tempText.replace("“", "\"");
        tempText = tempText.replace("”", "\"");
        tempText = tempText.replace("‘", "\'");
        tempText = tempText.replace("’", "\'");
        Sintax sintax = new Sintax(new LexicoCup(new StringReader(tempText)));
        
        try {
            sintax.parse();
            System.out.println("ANALISIS SINTACTICO REALIZADO CORRECTAMENTE."); 
        } catch (Exception ex) {
            Symbol sym = sintax.getSimbolo();     
            System.out.println("ERROR SINTACTICO. LINEA: " + (sym.right + 1) + ", TEXTO: \"" + sym.value + "\"");
        }
    }
    
}
