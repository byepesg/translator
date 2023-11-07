grammar LPP_grammar;

programa: registro* variable* rutina estructura;

registro: REGISTRO id variable* FIN REGISTRO;

rutina: (procedimiento | funcion)*;

procedimiento: PROCEDIMIENTO id ( '(' parametros ')' )? variable* INICIO accion* FIN;

funcion: FUNCION id ( '(' parametros ')' )? ':' tipo_dato variable* INICIO accion* (retorne)? FIN;
retorne: RETORNE expresion;

parametros: parametro (',' parametro)*;
parametro: VAR? tipo_dato id;

variable: tipo_dato listaIDs;
tipo_dato: ENTERO | REAL | BOOLEANO | CARACTER | CADENA ( '[' INTEGER ']' )? | ARREGLO '[' listaEnteros ']' DE tipo_dato | id;
listaIDs: id ( ',' id )*;
listaEnteros: INTEGER ( ',' INTEGER )*;

estructura: INICIO accion+ FIN EOF;

accion: asignacion | escribir | leer | llamar | condicional | casos | ciclos;

//asignacion: ID (asignacion_auxiliar)? '<-' expresion ;
//asignacion_auxiliar: '.' ID asignacion_auxiliar | '[' expresion (',' expresion)* ']' ('.' ID asignacion_auxiliar)* (asignacion_auxiliar)?;
asignacion: expresion '<-' expresion;

listaExpr: expresion (',' expresion)*;

escribir: ESCRIBA listaExpr;

//leer: LEA ID asignacion_auxiliar (',' ID)*;
leer: LEA expresion;

llamar: LLAMAR NUEVA_LINEA | LLAMAR id ( '(' listaExpr? ')' )?;

condicional: SI expresion ENTONCES accion* sino? FIN SI;
sino: SINO condicional | SINO accion*;

casos: CASO expresion opcionCaso+ default? FIN CASO;
opcionCaso: listaExpr ':' accion*;
default: SINO ':'accion*;

ciclos: MIENTRAS expresion HAGA accion* FIN MIENTRAS | REPITA accion* HASTA expresion | PARA asignacion HASTA expresion HAGA accion* FIN PARA;

valores: integer | double | char | string | boolean;
expresion: '(' expresion ')' | valores | id | expresion '.' id | expresion '[' listaExpr ']' | id '(' listaExpr? ')' | '-' expresion | NO expresion | <assoc=right> expresion '^' expresion | expresion ( '*' | '/' | DIV | MOD ) expresion | expresion ( '+' | '-' ) expresion | expresion ( '=' | '<>' | '<=' | '>=' | '<' | '>' ) expresion | expresion OP_Y expresion | expresion OP_O expresion;

id: ID;
integer: INTEGER;
double: DOUBLE;
char: CHAR;
string: STRING;
boolean: (VERDADERO | FALSO);
// REGLAS LEXICAS
INICIO : I N I C I O ;
FIN : F I N ;
ESCRIBA : E S C R I B A ;
LEA : L E A ;
LLAMAR : L L A M A R ;
SI : S I ;
ENTONCES : E N T O N C E S ;
SINO : S I N O ;
CASO : C A S O ;
MIENTRAS : M I E N T R A S ;
HAGA : H A G A ;
PARA : P A R A ;
HASTA : H A S T A ;
REPITA : R E P I T A ;
PROCEDIMIENTO : P R O C E D I M I E N T O ;
VAR : V A R ;
FUNCION : F U N C I O N ;
RETORNE : R E T O R N E ;
NUEVA_LINEA: N U E V A '_' L I N E A;

// TIPOS PREDEFINIDOS
ENTERO : E N T E R O ;
REAL : R E A L ;
CARACTER : C A R A C T E R ;
BOOLEANO : B O O L E A N O ;
CADENA : C A D E N A ;
REGISTRO : R E G I S T R O ;
ARREGLO : A R R E G L O ;
DE : D E ;

// OPERADORES
PODER : '^';
MULT : '*' ;
DIVI : '/' ;
MOD : M O D ;
DIV : D I V ;
SUMA : '+' ;
RESTA : '-' ;
IGUAL : '=' ;
DESIGUAL : '<>' ;
MAYOR : '>' ;
MAYOR_IGUAL : '>=' ;
MENOR : '<' ;
MENOR_IGUAL : '<=' ;
OP_Y : Y ;
OP_O : O ;
NO : N O ;

//VALORES
DOUBLE : DIGITO+ '.' DIGITO*;
INTEGER : DIGITO+;
fragment
DIGITO : [0-9] ;

STRING : '"' CARACTERES_CADENA* '"' ;
fragment
CARACTERES_CADENA : ~["] | '\\"' | '\\\\' ;

CHAR : '\'' CARACTERES_CARACTER '\'' ;
fragment
CARACTERES_CARACTER : ~['] | '\\\'' | '\\\\' ;

VERDADERO : V E R D A D E R O ;
FALSO : F A L S O ;

//LETRAS
fragment A:('a'|'A');
fragment B:('b'|'B');
fragment C:('c'|'C');
fragment D:('d'|'D');
fragment E:('e'|'E');
fragment F:('f'|'F');
fragment G:('g'|'G');
fragment H:('h'|'H');
fragment I:('i'|'I');
fragment J:('j'|'J');
fragment K:('k'|'K');
fragment L:('l'|'L');
fragment M:('m'|'M');
fragment N:('n'|'N');
fragment O:('o'|'O');
fragment P:('p'|'P');
fragment Q:('q'|'Q');
fragment R:('r'|'R');
fragment S:('s'|'S');
fragment T:('t'|'T');
fragment U:('u'|'U');
fragment V:('v'|'V');
fragment W:('w'|'W');
fragment X:('x'|'X');
fragment Y:('y'|'Y');
fragment Z:('z'|'Z');

// IDENTIFICADOR
ID : [a-zA-Z$_] [a-zA-Z0-9$_]* ;

// NUEVA LINEA, ESPACIO BLANCO (WHITESPACE) Y COMENTARIOS
WS : [ \t\r\n]+ -> skip ;
COMENTARIO : '/*' .*? '*/' -> skip;
COMENTARIO_LINEA : '//' ~[\r\n]* -> skip;