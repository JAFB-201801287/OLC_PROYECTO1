package com.proyecto1.compiler.analyzer;
import static com.proyecto1.compiler.analyzer.Tokens.*;
%%
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

/* ESPACIOS EN BLANCO */
{espacio} {/*Ignore*/}

/* SALTO DE LINEA */
( "\n" ) {return Linea;}

/* COMENTARIO DE UNA LINEA */
( "//"(.)* ) {/*Ignore*/}

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

/* PUNTO Y COMA*/
( ";" ) {lexeme=yytext(); return PuntoComa;}

/* OPERADORES RELACIONALES (IGUALACION, DIFERENCIA, MENOR QUE, MAYOR QUE, MENOR O IGUAL, MAYOR O IGUAL)*/
( "==" | "!=" | "<" | ">" | "<=" | ">=" ) { lexeme = yytext(); return OperadorRelacional; }

/* OPERADORES LOGICOS (AND, OR Y NOT) */
( "&&" | "||" | "!" ) { lexeme=yytext(); return OperadorLogico ;}

/* OPERADORES ARITMETICO (SUMA, RESTA, MULTIPLICACION, DIVICION, POTENCIA, MODULO, UNARIO) */
( "+" | "-" | "**" | "*" | "/" | "%" ) { lexeme=yytext(); return OperadorAritmetico ;}

/* PALABRA RESERVADA CLASS */
( "class" ) { lexeme=yytext(); return CLASE ;}

/* PALABRA RESERVADA NIVEL DE ACCESO DE VARIABLES (VAR, LET, CONST) */
( "var" | "let" | "const" ) { lexeme=yytext(); return NivelAccesoVariable ;}

/* PALABRA RESERVADA ELSE IF */
( "else if" ) { lexeme=yytext(); return ElseIf ;}

/* PALABRA RESERVADA IF */
( "if" ) { lexeme=yytext(); return If ;}

/* PALABRA RESERVADA ELSE */
( "else" ) { lexeme=yytext(); return Else ;}

/* PALABRA RESERVADA FOR */
( "for" ) { lexeme=yytext(); return For ;}

/* PALABRA RESERVADA DO */
( "do" ) { lexeme=yytext(); return Do ;}

/* PALABRA RESERVADA WHILE */
( "while" ) { lexeme=yytext(); return While ;}

/* PALABRA RESERVADA SWITCH */
( "switch" ) { lexeme=yytext(); return Switch ;}

/* PALABRA RESERVADA CONSOLA */
( "console.log" ) { lexeme=yytext(); return Consola ;}

/* PALABRA RESERVADA BREAK */
( "break" ) { lexeme=yytext(); return Break ;}

/* PALABRA RESERVADA IMPORTACION */
( "require" ) { lexeme=yytext(); return Require ;}

/* PALABRA RESERVADA (TRUE, FALSE) - TIPO DE DATO BOOLEAN */
( "true" | "false" ) { lexeme=yytext(); return BOOLEAN ;}

/* TIPO DE DATO DOUBLE */
( {D}\.{D} ) {lexeme=yytext(); return DOUBLE;}

/* TIPO DE DATO INTEGER */
( {D} ) {lexeme=yytext(); return INTEGER;}

/* CADENA DE TEXTO ENCERRADA POR COMILLAS STRING */
( \"([^\"]*)\"|“([^“]*)” ) {lexeme=yytext(); return STRING;}

/* IDENTIFICADOR */
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}

/* ERROR */
( . ) {return ERROR;}
