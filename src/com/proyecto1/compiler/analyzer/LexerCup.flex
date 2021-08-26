package com.proyecto1.compiler.analyzer;
import java_cup.runtime.Symbol;

%%
/* INICIO */
/*----------------------------------------------------------------------------------------------------------------------------------*/
%class LexicoCup
%type java_cup.runtime.Symbol

// ANALIZADOR
%cup
// RETORNA CADENA
%full 
// RETORNA LINEA
%line 
// RETORNA COLUMNA
%char
 
/* CONSTANTES */
/*----------------------------------------------------------------------------------------------------------------------------------*/
// ACEPTA PALABRAS CON MAYUSCULAS Y MINUSCULAS
L=[a-zA-Z_]+
// ACEPTA NUMEROS ENTEROS
D=[0-9]+
//  ACEPTA ESPACIOS Y SALTOS DE LINEA
espacio=[ ,\t,\r,\n]+

/* CODIGO */
/*----------------------------------------------------------------------------------------------------------------------------------*/
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

/* ELEMENTOS IGNORADOS */
/*----------------------------------------------------------------------------------------------------------------------------------*/

// IGNORAR COMENTARIO MULTILINEA
( #\*(.|\n)*\*# ) {/*Ignore*/}

/* IGNORAR COMENTARIOS */
( ##(.)* ) {/*Ignore*/}

// IGNORAR ESPACIOS EN BLANCO Y SALTOS DE LINEA
{espacio} {/*Ignore*/}

/* DEFINIR LEXICO */
/*----------------------------------------------------------------------------------------------------------------------------------*/

// COMA
( "<COMA8264>" )   {return new Symbol(sym.Coma, yychar, yyline, yytext());}

// TIPOS DE DATO STRING
( [S|s][T|t][R|r][I|i][N|n][G|g] ) {return new Symbol(sym.STRING, yychar, yyline, yytext());}

// TIPOS DE DATO DOUBLE
( [D|d][O|o][U|u][B|b][L|l][E|e] ) {return new Symbol(sym.DOUBLE, yychar, yyline, yytext());}

// IGUAL
( "=" ) {return new Symbol(sym.Igual, yychar, yyline, yytext());}

// PARENTESIS INICIO
( "(" ) {return new Symbol(sym.ParentesisInicio, yychar, yyline, yytext());}

// PARENTESIS FINAL
( ")" ) {return new Symbol(sym.ParentesisFinal, yychar, yyline, yytext());}

// LLAVE INICIO
( "{" ) {return new Symbol(sym.LlaveInicio, yychar, yyline, yytext());}

// LLAVE FINAL
( "}" ) {return new Symbol(sym.LlaveFinal, yychar, yyline, yytext());}

// CORCHETE INICIO
( "[" ) {return new Symbol(sym.CorcheteInicio, yychar, yyline, yytext());}

// CORCHETE FINAL
( "]" ) {return new Symbol(sym.CorcheteFinal, yychar, yyline, yytext());}

// PUNTO Y COMA
( ";" ) {return new Symbol(sym.PuntoComa, yychar, yyline, yytext());}

// DOS PUNTOS
( ":" ) {return new Symbol(sym.DosPuntos, yychar, yyline, yytext());}

// DOLLAR
( "$" ) {return new Symbol(sym.Dollar, yychar, yyline, yytext());}

// PALABRA RESERVADA PUNTAJE GENERAL
( [P|p][U|u][N|n][T|t][A|a][J|j][E|e][G|g][E|e][N|n][E|e][R|r][A|a][L|l] ) {return new Symbol(sym.PuntajeGeneral, yychar, yyline, yytext());}

// PALABRA RESERVADA PUNTAJE ESPECIFICO
( [P|p][U|u][N|n][T|t][A|a][J|j][E|e][E|e][S|s][P|p][E|e][C|c][I|i][F|f][I|i][C|c][O|o] ) {return new Symbol(sym.PuntajeEspecifico, yychar, yyline, yytext());}

// PALABRA RESERVADA DEFINIR GLOBALES
( [D|d][E|e][F|f][I|i][N|n][I|i][R|r][G|g][L|l][O|o][B|b][A|a][L|l][E|e][S|s] ) {return new Symbol(sym.DefinirGlobales, yychar, yyline, yytext());}

// PALABRA RESERVADA GENERAR REPORTE ESTADISTICO
( [G|g][E|e][N|n][E|e][R|r][A|a][R|r][R|r][E|e][P|p][O|o][R|r][T|t][E|e][E|e][S|s][T|t][A|a][D|d][I|i][S|s][T|t][I|i][C|c][O|o] ) {return new Symbol(sym.GenerarReporteEstadistico, yychar, yyline, yytext());}

// PALABRA RESERVADA GRAFICA DE BARRAS
( [G|g][R|r][A|a][F|f][I|i][C|c][A|a][B|b][A|a][R|r][R|r][A|a][S|s] ) {return new Symbol(sym.GraficaBarras, yychar, yyline, yytext());}

// PALABRA RESERVADA GRAFICA DE PIE
( [G|g][R|r][A|a][F|f][I|i][C|c][A|a][P|p][I|i][E|e] ) {return new Symbol(sym.GraficaPie, yychar, yyline, yytext());}

// PALABRA RESERVADA GRAFICA DE LINEAS
( [G|g][R|r][A|a][F|f][I|i][C|c][A|a][L|l][I|i][N|n][E|e][A|a][S|s] ) {return new Symbol(sym.GraficaLineas, yychar, yyline, yytext());}

// PALABRA RESERVADA COMPARE
( [C|c][O|o][M|m][P|p][A|a][R|r][E|e] ) {return new Symbol(sym.Compare, yychar, yyline, yytext());}

// PALABRA RESERVADA TITULO
( [T|t][I|i][T|t][U|u][L|l][O|o] ) {return new Symbol(sym.Titulo, yychar, yyline, yytext());}

// PALABRA RESERVADA ARCHIVO
( [A|a][R|r][C|c][H|h][I|i][V|v][O|o] ) {return new Symbol(sym.Archivo, yychar, yyline, yytext());}

// PALABRA RESERVADA EJE X
( [E|e][J|j][E|e][X|x] ) {return new Symbol(sym.EjeX, yychar, yyline, yytext());}

// PALABRA RESERVADA TITULO X
( [T|t][I|i][T|t][U|u][L|l][O|o][X|x] ) {return new Symbol(sym.TituloX, yychar, yyline, yytext());}

// PALABRA RESERVADA TITULO Y
( [T|t][I|i][T|t][U|u][L|l][O|o][Y|y] ) {return new Symbol(sym.TituloY, yychar, yyline, yytext());}

// PALABRA RESERVADA VALORES
( [V|v][A|a][L|l][O|o][R|r][E|e][S|s] ) {return new Symbol(sym.Valores, yychar, yyline, yytext());}

// NUMEROS DECIMALES
( {D}\.{D} ) {return new Symbol(sym.Decimal, yychar, yyline, yytext());}

// CADENA DE TEXTO ENCERRADA POR COMILLAS SIMPLES RUTA 
( '([^\']*)'|‘([^\‘]*)’ ) {return new Symbol(sym.Ruta, yychar, yyline, yytext());}

// CADENA DE TEXTO ENCERRADA POR COMILLAS STRING
( \"([^\"]*)\"|“([^“]*)” ) {return new Symbol(sym.Cadena, yychar, yyline, yytext());}

// IDENTIFICADOR
( {L}({L}|{D})* ) {return new Symbol(sym.Identificador, yychar, yyline, yytext());}

// ERROR
( . ) {return new Symbol(sym.ERROR, yychar, yyline, yytext());}