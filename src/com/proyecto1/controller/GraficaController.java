/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto1.controller;

import com.proyecto1.model.Archivo;
import com.proyecto1.model.Elemento;
import com.proyecto1.model.Grafica;
import com.proyecto1.model.Proyecto;
import com.proyecto1.model.Puntaje;
import com.proyecto1.model.ReporteToken;
import com.proyecto1.model.Variable;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author jafb
 */
public class GraficaController {

    private static GraficaController instancia = null;
    private ArrayList<Grafica> lista = new ArrayList<Grafica>();
    private ArrayList<ReporteToken> listaTokens = new ArrayList<ReporteToken>();
    private Elemento<String> titulo;
    private Elemento<String> archivo;
    private Elemento<String> titulox;
    private Elemento<String> tituloy;
    private ArrayList<Elemento<String>> ejeX = new ArrayList<Elemento<String>>();
    private ArrayList<Elemento<Double>> valores = new ArrayList<Elemento<Double>>();
    private String rutaProyecto1;
    private String rutaProyecto2;

    public GraficaController() {

    }

    public static synchronized GraficaController getInstance() {
        if (instancia == null) {
            instancia = new GraficaController();
        }
        return instancia;
    }

    public void addToken(String lexema, String token, int linea) {
        ReporteToken reporte = new ReporteToken(lexema, token, linea);
        listaTokens.add(reporte);
    }

    public String[][] getReporteToken() {
        int tamanio = this.listaTokens.size();
        String[][] temp = new String[tamanio][3];

        for (int i = 0; i < tamanio; i++) {
            temp[i][0] = this.listaTokens.get(i).getLexema().toString();
            temp[i][1] = this.listaTokens.get(i).getToken().toString();
            temp[i][2] = "" + this.listaTokens.get(i).getLinea();
        }

        return temp;
    }

    public void addTitulo(String valor, String nombreVariable, int linea, int columna) {
        this.titulo = new Elemento<String>("STRING", valor, nombreVariable, linea, columna);
    }

    public void addArchivo(String valor, String nombreVariable, int linea, int columna) {
        this.archivo = new Elemento<String>("STRING", valor, nombreVariable, linea, columna);
    }

    public void addTitulox(String valor, String nombreVariable, int linea, int columna) {
        this.titulox = new Elemento<String>("STRING", valor, nombreVariable, linea, columna);
    }

    public void addTituloy(String valor, String nombreVariable, int linea, int columna) {
        this.tituloy = new Elemento<String>("STRING", valor, nombreVariable, linea, columna);
    }

    public void addEjeX(String valor, String nombreVariable, int linea, int columna) {
        this.ejeX.add(new Elemento<String>("STRING", valor, nombreVariable, linea, columna));
    }

    public void addValor(Double valor, String nombreVariable, int linea, int columna) {
        this.valores.add(new Elemento<Double>("Double", valor, nombreVariable, linea, columna));
    }

    public void addValor(Puntaje puntaje, int linea, int columna) {
        this.valores.add(new Elemento<Double>("Double", puntaje, linea, columna));
    }

    public void addRutaProyecto1(String rutaProyecto1) {
        this.rutaProyecto1 = rutaProyecto1;
    }

    public void addRutaProyecto2(String rutaProyecto2) {
        this.rutaProyecto2 = rutaProyecto2;
    }

    public void addGraficaBarras() {
        lista.add(new Grafica("GRAFICA_BARRAS", titulo, titulox, tituloy, ejeX, valores));
        limpiarGrafica();
    }

    public void addGraficaPie() {
        lista.add(new Grafica("GRAFICA_PIE", titulo, ejeX, valores));
        limpiarGrafica();
    }

    public void addGraficaLineas() {
        lista.add(new Grafica("GRAFICA_LINEAS", titulo, archivo));
        limpiarGrafica();
    }

    public String infoGrafica() {
        String info = "";

        for (Grafica grafica : lista) {
            Elemento<String> titulo = grafica.getTitulo();
            Variable var = VariableController.getInstance().buscarVariable(titulo.getNombreVariable());

            if (titulo.getValor() != "" && titulo.getValor() != null) {
                info += "SE CREO GRAFICA TIPO: " + grafica.getTipo() + ", TITULO: " + titulo.getValor() + "\n";
            } else if (var != null) {
                info += "SE CREO GRAFICA TIPO: " + grafica.getTipo() + ", TITULO: " + var.getValor() + "\n";
            } else {
                info += "SE CREO GRAFICA TIPO: " + grafica.getTipo() + ", TITULO: VACIO\n";
            }

        }

        return info;
    }

