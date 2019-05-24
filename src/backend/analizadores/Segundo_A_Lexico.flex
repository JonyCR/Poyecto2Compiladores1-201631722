
/*------------  1ra Area: Codigo de Usuario ---------*/
//------> Paquetes, Importaciones
package backend.analizadores;
import java_cup.runtime.*;

/*------------  2da Area: Opciones y Declaraciones ---------*/
%%
%{

public String extraerInfo (String token){
    int longitud = token.length();
    String tokenSinCorchetes = token.substring(1, longitud-1);
    System.out.println("El token a enviar es: "+tokenSinCorchetes);
    return tokenSinCorchetes;
}

public String extraerInfo2 (String token){
    int longitud = token.length();
    String tokenSinCorchetes = token.substring(2, longitud-1);
    System.out.println("El token a enviar es: "+tokenSinCorchetes);
    return tokenSinCorchetes;
}

%}

//-------> Directivas
%public 
%class Segundo_Analizador_Lexico
%cupsym Simbolos2
%cup
%char
%column
%full
%line
%unicode

//--------> Expresiones Regulares
D = [0-9]
LETRAS = [a-zA-Z]
LINETERMINATOR = \r|\n|\r\n
WHITE=[ \t\f]+
IDVAR = {LETRAS}+([:jletterdigit:] | [_] )*


//------> Estados

%%
/*------------  3raa Area: Reglas Lexicas ---------*/

//-----> Simbolos  y Expresiones Regulares

