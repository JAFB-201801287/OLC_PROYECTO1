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
import com.proyecto1.model.Clase1;
import com.proyecto1.model.Metodo;
import com.proyecto1.model.ReporteToken;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.StringReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private ArrayList<String> paramentros = new ArrayList<String>();
    private boolean esMetodo = true;

    public Proyecto getProyecto1() {
        return proyecto1;
    }

    public Proyecto getProyecto2() {
        return proyecto2;
    }
    
    public static synchronized ProyectoController getInstance() {
      if(instancia == null) {
         instancia = new ProyectoController();
      }
      return instancia;
    }

    public void setParamentros(ArrayList<String> paramentros) {
        if(this.esMetodo) {
            for (String paramentro : paramentros) {
                this.paramentros.add(paramentro); 
            }
        }
        this.esMetodo = false;
    }
    
    public void addClase(String identificador, ArrayList<String> metodos, int lineas) {
        this.archivo.setClase(new Clase1(identificador, metodos, lineas));
    }
    
    public void addMetodo(String identificador, int lineas) {
        this.archivo.setMetodo(new Metodo(identificador, this.paramentros, lineas));
        this.esMetodo = true;
        this.paramentros = new ArrayList<String>();
    }
    
    public void addVariable(String variable) {
        if(!this.archivo.getVariable().contains(variable)) {
            this.archivo.setVariable(variable);
        }
    }
    
    public void addComentario(String comentario) {
        if(!this.archivo.getComentario().contains(comentario)) {
            this.archivo.setComentario(comentario);
        }
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
                        this.archivo = new Archivo();
                        this.archivo.setNombre(f.getName());
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
        
        if(this.esProyecto1) {
            analizadorLexico(temp, file);
            analizadorSintatico(temp, file);
            this.proyecto1.setArchivo(archivo);
        } else {
            analizadorLexico(temp, file);
            analizadorSintatico(temp, file);
            this.proyecto2.setArchivo(archivo);
        }
    }
    
    private void analizadorLexico(String texto, File file) throws IOException {
        int linea = 1;
        String consola = "";
        String tempText = texto.replace(",","#COMA8264#");
        Lexer lexer = new Lexer(new StringReader(tempText));
        //ArrayList<ReporteToken> listaTokens = new ArrayList<ReporteToken>();
        
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
                if(this.esProyecto1) {
                    this.proyecto1.setListaTokens(new ReporteToken(lexer.lexeme, tipoToken, linea, file.getName()));
                } else {
                    this.proyecto2.setListaTokens(new ReporteToken(lexer.lexeme, tipoToken, linea, file.getName()));
                }
                //listaTokens.add(new ReporteToken(lexer.lexeme, tipoToken, linea, file.getName()));
                //System.out.println(linea + "\t" + String.format("%-40s", tipoToken) + "\t" + lexer.lexeme + "\n");
            }
        };

        this.archivo.setLineas(linea);       
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
    
    public void reporteTokens() {
        String nombreArchivo = "REPORTE_TOKENS.html";
        File file1 = new File(nombreArchivo);
        BufferedWriter bw;
        String html = "";
        String body = "";
        String head = "";
        String container = "";
        String contenido = "";
        String footer = "";
        DateTimeFormatter tiempo = DateTimeFormatter.ofPattern("yyyy/MMMM/dd HH:mm:ss");
        
        head += "    <div class=\"w3-top\">\n";
        head += "        <div class=\"w3-row w3-padding w3-black\">\n";
        head += "            <div class=\"w3-col s3\">\n";
        head += "                <h4>PROYECTO 1</h4>\n";
        head += "            </div>\n";
        head += "        </div>\n";
        head += "    </div>\n";
        
        contenido += "                <div class=\"w3-panel w3-leftbar w3-light-grey\">\n";
        contenido += "                    <p>PROYECTO 1</p>\n";
        contenido += "                    <p>DIRECCION: " + this.proyecto1.getDireccion() + "</p>\n";
        contenido += "                </div>\n";
        contenido += "                <table>\n";
        contenido += "                    <tr>\n";
        contenido += "                        <th>LEXEMA</th>\n";
        contenido += "                        <th>TOKEN</th>\n";
        contenido += "                        <th>LINEA</th>\n";
        contenido += "                        <th>ARCHIVO</th>\n";
        contenido += "                    </tr>\n";
        

        for (ReporteToken rt : this.proyecto1.getListaTokens()) {
            contenido += "                    <tr>\n";
            contenido += "                        <td>" + rt.getLexema() + "</td>\n";
            contenido += "                        <td>" + rt.getToken() + "</td>\n";
            contenido += "                        <td>" + rt.getLinea() + "</td>\n";
            contenido += "                        <td>" + rt.getArchivo()+ "</td>\n";
            contenido += "                    </tr>\n";
        }

        contenido += "                </table>\n";
        
        contenido += "                <div class=\"w3-panel w3-leftbar w3-light-grey\">\n";
        contenido += "                    <p>PROYECTO 2</p>\n";
        contenido += "                    <p>DIRECCION: " + this.proyecto2.getDireccion() + "</p>\n";
        contenido += "                </div>\n";
        contenido += "                <table>\n";
        contenido += "                    <tr>\n";
        contenido += "                        <th>LEXEMA</th>\n";
        contenido += "                        <th>TOKEN</th>\n";
        contenido += "                        <th>LINEA</th>\n";
        contenido += "                        <th>ARCHIVO</th>\n";
        contenido += "                    </tr>\n";
        
        for (ReporteToken rt : this.proyecto2.getListaTokens()) {
            contenido += "                    <tr>\n";
            contenido += "                        <td>" + rt.getLexema() + "</td>\n";
            contenido += "                        <td>" + rt.getToken() + "</td>\n";
            contenido += "                        <td>" + rt.getLinea() + "</td>\n";
            contenido += "                        <td>" + rt.getArchivo() + "</td>\n";
            contenido += "                    </tr>\n";
        }
        contenido += "                </table>\n";
        
        container += "       <div class=\"w3-container\" id=\"about\">\n";
        container += "            <div class=\"w3-content\" style=\"max-width:700px\">\n";
        container += "                <h5 class=\"w3-center w3-padding-64\"><span class=\"w3-tag w3-wide\">REPORTE DE TOKENS</span></h5>\n";
        container += contenido;
        container += "            </div>\n";
        container += "        </div>\n";
        container += "    </div>\n";
        
        footer += "    <footer class=\"w3-center w3-light-grey w3-padding-48 w3-large\">\n";
        footer += "        <p>HECHO POR: <a href=\"#\" title=\"W3.CSS\" target=\"_blank\" class=\"w3-hover-text-green\">JOSE ANDRES FLORES BARCO - 201801287 - "  + tiempo.format(LocalDateTime.now()) + "</a></p>\n";
        footer += "        <p><a href=\"#\" title=\"W3.CSS\" target=\"_blank\" class=\"w3-hover-text-green\">UNIVERSIDAD SAN CARLOS DE GUATEMALA</a></p>\n";
        footer += "    </footer>\n";
        
        body += "<body>\n";
        body += head;
        body += container;
        body += footer;
        body += "</body>\n";
        
        html += "<!DOCTYPE html>\n";
        html += "<html>\n";
        html += "<title>REPORTE DE TOKENS</title>\n";
        html += "<meta charset=\"UTF-8\">\n";
        html += "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n";
        html += "<link rel=\"stylesheet\" href=\"w3.css\">\n";
        html += "<link rel=\"stylesheet\" href=\"googleapis.css\">\n";
        html += "<link rel=\"stylesheet\" href=\"template.css\">\n";
        html += body;
        html += "</html>\n";
        
        try {
            if(file1.exists()) {
                bw = new BufferedWriter(new FileWriter(nombreArchivo));
                bw.write(html);
            } else {
                bw = new BufferedWriter(new FileWriter(nombreArchivo));
                bw.write(html);
            }
            bw.close();
            Desktop.getDesktop().browse(file1.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