    public File buscarFichero(String directorio, String archivo) {
        File carpeta = new File(directorio);

        if (carpeta.exists()) {
            for (File f : carpeta.listFiles()) {

                if (f.getName().equals(archivo)) {
                    return f;
                }

                if (f.isDirectory()) {
                    File temp = buscarFichero(f.getAbsolutePath(), archivo);

                    if (temp != null) {
                        return temp;
                    }
                }
            }
        } else {
            System.out.println("CARPETA DE PROYECTO NO ENCONTRADA.");
        }

        return null;
    }

    private void limpiarGrafica() {
        titulo = new Elemento<String>();
        archivo = new Elemento<String>();
        titulox = new Elemento<String>();
        tituloy = new Elemento<String>();
        ejeX = new ArrayList<Elemento<String>>();
        valores = new ArrayList<Elemento<Double>>();
    }

    public void limpiar() {
        lista = new ArrayList<Grafica>();
        listaTokens = new ArrayList<ReporteToken>();
        titulo = new Elemento<String>();
        archivo = new Elemento<String>();
        titulox = new Elemento<String>();
        tituloy = new Elemento<String>();
        ejeX = new ArrayList<Elemento<String>>();
        valores = new ArrayList<Elemento<Double>>();
        rutaProyecto1 = "";
        rutaProyecto2 = "";
    }

    private void graficaBarras(Grafica grafica) throws IOException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String titulo = "";
        Variable var = VariableController.getInstance().buscarVariable(grafica.getTitulo().getNombreVariable());

        String titulox = "";
        Variable varx = VariableController.getInstance().buscarVariable(grafica.getTituloX().getNombreVariable());

        String tituloy = "";
        Variable vary = VariableController.getInstance().buscarVariable(grafica.getTituloY().getNombreVariable());

        int barras = 0;

        if (grafica.getEjeX().size() <= grafica.getValores().size()) {
            barras = grafica.getEjeX().size();
        } else {
            barras = grafica.getValores().size();
        }

        if (grafica.getTitulo().getValor() != "" && grafica.getTitulo().getValor() != null) {
            titulo = grafica.getTitulo().getValor();
        } else if (var != null) {
            titulo = (String) var.getValor();
        } else {
            titulo = "TITULO: VACIO";
        }

        if (grafica.getTituloX().getValor() != "" && grafica.getTituloX().getValor() != null) {
            titulox = grafica.getTituloX().getValor();
        } else if (varx != null) {
            titulox = (String) varx.getValor();
        } else {
            titulox = "TITULO X: VACIO";
        }

        if (grafica.getTituloY().getValor() != "" && grafica.getTituloY().getValor() != null) {
            tituloy = grafica.getTituloY().getValor();
        } else if (vary != null) {
            tituloy = (String) vary.getValor();
        } else {
            tituloy = "TITULO Y: VACIO";
        }

        ArrayList<Elemento<String>> ejesX = grafica.getEjeX();
        ArrayList<Elemento<Double>> ejesY = grafica.getValores();
        for (int i = 0; i < barras; i++) {
            String ejex = "";
            double ejey = 0;
            Variable varEjex = VariableController.getInstance().buscarVariable(ejesX.get(i).getNombreVariable());
            Variable varEjey = VariableController.getInstance().buscarVariable(ejesY.get(i).getNombreVariable());

            if(varEjey == null) {
                if(ejesY.get(i).getPuntaje().getTipoPuntaje() == "PuntajeGeneral") {
                    ejey = ProyectoController.getInstance().puntajeGeneral();
                } else if(ejesY.get(i).getPuntaje().getTipoPuntaje() == "PuntajeEspecifico") {
                    ejey = ProyectoController.getInstance().puntajeEspecifico(ejesY.get(i).getPuntaje().getNombreArchivo(), ejesY.get(i).getPuntaje().getValor(), ejesY.get(i).getPuntaje().getIdentificador());
                } else {
                    ejey = ejesY.get(i).getValor();
                }
            } else {
                if(varEjey.getPuntaje().getTipoPuntaje() == "PuntajeGeneral") {
                    ejey = ProyectoController.getInstance().puntajeGeneral();
                } else if(varEjey.getPuntaje().getTipoPuntaje() == "PuntajeEspecifico") {
                    ejey = ProyectoController.getInstance().puntajeEspecifico(varEjey.getPuntaje().getNombreArchivo(), varEjey.getPuntaje().getValor(), varEjey.getPuntaje().getIdentificador());
                } else {
                    ejey = (double) varEjey.getValor();
                }
            }

            if(ejesX.get(i).getValor() != "" && ejesX.get(i).getValor() != null) {
                ejex = ejesX.get(i).getValor();
            } else if (varEjex != null) {
                ejex = (String) varEjex.getValor();
            } else {
                ejex = "VACIO";
            }

            dataset.setValue(ejey, "", ejex);
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                titulo,
                titulox,
                tituloy,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                false,
                false
        );
        
