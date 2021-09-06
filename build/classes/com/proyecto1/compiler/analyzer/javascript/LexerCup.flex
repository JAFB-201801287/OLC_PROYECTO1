package com.proyecto1.compiler.analyzer.javascript;
import java_cup.runtime.Symbol;

%%
/* INICIO */
/*----------------------------------------------------------------------------------------------------------------------------------*/
%public
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

// IGNORAR ESPACIOS EN BLANCO Y SALTOS DE LINEA
{espacio} {/*Ignore*/}

/* DEFINIR LEXICO */
/*----------------------------------------------------------------------------------------------------------------------------------*/

// COMA
( "," ) { return new Symbol(sym.Coma, yychar, yyline, yytext()); }

/* IGUAL */
( "=" ) { return new Symbol(sym.Igual, yychar, yyline, yytext()); }

/* PARENTESIS INICIO */
( "(" ) { return new Symbol(sym.ParentesisInicio, yychar, yyline, yytext()); }

/* PARENTESIS FINAL */
( ")" ) { return new Symbol(sym.ParentesisFinal, yychar, yyline, yytext()); }

/* LLAVE INICIO */
( "{" ) { return new Symbol(sym.LlaveInicio, yychar, yyline, yytext()); }

/* LLAVE FINA L*/
( "}" ) { return new Symbol(sym.LlaveFinal, yychar, yyline, yytext()); }

/* PUNTO Y COMA */
( ";" ) { return new Symbol(sym.PuntoComa, yychar, yyline, yytext()); }

/* DOS PUNTOS */
( ":" ) { return new Symbol(sym.DosPuntos, yychar, yyline, yytext()); }

/* OPERADORES PARA IDENTIFICADORES (SUMATORIA, RESTA) */
( "++" | "--" ) { return new Symbol(sym.OperadorIdentificador, yychar, yyline, yytext()); }

/* OPERADORES RELACIONALES (IGUALACION, DIFERENCIA, MENOR QUE, MAYOR QUE, MENOR O IGUAL, MAYOR O IGUAL)*/
( "==" | "!=" | "<" | ">" | "<=" | ">=" ) { return new Symbol(sym.OperadorRelacional, yychar, yyline, yytext()); }

/* OPERADORES LOGICOS (AND, OR) */
( "&&" | "||" ) { return new Symbol(sym.OperadorLogico, yychar, yyline, yytext()); }

/* OPERADORES LOGICOS (NOT) */
( "!" ) { return new Symbol(sym.OperadorLogicoNot, yychar, yyline, yytext()); }

/* OPERADORES ARITMETICO (SUMA, RESTA, MULTIPLICACION, DIVICION, POTENCIA, MODULO, UNARIO) */
( "+" | "-" | "**" | "*" | "/" | "%" ) { return new Symbol(sym.OperadorAritmetico, yychar, yyline, yytext()); }

/* PALABRA RESERVADA CLASS */
( "class" ) { return new Symbol(sym.Clase, yychar, yyline, yytext()); }

/* PALABRA RESERVADA FUNTION */
( "function" ) { return new Symbol(sym.Funcion, yychar, yyline, yytext()); }

/* PALABRA RESERVADA NIVEL DE ACCESO DE VARIABLES (VAR) */
( "var" ) { return new Symbol(sym.Var, yychar, yyline, yytext()); }

/* PALABRA RESERVADA NIVEL DE ACCESO DE VARIABLES (LET) */
( "let" ) { return new Symbol(sym.Let, yychar, yyline, yytext()); }

/* PALABRA RESERVADA NIVEL DE ACCESO DE VARIABLES (CONST) */
( "const" ) { return new Symbol(sym.Const, yychar, yyline, yytext()); }

/* PALABRA RESERVADA IF */
( "if" ) { return new Symbol(sym.If, yychar, yyline, yytext()); }

/* PALABRA RESERVADA ELSE */
( "else" ) { return new Symbol(sym.Else, yychar, yyline, yytext()); }

/* PALABRA RESERVADA FOR */
( "for" ) { return new Symbol(sym.For, yychar, yyline, yytext()); }

/* PALABRA RESERVADA DO */
( "do" ) { return new Symbol(sym.Do, yychar, yyline, yytext()); }

/* PALABRA RESERVADA WHILE */
( "while" ) { return new Symbol(sym.While, yychar, yyline, yytext()); }

/* PALABRA RESERVADA SWITCH */
( "switch" ) { return new Symbol(sym.Switch, yychar, yyline, yytext()); }

/* PALABRA RESERVADA CASE */
( "case" ) { return new Symbol(sym.Case, yychar, yyline, yytext()); }

/* PALABRA RESERVADA DEFAULT */
( "default" ) { return new Symbol(sym.Default, yychar, yyline, yytext()); }

/* PALABRA RESERVADA CONSOLA */
( "console.log" ) { return new Symbol(sym.Consola, yychar, yyline, yytext()); }

/* PALABRA RESERVADA BREAK */
( "break" ) { return new Symbol(sym.Break, yychar, yyline, yytext()); }
( "break"[ ]*\n ) { return new Symbol(sym.Break1, yychar, yyline, yytext()); }

/* PALABRA RESERVADA IMPORTACION */
( "require" ) { return new Symbol(sym.Require, yychar, yyline, yytext()); }

/* PALABRA RESERVADA (TRUE, FALSE) - TIPO DE DATO BOOLEAN */
( "true" | "false" ) { return new Symbol(sym.BOOLEAN, yychar, yyline, yytext()); }
( "true"[ ]*\n | "false"[ ]*\n ) { return new Symbol(sym.BOOLEAN1, yychar, yyline, yytext()); }

/* TIPO DE DATO DOUBLE */
( {D}\.{D} ) { return new Symbol(sym.DOUBLE, yychar, yyline, yytext()); }
( {D}\.{D}[ ]*\n ) { return new Symbol(sym.DOUBLE1, yychar, yyline, yytext()); }

/* TIPO DE DATO INTEGER */
( {D} ) { return new Symbol(sym.INTEGER, yychar, yyline, yytext()); }
( {D}[ ]*\n ) { return new Symbol(sym.INTEGER1, yychar, yyline, yytext()); }

/* CADENA DE TEXTO ENCERRADA POR COMILLAS STRING */
( \"([^\"]*)\"|“([^“]*)” ) { return new Symbol(sym.STRING, yychar, yyline, yytext()); }
( \"([^\"]*)\"[ ]*"\n" |“([^“]*)”[ ]*"\n" ) { return new Symbol(sym.STRING1, yychar, yyline, yytext()); }

/* IDENTIFICADOR */
( {L}({L}|{D})* ) { return new Symbol(sym.Identificador, yychar, yyline, yytext()); }
( {L}({L}|{D})*[ ]*\n  ) { return new Symbol(sym.Identificador1, yychar, yyline, yytext()); }

/* COMENTARIO DE UNA LINEA */
( "//"(.)*\n ) { return new Symbol(sym.ComentarioLinea, yychar, yyline, yytext()); }

// COMENTARIO MULTI LINEA
( "/*"([^"/*"|"*/"]*)"*/" ) { return new Symbol(sym.Comentario, yychar, yyline, yytext()); }