<YYINITIAL> {

         "&lt"    { System.out.println("Se reconocio "+yytext()+" de tipo TEXTO MENOR QUE"); return new Symbol(Simbolos2.SEMenorQue, yycolumn, yyline, yytext()); }

         "&gt"    { System.out.println("Se reconocio "+yytext()+" de tipo TEXTO MAYOR QUE"); return new Symbol(Simbolos2.SEMayorQue, yycolumn, yyline, yytext()); }

         "&amp"    { System.out.println("Se reconocio "+yytext()+" de tipo TEXTO AMPERSAND &"); return new Symbol(Simbolos2.SEAmpersand, yycolumn, yyline, yytext()); }

         "&aacute"    { System.out.println("Se reconocio "+yytext()+" de tipo a con TILDE"); return new Symbol(Simbolos2.SEa, yycolumn, yyline, yytext()); }

         "&eacute"    { System.out.println("Se reconocio "+yytext()+" de tipo e con TILDE"); return new Symbol(Simbolos2.SEe, yycolumn, yyline, yytext()); }

         "&iacute"    { System.out.println("Se reconocio "+yytext()+" de tipo i con TILDE"); return new Symbol(Simbolos2.SEi, yycolumn, yyline, yytext()); }

         "&oacute"    { System.out.println("Se reconocio "+yytext()+" de tipo o con TILDE"); return new Symbol(Simbolos2.SEo, yycolumn, yyline, yytext()); }

         "&uacute"    { System.out.println("Se reconocio "+yytext()+" de tipo u con TILDE"); return new Symbol(Simbolos2.SEu, yycolumn, yyline, yytext()); }

         "&Ntilde"    { System.out.println("Se reconocio "+yytext()+" de tipo Ñ dentro de TEXTO"); return new Symbol(Simbolos2.SEN, yycolumn, yyline, yytext()); }

         "&ntilde"    { System.out.println("Se reconocio "+yytext()+" de tipo ñ dentro de TEXTO"); return new Symbol(Simbolos2.SEn, yycolumn, yyline, yytext()); }

         "["    { System.out.println("Se reconocio "+yytext()+" de tipo Abrir Corchetes"); return new Symbol(Simbolos2.AbrirCorchetes, yycolumn, yyline, yytext()); }

         "\""    { System.out.println("Se reconocio "+yytext()+" de tipo Comillas"); return new Symbol(Simbolos2.Comillas, yycolumn, yyline, yytext()); }

         ":"    { System.out.println("Se reconocio "+yytext()+" de tipo Dos Puntos"); return new Symbol(Simbolos2.DosPuntos, yycolumn, yyline, yytext()); }

         ";"    { System.out.println("Se reconocio "+yytext()+" de tipo Punto y Coma"); return new Symbol(Simbolos2.PuntoYComa, yycolumn, yyline, yytext()); }

         "]"    { System.out.println("Se reconocio "+yytext()+" de tipo Cerrar Corchetes"); return new Symbol(Simbolos2.CerrarCorchetes, yycolumn, yyline, yytext()); }

         "("    { System.out.println("Se reconocio "+yytext()+" de tipo Abrir Parentesis"); return new Symbol(Simbolos2.AbrirParentesis, yycolumn, yyline, yytext()); }

         ")"    { System.out.println("Se reconocio "+yytext()+" de tipo Cerrar Parentesis"); return new Symbol(Simbolos2.CerrarParentesis, yycolumn, yyline, yytext()); }

         ","    { System.out.println("Se reconocio "+yytext()+" de tipo Coma"); return new Symbol(Simbolos2.Coma, yycolumn, yyline, yytext()); }

         "="    { System.out.println("Se reconocio "+yytext()+" de tipo Igual"); return new Symbol(Simbolos2.Igual, yycolumn, yyline, yytext()); }

         "+"    { System.out.println("Se reconocio "+yytext()+" de tipo Suma"); return new Symbol(Simbolos2.Mas, yycolumn, yyline, yytext()); }

         "-"    { System.out.println("Se reconocio "+yytext()+" de tipo Resta"); return new Symbol(Simbolos2.Menos, yycolumn, yyline, yytext()); }

         "/"    { System.out.println("Se reconocio "+yytext()+" de tipo Division"); return new Symbol(Simbolos2.Diagonal, yycolumn, yyline, yytext()); }

         "*"    { System.out.println("Se reconocio "+yytext()+" de tipo Multiplicacion"); return new Symbol(Simbolos2.Asterisco, yycolumn, yyline, yytext()); }

        ([pP]) { System.out.println("Se reconocio "+yytext()+" de tipo PARRAFO"); return new Symbol(Simbolos2.p, yycolumn, yyline, yytext()); }

        ([aA]) { System.out.println("Se reconocio "+yytext()+" de tipo A de ENLACE"); return new Symbol(Simbolos2.Aenlace, yycolumn, yyline, yytext()); }

        ([bB]) { System.out.println("Se reconocio "+yytext()+" de tipo NEGRILLA"); return new Symbol(Simbolos2.b, yycolumn, yyline, yytext()); }

        ([uU]) { System.out.println("Se reconocio "+yytext()+" de tipo SUBRAYADO"); return new Symbol(Simbolos2.u, yycolumn, yyline, yytext()); }

        ([iI]) { System.out.println("Se reconocio "+yytext()+" de tipo ITALICA"); return new Symbol(Simbolos2.i, yycolumn, yyline, yytext()); }  

        ([hH][rR]) { System.out.println("Se reconocio "+yytext()+" de tipo LINEA HORIZONTAL"); return new Symbol(Simbolos2.hr, yycolumn, yyline, yytext()); }

        ([uU][lL]) { System.out.println("Se reconocio "+yytext()+" de tipo LISTA DESORDENADA"); return new Symbol(Simbolos2.ul, yycolumn, yyline, yytext()); }

        ([lL][iI]) { System.out.println("Se reconocio "+yytext()+" de tipo ITEM DE LISTA"); return new Symbol(Simbolos2.li, yycolumn, yyline, yytext()); }

        ([bB][rR]) { System.out.println("Se reconocio "+yytext()+" de tipo SALTO DE LINEA"); return new Symbol(Simbolos2.br, yycolumn, yyline, yytext()); }

        ([oO][lL]) { System.out.println("Se reconocio "+yytext()+" de tipo LISTA ORDENADA"); return new Symbol(Simbolos2.ol, yycolumn, yyline, yytext()); }

        ">" { System.out.println("Se reconocio "+yytext()+" de tipo MAYOR QUE"); return new Symbol(Simbolos2.MayorQue, yycolumn, yyline, yytext()); }

        "<" { System.out.println("Se reconocio "+yytext()+" de tipo MENOR QUE"); return new Symbol(Simbolos2.MenorQue, yycolumn, yyline, yytext()); }

        ">=" { System.out.println("Se reconocio "+yytext()+" de tipo MAYOR O IGUAL"); return new Symbol(Simbolos2.MayorIgual, yycolumn, yyline, yytext()); }

        "<=" { System.out.println("Se reconocio "+yytext()+" de tipo MENOR O IGUAL"); return new Symbol(Simbolos2.MenorIgual, yycolumn, yyline, yytext()); }

        "<>" { System.out.println("Se reconocio "+yytext()+" de tipo DIFERENTE DE"); return new Symbol(Simbolos2.DiferenteDe, yycolumn, yyline, yytext()); }

        "AND" { System.out.println("Se reconocio "+yytext()+" de tipo AND"); return new Symbol(Simbolos2.andd, yycolumn, yyline, yytext()); }

        "OR" { System.out.println("Se reconocio "+yytext()+" de tipo OR"); return new Symbol(Simbolos2.orr, yycolumn, yyline, yytext()); }

        "IF" { System.out.println("Se reconocio "+yytext()+" de tipo IF"); return new Symbol(Simbolos2.iff, yycolumn, yyline, yytext()); }

        "THEN" { System.out.println("Se reconocio "+yytext()+" de tipo THEN"); return new Symbol(Simbolos2.thenn, yycolumn, yyline, yytext()); }

        "ELSE" { System.out.println("Se reconocio "+yytext()+" de tipo ELSE"); return new Symbol(Simbolos2.elsee, yycolumn, yyline, yytext()); }

        "WHILE" { System.out.println("Se reconocio "+yytext()+" de tipo WHILE"); return new Symbol(Simbolos2.whilee, yycolumn, yyline, yytext()); }

        "FOR" { System.out.println("Se reconocio "+yytext()+" de tipo FOR"); return new Symbol(Simbolos2.forr, yycolumn, yyline, yytext()); }

        "TO" { System.out.println("Se reconocio "+yytext()+" de tipo TO"); return new Symbol(Simbolos2.too, yycolumn, yyline, yytext()); }

        "PRINT" { System.out.println("Se reconocio "+yytext()+" de tipo PRINT"); return new Symbol(Simbolos2.printt, yycolumn, yyline, yytext()); }

        "BEGIN" { System.out.println("Se reconocio "+yytext()+" de tipo BEGIN"); return new Symbol(Simbolos2.begin, yycolumn, yyline, yytext()); }

        "END" { System.out.println("Se reconocio "+yytext()+" de tipo END"); return new Symbol(Simbolos2.end, yycolumn, yyline, yytext()); }

        "TRUE" { System.out.println("Se reconocio "+yytext()+" de tipo TRUE"); return new Symbol(Simbolos2.truee, yycolumn, yyline, yytext()); }

        "FALSE" { System.out.println("Se reconocio "+yytext()+" de tipo FALSE"); return new Symbol(Simbolos2.falsee, yycolumn, yyline, yytext()); }

        ":=" { System.out.println("Se reconocio "+yytext()+" de tipo ASIGNACION"); return new Symbol(Simbolos2.Asignacion, yycolumn, yyline, yytext()); }
        
        ([hH][tT][mM][lL]) { System.out.println("Se reconocio "+yytext()+" de tipo HTML"); return new Symbol(Simbolos2.html, yycolumn, yyline, yytext()); }

        ([hH][eE][aA][dD]) { System.out.println("Se reconocio "+yytext()+" de tipo HEAD"); return new Symbol(Simbolos2.head, yycolumn, yyline, yytext()); }

        ([tT][iI][tT][lL][eE]) { System.out.println("Se reconocio "+yytext()+" de tipo TITLE"); return new Symbol(Simbolos2.title, yycolumn, yyline, yytext()); }

        ([bB][oO][dD][yY]) { System.out.println("Se reconocio "+yytext()+" de tipo BODY"); return new Symbol(Simbolos2.body, yycolumn, yyline, yytext()); }

        ([bB][gG][cC][oO][lL][oO][rR]) { System.out.println("Se reconocio "+yytext()+" de tipo BGCOLOR"); return new Symbol(Simbolos2.bgcolor, yycolumn, yyline, yytext()); }

        ([tT][eE][xX][tT]) { System.out.println("Se reconocio "+yytext()+" de tipo TEXT"); return new Symbol(Simbolos2.text, yycolumn, yyline, yytext()); }

        ([lL][iI][nN][kK]) { System.out.println("Se reconocio "+yytext()+" de tipo LINK"); return new Symbol(Simbolos2.link, yycolumn, yyline, yytext()); }

        ([cC][eE][nN][tT][eE][rR]) { System.out.println("Se reconocio "+yytext()+" de tipo CENTER"); return new Symbol(Simbolos2.center, yycolumn, yyline, yytext()); }

        ([aA][lL][iI][gG][nN]) { System.out.println("Se reconocio "+yytext()+" de tipo ALIGN"); return new Symbol(Simbolos2.align, yycolumn, yyline, yytext()); }

        ("\"")([cC][eE][nN][tT][eE][rR])("\"") { System.out.println("Se reconocio "+yytext()+" de tipo CENTER en comillas"); return new Symbol(Simbolos2.centerC, yycolumn, yyline, extraerInfo(yytext())); }

        ("\"")([lL][eE][fF][tT])("\"") { System.out.println("Se reconocio "+yytext()+" de tipo LEFT"); return new Symbol(Simbolos2.leftC, yycolumn, yyline, extraerInfo(yytext())); }

        ("\"")([rR][iI][gG][hH][tT])("\"") { System.out.println("Se reconocio "+yytext()+" de tipo RIGHT"); return new Symbol(Simbolos2.rightC, yycolumn, yyline, extraerInfo(yytext()));  }

        ("\"")([jJ][uU][sS][tT][iI][fF][iI][eE][dD])("\"") { System.out.println("Se reconocio "+yytext()+" de tipo JUSTIFIED"); return new Symbol(Simbolos2.justifiedC, yycolumn, yyline, extraerInfo(yytext())); }

        ([wW][iI][dD][tT][hH]) { System.out.println("Se reconocio "+yytext()+" de tipo WIDTH"); return new Symbol(Simbolos2.width, yycolumn, yyline, yytext()); }

        ([nN][oO][bB][rR]) { System.out.println("Se reconocio "+yytext()+" de tipo SIN SALTO DE LINEA"); return new Symbol(Simbolos2.nobr, yycolumn, yyline, yytext()); }

        ([sS][tT][rR][iI][kK][eE]) { System.out.println("Se reconocio "+yytext()+" de tipo TACHADO"); return new Symbol(Simbolos2.strike, yycolumn, yyline, yytext()); }

        ([nN][aA][mM][eE]) { System.out.println("Se reconocio "+yytext()+" de tipo NAME"); return new Symbol(Simbolos2.name, yycolumn, yyline, yytext()); }

        ([hH][rR][eE][fF]) { System.out.println("Se reconocio "+yytext()+" de tipo HREF"); return new Symbol(Simbolos2.href, yycolumn, yyline, yytext()); }

        ([bB][lL][iI][nN][kK]) { System.out.println("Se reconocio "+yytext()+" de tipo PARPADEANTE"); return new Symbol(Simbolos2.blink, yycolumn, yyline, yytext()); }

        ([sS][uU][bB]) { System.out.println("Se reconocio "+yytext()+" de tipo SUBINDICE"); return new Symbol(Simbolos2.sub, yycolumn, yyline, yytext()); }

        ([sS][uU][pP]) { System.out.println("Se reconocio "+yytext()+" de tipo SUPERINDICE"); return new Symbol(Simbolos2.sup, yycolumn, yyline, yytext()); }

        ([fF][oO][nN][tT]) { System.out.println("Se reconocio "+yytext()+" de tipo FONT"); return new Symbol(Simbolos2.font, yycolumn, yyline, yytext()); }

        ([sS][iI][zZ][eE]) { System.out.println("Se reconocio "+yytext()+" de tipo SIZE"); return new Symbol(Simbolos2.size, yycolumn, yyline, yytext()); }

        ([bB][lL][oO][cC][kK][qQ][uU][oO][tT][eE]) { System.out.println("Se reconocio "+yytext()+" de tipo SANGRIA"); return new Symbol(Simbolos2.blockquote, yycolumn, yyline, yytext()); }

        ([fF][aA][cC][eE]) { System.out.println("Se reconocio "+yytext()+" de tipo FACE"); return new Symbol(Simbolos2.face, yycolumn, yyline, yytext()); }

        ([cC][oO][lL][oO][rR]) { System.out.println("Se reconocio "+yytext()+" de tipo COLOR"); return new Symbol(Simbolos2.color, yycolumn, yyline, yytext()); }

        "INTEGER" { System.out.println("Se reconocio "+yytext()+" de tipo INTEGER"); return new Symbol(Simbolos2.integerr, yycolumn, yyline, yytext()); }

        "BOOLEAN" { System.out.println("Se reconocio "+yytext()+" de tipo BOOLEAN"); return new Symbol(Simbolos2.booleann, yycolumn, yyline, yytext()); }

        "STRING" { System.out.println("Se reconocio "+yytext()+" de tipo STRING"); return new Symbol(Simbolos2.stringg, yycolumn, yyline, yytext()); }

        "VAR" { System.out.println("Se reconocio "+yytext()+" de tipo VAR"); return new Symbol(Simbolos2.var, yycolumn, yyline, yytext()); }

        ("\"")([cC][iI][rR][cC][lL][eE])("\"") { System.out.println("Se reconocio "+yytext()+" de tipo CIRCLE"); return new Symbol(Simbolos2.circle, yycolumn, yyline, extraerInfo(yytext()));  }

        ("\"")([sS][qQ][uU][aA][rR][eE])("\"") { System.out.println("Se reconocio "+yytext()+" de tipo SQUARE"); return new Symbol(Simbolos2.square, yycolumn, yyline, extraerInfo(yytext())); }

        ("\"")([dD][iI][sS][cC])("\"") { System.out.println("Se reconocio "+yytext()+" de tipo DISC"); return new Symbol(Simbolos2.disc, yycolumn, yyline, extraerInfo(yytext()));  }

        ([tT][yY][pP][eE]) { System.out.println("Se reconocio "+yytext()+" de tipo TYPE"); return new Symbol(Simbolos2.type, yycolumn, yyline, yytext()); }

        ([sS][tT][aA][rR][tT]) { System.out.println("Se reconocio "+yytext()+" de tipo START"); return new Symbol(Simbolos2.startt, yycolumn, yyline, yytext()); }

        ("\"")("1")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Lista Numerada"); return new Symbol(Simbolos2.num1, yycolumn, yyline, extraerInfo(yytext()));  }

        ("\"")([aA])("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Lista con letras"); return new Symbol(Simbolos2.A, yycolumn, yyline, extraerInfo(yytext()));  }

        ("\"")("black")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color BLACK"); return new Symbol(Simbolos2.black, yycolumn, yyline, extraerInfo(yytext())); }

        ("\"")("olive")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color OLIVE"); return new Symbol(Simbolos2.olive, yycolumn, yyline, extraerInfo(yytext())); }

        ("\"")("teal")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color TEAL"); return new Symbol(Simbolos2.teal, yycolumn, yyline, extraerInfo(yytext())); }

        ("\"")("red")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color RED"); return new Symbol(Simbolos2.red, yycolumn, yyline, extraerInfo(yytext())); }

        ("\"")("blue")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color BLUE"); return new Symbol(Simbolos2.blue, yycolumn, yyline, extraerInfo(yytext())); }

        ("\"")("maroon")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color MAROON"); return new Symbol(Simbolos2.maroon, yycolumn, yyline, extraerInfo(yytext())); }

        ("\"")("navy")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color NAVY"); return new Symbol(Simbolos2.navy, yycolumn, yyline, extraerInfo(yytext())); }

        ("\"")("gray")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color GRAY"); return new Symbol(Simbolos2.gray, yycolumn, yyline, extraerInfo(yytext())); }

        ("\"")("lime")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color LIME"); return new Symbol(Simbolos2.lime, yycolumn, yyline, extraerInfo(yytext())); }

        ("\"")("fuchsia")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color FUCHSIA"); return new Symbol(Simbolos2.fuchsia, yycolumn, yyline, extraerInfo(yytext())); }

        ("\"")("green")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color GREEN"); return new Symbol(Simbolos2.green, yycolumn, yyline, extraerInfo(yytext())); }

        ("\"")("white")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color WHITE"); return new Symbol(Simbolos2.white, yycolumn, yyline, extraerInfo(yytext())); }

        ("\"")("purple")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color PURPLE"); return new Symbol(Simbolos2.purple, yycolumn, yyline, extraerInfo(yytext())); }

        ("\"")("silver")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color SILVER"); return new Symbol(Simbolos2.silver, yycolumn, yyline, extraerInfo(yytext())); }

        ("\"")("yellow")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color YELLOW"); return new Symbol(Simbolos2.yellow, yycolumn, yyline, extraerInfo(yytext())); }

        ("\"")("aqua")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color AQUA"); return new Symbol(Simbolos2.aqua, yycolumn, yyline, extraerInfo(yytext())); }

        ("\""){D}+("\"") { System.out.println("Se reconocio "+yytext()+" de tipo VALOR ENTERO"); return new Symbol(Simbolos2.valorEntero, yycolumn, yyline, extraerInfo(yytext()));  }

        ("\""){D}+("%")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo PORCENTAJE"); return new Symbol(Simbolos2.Porcentaje, yycolumn, yyline, extraerInfo(yytext()));  }

         ("\"")("#")(([a-fA-F]|[0-9]){6})("\"") { System.out.println("Se reconocio "+yytext()+" de tipo HEXADECIMAL"); return new Symbol(Simbolos2.Hexa, yycolumn, yyline, extraerInfo(yytext())); }

         {IDVAR}    { System.out.println("Se reconocio "+yytext()+" de tipo Variable"); return new Symbol(Simbolos2.Variable, yycolumn, yyline, yytext()); }

        {WHITE} { /*Se ignora*/}
        
        {LINETERMINATOR} {/*Se Ingnora*/}

        {D}+    { System.out.println("Se reconocio "+yytext()+" de tipo Numero"); return new Symbol(Simbolos2.Numero, yycolumn, yyline, yytext()); }

        ("\"")("#")~("\"") { System.out.println("Se reconocio "+yytext()+" de tipo TEXTO TIPO LINK"); return new Symbol(Simbolos2.TextoTLink, yycolumn, yyline, extraerInfo2(yytext())); }

        ("\"")~("\"") { System.out.println("Se reconocio "+yytext()+" de tipo TEXTO ENTRE COMILLAS"); return new Symbol(Simbolos2.TextoEComillas, yycolumn, yyline, extraerInfo(yytext())); }
         
}

. {System.out.println("Se reconocio el error lexico: "+yytext()+"."); return new Symbol(Simbolos2.ErrorLexico, yycolumn, yyline, yytext()); }