        int width = 640;
        int height = 480;
        File BarChart = new File("GraficaBarras_" + titulo + ".png");
        ChartUtilities.saveChartAsJPEG(BarChart, barChart, width, height);
    }
    
    private void graficaPie(Grafica grafica) throws IOException {
        DefaultPieDataset pieDataset = new DefaultPieDataset();

        String titulo = "";
        Variable var = VariableController.getInstance().buscarVariable(grafica.getTitulo().getNombreVariable());

        int barras = 0;

        if (grafica.getEjeX().size() <= grafica.getValores().size()) {
            barras = grafica.getEjeX().size();
        } else {
            barras = grafica.getValores().size();
        }

        if (grafica.getTitulo().getValor() != "" && grafica.getTitulo().getValor() != null) {
            titulo = grafica.getTitulo().getValor();
        } else if (var != null) {
            titulo = (String) var.getValor();
        } else {
            titulo = "TITULO: VACIO";
        }

        ArrayList<Elemento<String>> ejesX = grafica.getEjeX();
        ArrayList<Elemento<Double>> ejesY = grafica.getValores();
        for (int i = 0; i < barras; i++) {
            String ejex = "";
            double ejey = 0;
            Variable varEjex = VariableController.getInstance().buscarVariable(ejesX.get(i).getNombreVariable());
            Variable varEjey = VariableController.getInstance().buscarVariable(ejesY.get(i).getNombreVariable());

            if(varEjey == null) {
                if(ejesY.get(i).getPuntaje().getTipoPuntaje() == "PuntajeGeneral") {
                    ejey = ProyectoController.getInstance().puntajeGeneral();
                } else if(ejesY.get(i).getPuntaje().getTipoPuntaje() == "PuntajeEspecifico") {
                    ejey = ProyectoController.getInstance().puntajeEspecifico(ejesY.get(i).getPuntaje().getNombreArchivo(), ejesY.get(i).getPuntaje().getValor(), ejesY.get(i).getPuntaje().getIdentificador());
                } else {
                    ejey = ejesY.get(i).getValor();
                }
            } else {
                if(varEjey.getPuntaje().getTipoPuntaje() == "PuntajeGeneral") {
                    ejey = ProyectoController.getInstance().puntajeGeneral();
                } else if(varEjey.getPuntaje().getTipoPuntaje() == "PuntajeEspecifico") {
                    ejey = ProyectoController.getInstance().puntajeEspecifico(varEjey.getPuntaje().getNombreArchivo(), varEjey.getPuntaje().getValor(), varEjey.getPuntaje().getIdentificador());
                } else {
                    ejey = (double) varEjey.getValor();
                }
            }

            if(ejesX.get(i).getValor() != "" && ejesX.get(i).getValor() != null) {
                ejex = ejesX.get(i).getValor();
            } else if (varEjex != null) {
                ejex = (String) varEjex.getValor();
            } else {
                ejex = "VACIO";
            }

            pieDataset.setValue(ejex, ejey);
        }

        JFreeChart chart = ChartFactory.createPieChart(
                titulo,
                pieDataset,
                true,
                true,
                false
        );
        
        int width = 640;
        int height = 480;
        File BarChart = new File("GraficaPie_" + titulo + ".png");
        ChartUtilities.saveChartAsJPEG(BarChart, chart, width, height);
    }

    public void iniciarGraficas() throws IOException {
        for (Grafica grafica : this.lista) {
            switch (grafica.getTipo()) {
                case "GRAFICA_BARRAS":
                    graficaBarras(grafica);
                    break;
                case "GRAFICA_PIE":
                    graficaPie(grafica);
                    break;
                case "GRAFICA_LINEAS":
                    graficaLineas(grafica);
                    break;
            }
        }
    }
    
    private void graficaLineas(Grafica grafica) throws IOException {
        String titulo = "";
        String nombreArchivo = "";
        Archivo archivo1 = new Archivo();
        Archivo archivo2 = new Archivo();
        Variable var = VariableController.getInstance().buscarVariable(grafica.getTitulo().getNombreVariable());
        Variable var1 = VariableController.getInstance().buscarVariable(grafica.getArchivo().getNombreVariable());
        
        if (grafica.getTitulo().getValor() != "" && grafica.getTitulo().getValor() != null) {
            titulo = grafica.getTitulo().getValor();
        } else if (var != null) {
            titulo = (String) var.getValor();
        } else {
            titulo = "TITULO: VACIO";
        }
        
        if (grafica.getArchivo().getValor() != "" && grafica.getArchivo().getValor() != null) {
            nombreArchivo = grafica.getArchivo().getValor();
        } else if (var1 != null) {
            nombreArchivo = (String) var1.getValor();
        } else {
            nombreArchivo = "TITULO: VACIO";
        }
        
        for (Archivo a1: ProyectoController.getInstance().getProyecto1().getArchivos()) {
            if(a1.getNombre().equals(nombreArchivo)) {
                archivo1 = a1;
            }
        }
        
        for (Archivo a2: ProyectoController.getInstance().getProyecto2().getArchivos()) {
            if(a2.getNombre().equals(nombreArchivo)) {
                archivo2 = a2;
            }
        }
        
        String series1 = "PROYECTO 1";  
        String series2 = "PROYECTO 2";  
  
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        
        dataset.addValue(archivo2.getVariable().size(), series2, "VARIABLES");  
        dataset.addValue(archivo2.getMetodo().size(), series2, "METODOS");  
        dataset.addValue(archivo2.getClase().size(), series2, "CLASE");  
        dataset.addValue(archivo2.getComentario().size(), series2, "COMENTARIOS"); 
        
        dataset.addValue(archivo1.getVariable().size(), series1, "VARIABLES");  
        dataset.addValue(archivo1.getMetodo().size(), series1, "METODOS");  
        dataset.addValue(archivo1.getClase().size(), series1, "CLASE");  
        dataset.addValue(archivo1.getComentario().size(), series1, "COMENTARIOS");   


        
        JFreeChart chart = ChartFactory.createLineChart(
                titulo, "EJE X", "EJE Y", dataset, 
                PlotOrientation.VERTICAL, 
                true, 
                false, 
                false
                );
   
        int width = 640;
        int height = 480;
        File BarChart = new File("GraficaLinea_" + titulo + ".png");
        ChartUtilities.saveChartAsJPEG(BarChart, chart, width, height);

    }
    
    public void reporteEstadistico() {
        int cantidadClases1 = 0;
        int cantidadVariables1 = 0;
        int cantidadComentarios1 = 0;
        int cantidadMetodos1 = 0;
        
        int cantidadClases2 = 0;
        int cantidadVariables2 = 0;
        int cantidadComentarios2 = 0;
        int cantidadMetodos2 = 0;
        
        Proyecto proyecto1 = ProyectoController.getInstance().getProyecto1();
        Proyecto proyecto2 = ProyectoController.getInstance().getProyecto2();
        String nombreArchivo = "REPORTE_ESTADISTICO.html";
        File file1 = new File(nombreArchivo);
        BufferedWriter bw;
        String html = "";
        String body = "";
        String head = "";
        String container = "";
        String contenido = "";
        String footer = "";
        DateTimeFormatter tiempo = DateTimeFormatter.ofPattern("yyyy/MMMM/dd HH:mm:ss");
        
        for (Archivo a1: proyecto1.getArchivos()) {
            cantidadClases1 += a1.getClase().size();
            cantidadVariables1 += a1.getVariable().size();
            cantidadComentarios1 += a1.getComentario().size();
            cantidadMetodos1 += a1.getMetodo().size();
        }
        
        for (Archivo a2: proyecto2.getArchivos()) {
            cantidadClases2 += a2.getClase().size();
            cantidadVariables2 += a2.getVariable().size();
            cantidadComentarios2 += a2.getComentario().size();
            cantidadMetodos2 += a2.getMetodo().size();
        }
        
        head += "    <div class=\"w3-top\">\n";
        head += "        <div class=\"w3-row w3-padding w3-black\">\n";
        head += "            <div class=\"w3-col s3\">\n";
        head += "                <h4>PROYECTO 1</h4>\n";
        head += "            </div>\n";
        head += "        </div>\n";
        head += "    </div>\n";
        
        contenido += "                <h5 class=\"w3-center w3-padding-64\"><span class=\"w3-tag w3-wide\">REPORTE DE RECORRIDO</span></h5>\n";
        contenido += "                <table>\n";
        contenido += "                    <tr>\n";
        contenido += "                        <th>TIPO</th>\n";
        contenido += "                        <th>PROYECTO A</th>\n";
        contenido += "                        <th>PROYECTO B</th>\n";
        contenido += "                    </tr>\n";
        

        contenido += "                    <tr>\n";
        contenido += "                        <td>TOTAL DE VARIABLES</td>\n";
        contenido += "                        <td>" + cantidadVariables1 + "</td>\n";
        contenido += "                        <td>" + cantidadVariables2 + "</td>\n";
        contenido += "                    </tr>\n";
        contenido += "                    <tr>\n";
        contenido += "                        <td>TOTAL DE CLASE</td>\n";
        contenido += "                        <td>" + cantidadClases1 + "</td>\n";
        contenido += "                        <td>" + cantidadClases2 + "</td>\n";
        contenido += "                    </tr>\n";
        contenido += "                    <tr>\n";
        contenido += "                        <td>TOTAL DE METODOS</td>\n";
        contenido += "                        <td>" + cantidadMetodos1 + "</td>\n";
        contenido += "                        <td>" + cantidadMetodos2 + "</td>\n";
        contenido += "                    </tr>\n";
        contenido += "                    <tr>\n";
        contenido += "                        <td>TOTAL DE COMENTARIOS</td>\n";
        contenido += "                        <td>" + cantidadComentarios1 + "</td>\n";
        contenido += "                        <td>" + cantidadComentarios2 + "</td>\n";
        contenido += "                    </tr>\n";
        contenido += "                </table>\n";
        
        contenido += "        <div class=\"w3-container\" id=\"about\">\n";
        contenido += "            <div class=\"w3-content\" style=\"max-width:700px\">\n";
        contenido += "                <h5 class=\"w3-center w3-padding-64\"><span class=\"w3-tag w3-wide\">GRAFICAS</span></h5>\n";
        
        contenido += "                <h4>GRAFICAS DE BARRAS</h4>\n";
        for (Grafica grafica : this.lista) {
            String titulo = "";
            Variable var = VariableController.getInstance().buscarVariable(grafica.getTitulo().getNombreVariable());
            
            if (grafica.getTitulo().getValor() != "" && grafica.getTitulo().getValor() != null) {
                titulo = grafica.getTitulo().getValor();
            } else if (var != null) {
                titulo = (String) var.getValor();
            } else {
                titulo = "TITULO: VACIO";
            }
            
            if(grafica.getTipo().equals("GRAFICA_BARRAS")) {
                    contenido += "                <img src=\"GraficaBarras_" + titulo + ".png\" style=\"width:100%;max-width:1000px\" class=\"w3-margin-top\">\n";
            }
        }
        
        
        contenido += "                <h4>GRAFICAS DE PIE</h4>\n";
        for (Grafica grafica : this.lista) {
            String titulo = "";
            Variable var = VariableController.getInstance().buscarVariable(grafica.getTitulo().getNombreVariable());
            
            if (grafica.getTitulo().getValor() != "" && grafica.getTitulo().getValor() != null) {
                titulo = grafica.getTitulo().getValor();
            } else if (var != null) {
                titulo = (String) var.getValor();
            } else {
                titulo = "TITULO: VACIO";
            }
            
            if(grafica.getTipo().equals("GRAFICA_PIE")) {
                    contenido += "                <img src=\"GraficaPie_" + titulo + ".png\" style=\"width:100%;max-width:1000px\" class=\"w3-margin-top\">\n";
            }
        }
        
        contenido += "                <h4>GRAFICAS DE LINEAS</h4>\n";
        for (Grafica grafica : this.lista) {
            String titulo = "";
            Variable var = VariableController.getInstance().buscarVariable(grafica.getTitulo().getNombreVariable());
            
            if (grafica.getTitulo().getValor() != "" && grafica.getTitulo().getValor() != null) {
                titulo = grafica.getTitulo().getValor();
            } else if (var != null) {
                titulo = (String) var.getValor();
            } else {
                titulo = "TITULO: VACIO";
            }
            
            if(grafica.getTipo().equals("GRAFICA_LINEAS")) {
                    contenido += "                <img src=\"GraficaLinea_" + titulo + ".png\" style=\"width:100%;max-width:1000px\" class=\"w3-margin-top\">\n";
            }
        }
        contenido += "            </div>\n";
        contenido += "        </div>\n";
        
        

        
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
