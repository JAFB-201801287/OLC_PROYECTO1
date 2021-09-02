package com.proyecto1.compiler.analyzer.reporteria;
import static com.proyecto1.compiler.analyzer.reporteria.Tokens.*;
%%
%public
%class Lexer
%type Tokens

/* CONSTANTES */
L = [a-zA-Z_]+
D = [0-9]+
espacio = [ ,\t,\r]+

%{
    public String lexeme;
%}
%%

/* COMENTARIO MULTILINEA */
( #\*(.|\n)*\*# ) {/*Ignore*/}

/* ESPACIOS EN BLANCO */
{espacio} {/*Ignore*/}

/* COMENTARIOS */
( ##(.)* ) {/*Ignore*/}

/* SALTO DE LINEA */
( "\n" ) {return Linea;}

/* COMA */
( "<COMA8264>" ) {lexeme=","; return Coma;}

/* TIPOS DE DATO STRING */
( [S|s][T|t][R|r][I|i][N|n][G|g] ) {lexeme=yytext(); return STRING;}

/* TIPOS DE DATO DOUBLE */
( [D|d][O|o][U|u][B|b][L|l][E|e] ) {lexeme=yytext(); return DOUBLE;}

/* IGUAL */
( "=" ) {lexeme=yytext(); return Igual;}

/* PARENTESIS INICIO */
( "(" ) {lexeme=yytext(); return ParentesisInicio;}

/* PARENTESIS FINAL */
( ")" ) {lexeme=yytext(); return ParentesisFinal;}

/* LLAVE INICIO */
( "{" ) {lexeme=yytext(); return LlaveInicio;}

/* LLAVE FINAL*/
( "}" ) {lexeme=yytext(); return LlaveFinal;}

/* CORCHETE INICIO */
( "[" ) {lexeme = yytext(); return CorcheteInicio;}

/* CORCHETE FINAL */
( "]" ) {lexeme = yytext(); return CorcheteFinal;}

/* PUNTO Y COMA*/
( ";" ) {lexeme=yytext(); return PuntoComa;}

// DOS PUNTOS
( ":" ) {lexeme=yytext(); return DosPuntos;}

/* DOLLAR */
( "$" ) {lexeme=yytext(); return Dollar;}

/* PALABRA RESERVADA PUNTAJE GENERAL */
( [P|p][U|u][N|n][T|t][A|a][J|j][E|e][G|g][E|e][N|n][E|e][R|r][A|a][L|l] ) {lexeme=yytext(); return PuntajeGeneral;}

/* PALABRA RESERVADA PUNTAJE ESPECIFICO */
( [P|p][U|u][N|n][T|t][A|a][J|j][E|e][E|e][S|s][P|p][E|e][C|c][I|i][F|f][I|i][C|c][O|o] ) {lexeme=yytext(); return PuntajeEspecifico;}

/* PALABRA RESERVADA DEFINIR GLOBALES */
( [D|d][E|e][F|f][I|i][N|n][I|i][R|r][G|g][L|l][O|o][B|b][A|a][L|l][E|e][S|s] ) {lexeme=yytext(); return DefinirGlobales;}

/* PALABRA RESERVADA GENERAR REPORTE ESTADISTICO */
( [G|g][E|e][N|n][E|e][R|r][A|a][R|r][R|r][E|e][P|p][O|o][R|r][T|t][E|e][E|e][S|s][T|t][A|a][D|d][I|i][S|s][T|t][I|i][C|c][O|o] ) {lexeme=yytext(); return GenerarReporteEstadistico;}

/* PALABRA RESERVADA GRAFICA DE BARRAS */
( [G|g][R|r][A|a][F|f][I|i][C|c][A|a][B|b][A|a][R|r][R|r][A|a][S|s] ) {lexeme=yytext(); return GraficaBarras;}

/* PALABRA RESERVADA GRAFICA DE PIE */
( [G|g][R|r][A|a][F|f][I|i][C|c][A|a][P|p][I|i][E|e] ) {lexeme=yytext(); return GraficaPie;}

/* PALABRA RESERVADA GRAFICA DE LINEAS */
( [G|g][R|r][A|a][F|f][I|i][C|c][A|a][L|l][I|i][N|n][E|e][A|a][S|s] ) {lexeme=yytext(); return GraficaLineas;}

/* PALABRA RESERVADA COMPARE */
( [C|c][O|o][M|m][P|p][A|a][R|r][E|e] ) {lexeme=yytext(); return Compare;}

/* PALABRA RESERVADA TITULO */
( [T|t][I|i][T|t][U|u][L|l][O|o] ) {lexeme=yytext(); return Titulo;}

/* PALABRA RESERVADA ARCHIVO */
( [A|a][R|r][C|c][H|h][I|i][V|v][O|o] ) {lexeme=yytext(); return Archivo;}

/* PALABRA RESERVADA EJE X */
( [E|e][J|j][E|e][X|x] ) {lexeme=yytext(); return EjeX;}

/* PALABRA RESERVADA TITULO X */
( [T|t][I|i][T|t][U|u][L|l][O|o][X|x] ) {lexeme=yytext(); return TituloX;}

/* PALABRA RESERVADA TITULO Y */
( [T|t][I|i][T|t][U|u][L|l][O|o][Y|y] ) {lexeme=yytext(); return TituloY;}

/* PALABRA RESERVADA VALORES */
( [V|v][A|a][L|l][O|o][R|r][E|e][S|s] ) {lexeme=yytext(); return Valores;}

/* NUMERO DECIMAL */
( {D}\.{D} ) {lexeme=yytext(); return Decimal;}

/* CADENA DE TEXTO ENCERRADA POR COMILLAS SIMPLES */
( '([^\']*)'|‘([^\‘]*)’ ) {lexeme=yytext(); return Ruta;}

/* CADENA DE TEXTO ENCERRADA POR COMILLAS STRING */
( \"([^\"]*)\"|“([^“]*)” ) {lexeme=yytext(); return Cadena;}

/* IDENTIFICADOR */
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}

/* ERROR */
( . ) {return ERROR;}





