package com.proyecto1.compiler.analyzer;
import static com.proyecto1.compiler.analyzer.Tokens.*;
%%
%class Lexer
%type Tokens

/* CONSTANTES */
/*-------------------------------------------------------------------------------------------------------------*/

/*CADENAS DE TEXTO */
L=[a-zA-Z_]+

/* NUMEROS DE UNO O MAS DIGITOS ENTEROS*/
D=[0-9]+

/* ESPACIOS */
espacio=[ ,\t,\r]+

%{
    public String lexeme;
%}
%%

/* EXPRESIONES REGULARES */
/*-------------------------------------------------------------------------------------------------------------*/

/* ESPACIOS EN BLANCOS */
{espacio} {/*Ignore*/}

/* COMENTARIOS */
( ##(.)* ) {/*Ignore*/}

/* SALTO DE LINEA */
( "\n" ) {return Linea;}

/* IDENTIFICADOR O NOMBRE DE VARIABLE */
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}

/* NUMEROS DECIMALES */
( {D}\.{D} ) {lexeme=yytext(); return Decimal;}

/* CADENAS DE TEXTO ENCERRADA CON COMILLAS */
( \".*\" ) {lexeme=yytext(); return CadenaTexto;}

/* CADENAS DE TEXTO ENCERRADA CON COMILLA */
( '.*' ) {lexeme=yytext(); return CadenaTextoComilla;}

/* ERROR */
 . {return ERROR;}

/* SIMBOLOS */
/*-------------------------------------------------------------------------------------------------------------*/

/* COMILLAS */
( "\"" ) {lexeme=yytext(); return Comillas;}

/* COMILLA SIMPLE */
( "'" ) {lexeme=yytext(); return ComillaSimple;}

/* COMA */
( "," ) {lexeme=yytext(); return Coma;}

/* PUNTO */
( "." ) {lexeme=yytext(); return Punto;}

// LLAVE DE APERTURA
( "{" ) {lexema=yytext(); return LlaveApertura;}

// LLAVE DE CIERRE
( "}" ) {lexema=yytext(); return LlaveCierre;}

// PARENTESIS DE APERTURA
( "(" ) {lexema=yytext(); return ParentesisApertura;}

// PARENTESIS DE CIERRE
( ")" ) {lexema=yytext(); return ParentesisCierre;}

/* CORCHETE DE APERTURA */
( "[" ) {lexeme = yytext(); return CorcheteApertura;}

/* CORCHETE DE CIERRE */
( "]" ) {lexeme = yytext(); return CorcheteCierre;}

// PUNTO Y COMA
( ";" ) {lexema=yytext(); return PuntoComa;}

// DOS PUNTOS
( ":" ) {lexema=yytext(); return DosPuntos;}

/* IGUAL */
( "=" ) {lexeme=yytext(); return Igual;}

/* MENOR QUE */
( "<" ) {lexeme=yytext(); return MenorQue;}

/* MAYOR QUE */
( ">" ) {lexeme=yytext(); return MayorQue;}

/* DOLLAR */
( "$" ) {lexeme=yytext(); return Dollar;}

/* PALABRAS RESERVADAS */
/*-------------------------------------------------------------------------------------------------------------*/

/* PALABRA RESERVADA DEFINIR GLOBALES */
( DefinirGlobales ) {lexeme=yytext(); return DefinirGlobales;}

/* PALABRA RESERVADA GENERAR REPORTE ESTADISTICO */
( GemerarReporteEstadistico ) {lexeme=yytext(); return GenerarReporteEstadistico;}

/* PALABRA RESERVADA GRAFICA DE BARRAS */
( GraficaBarras ) {lexeme=yytext(); return GraficaBarras;}

/* PALABRA RESERVADA GRAFICA DE PIE */
( GraficaPie ) {lexeme=yytext(); return GraficaPie;}

/* PALABRA RESERVADA GRAFICA DE LINEAS */
( GraficaLineas ) {lexeme=yytext(); return GraficaLineas;}

/* PALABRA RESERVADA COMPARE */
( Compare ) {lexeme=yytext(); return Compare;}

/* PALABRA RESERVADA STRING */
( String ) {lexeme=yytext(); return String;}

/* PALABRA RESERVADA STRING */
( Double ) {lexeme=yytext(); return Double;}

/* PALABRA RESERVADA TITULO */
( Titulo ) {lexeme=yytext(); return Titulo;}

/* PALABRA RESERVADA ARCHIVO */
( Archivo ) {lexeme=yytext(); return Archivo;}

/* PALABRA RESERVADA EJE X */
( EjeX ) {lexeme=yytext(); return EjeX;}

/* PALABRA RESERVADA TITULO X */
( TituloX ) {lexeme=yytext(); return TituloX;}

/* PALABRA RESERVADA TITULO Y */
( TituloY ) {lexeme=yytext(); return TituloY;}

/* PALABRA RESERVADA VALORES */
( Valores ) {lexeme=yytext(); return Valores;}



