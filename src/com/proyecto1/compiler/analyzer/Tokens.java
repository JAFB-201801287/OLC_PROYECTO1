/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto1.compiler.analyzer;

/**
 *
 * @author Jose Andres Flores Barco 
 * @carne 201801257
 */

public enum Tokens {
    Linea,
    Identificador,
    Decimal,
    CadenaTexto, 
    CadenaTextoComilla, 
    ERROR,
    
    // SIMBOLOS 
    Comillas,
    ComillaSimple,
    Coma,
    Punto,
    LlaveApertura,
    LlaveCierre,
    ParentesisApertura,
    ParentesisCierre,
    CorcheteApertura,
    CorcheteCierre,
    PuntoComa,
    DosPuntos,
    Igual,
    MenorQue,
    MayorQue,
    Dollar,
    
    // PALABRAS RESERVADAS 
    DefinirGlobales,
    GenerarReporteEstadistico,
    GraficaBarras,
    GraficaPie,
    GraficaLineas,
    Compare,
    String,
    Double,
    Titulo,
    Archivo,
    EjeX,
    TituloX,
    TituloY,
    Valores
}
