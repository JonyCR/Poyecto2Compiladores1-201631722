
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

%}

//-------> Directivas
%public 
%class Primer_Analizador_Lexico
%cupsym Simbolos1
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

        "&lt"    { System.out.println("Se reconocio "+yytext()+" de tipo TEXTO MENOR QUE"); return new Symbol(Simbolos1.SEMenorQue, yycolumn, yyline, yytext()); }

         "&gt"    { System.out.println("Se reconocio "+yytext()+" de tipo TEXTO MAYOR QUE"); return new Symbol(Simbolos1.SEMayorQue, yycolumn, yyline, yytext()); }

         "&amp"    { System.out.println("Se reconocio "+yytext()+" de tipo TEXTO AMPERSAND &"); return new Symbol(Simbolos1.SEAmpersand, yycolumn, yyline, yytext()); }

         "&aacute"    { System.out.println("Se reconocio "+yytext()+" de tipo a con TILDE"); return new Symbol(Simbolos1.SEa, yycolumn, yyline, yytext()); }

         "&eacute"    { System.out.println("Se reconocio "+yytext()+" de tipo e con TILDE"); return new Symbol(Simbolos1.SEe, yycolumn, yyline, yytext()); }

         "&iacute"    { System.out.println("Se reconocio "+yytext()+" de tipo i con TILDE"); return new Symbol(Simbolos1.SEi, yycolumn, yyline, yytext()); }

         "&oacute"    { System.out.println("Se reconocio "+yytext()+" de tipo o con TILDE"); return new Symbol(Simbolos1.SEo, yycolumn, yyline, yytext()); }

         "&uacute"    { System.out.println("Se reconocio "+yytext()+" de tipo u con TILDE"); return new Symbol(Simbolos1.SEu, yycolumn, yyline, yytext()); }

         "&Ntilde"    { System.out.println("Se reconocio "+yytext()+" de tipo Ñ dentro de TEXTO"); return new Symbol(Simbolos1.SEN, yycolumn, yyline, yytext()); }

         "&ntilde"    { System.out.println("Se reconocio "+yytext()+" de tipo ñ dentro de TEXTO"); return new Symbol(Simbolos1.SEn, yycolumn, yyline, yytext()); }

         ("\"")([cC][eE][nN][tT][eE][rR])("\"") { System.out.println("Se reconocio "+yytext()+" de tipo CENTER en comillas"); return new Symbol(Simbolos1.centerC, yycolumn, yyline, yytext());}

        ("\"")([lL][eE][fF][tT])("\"") { System.out.println("Se reconocio "+yytext()+" de tipo LEFT"); return new Symbol(Simbolos1.leftC, yycolumn, yyline, yytext());}

        ("\"")([rR][iI][gG][hH][tT])("\"") { System.out.println("Se reconocio "+yytext()+" de tipo RIGHT"); return new Symbol(Simbolos1.rightC, yycolumn, yyline, yytext()); }

        ("\"")([jJ][uU][sS][tT][iI][fF][iI][eE][dD])("\"") { System.out.println("Se reconocio "+yytext()+" de tipo JUSTIFIED"); return new Symbol(Simbolos1.justifiedC, yycolumn, yyline, yytext());}

         ("\"")([cC][iI][rR][cC][lL][eE])("\"") { System.out.println("Se reconocio "+yytext()+" de tipo CIRCLE"); return new Symbol(Simbolos1.circle, yycolumn, yyline, yytext()); }

        ("\"")([sS][qQ][uU][aA][rR][eE])("\"") { System.out.println("Se reconocio "+yytext()+" de tipo SQUARE"); return new Symbol(Simbolos1.square, yycolumn, yyline, yytext());}

        ("\"")([dD][iI][sS][cC])("\"") { System.out.println("Se reconocio "+yytext()+" de tipo DISC"); return new Symbol(Simbolos1.disc, yycolumn, yyline, yytext()); }
        
        ("\"")("1")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Lista Numerada"); return new Symbol(Simbolos1.num1, yycolumn, yyline, yytext()); }

        ("\"")([aA])("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Lista con letras"); return new Symbol(Simbolos1.AA, yycolumn, yyline, yytext()); }

        ("\"")("black")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color BLACK"); return new Symbol(Simbolos1.black, yycolumn, yyline, yytext());}

        ("\"")("olive")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color OLIVE"); return new Symbol(Simbolos1.olive, yycolumn, yyline, yytext());}

        ("\"")("teal")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color TEAL"); return new Symbol(Simbolos1.teal, yycolumn, yyline, yytext());}

        ("\"")("red")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color RED"); return new Symbol(Simbolos1.red, yycolumn, yyline, yytext());}

        ("\"")("blue")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color BLUE"); return new Symbol(Simbolos1.blue, yycolumn, yyline, yytext());}

        ("\"")("maroon")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color MAROON"); return new Symbol(Simbolos1.maroon, yycolumn, yyline, yytext());}

        ("\"")("navy")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color NAVY"); return new Symbol(Simbolos1.navy, yycolumn, yyline, yytext());}

        ("\"")("gray")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color GRAY"); return new Symbol(Simbolos1.gray, yycolumn, yyline, yytext());}

        ("\"")("lime")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color LIME"); return new Symbol(Simbolos1.lime, yycolumn, yyline, yytext());}

        ("\"")("fuchsia")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color FUCHSIA"); return new Symbol(Simbolos1.fuchsia, yycolumn, yyline, yytext());}

        ("\"")("green")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color GREEN"); return new Symbol(Simbolos1.green, yycolumn, yyline, yytext());}

        ("\"")("white")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color WHITE"); return new Symbol(Simbolos1.white, yycolumn, yyline, yytext());}

        ("\"")("purple")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color PURPLE"); return new Symbol(Simbolos1.purple, yycolumn, yyline, yytext());}

        ("\"")("silver")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color SILVER"); return new Symbol(Simbolos1.silver, yycolumn, yyline, yytext());}

        ("\"")("yellow")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color YELLOW"); return new Symbol(Simbolos1.yellow, yycolumn, yyline, yytext());}

        ("\"")("aqua")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo Color AQUA"); return new Symbol(Simbolos1.aqua, yycolumn, yyline, yytext());}

        ("\""){D}+("\"") { System.out.println("Se reconocio "+yytext()+" de tipo VALOR ENTERO"); return new Symbol(Simbolos1.valorEntero, yycolumn, yyline, yytext()); }

        ("\""){D}+("%")("\"") { System.out.println("Se reconocio "+yytext()+" de tipo PORCENTAJE"); return new Symbol(Simbolos1.Porcentaje, yycolumn, yyline, yytext()); }

         ("\"")("#")(([a-fA-F]|[0-9]){6})("\"") { System.out.println("Se reconocio "+yytext()+" de tipo HEXADECIMAL"); return new Symbol(Simbolos1.Hexa, yycolumn, yyline, yytext());}
        
         ("\"")("#")~("\"") { System.out.println("Se reconocio "+yytext()+" de tipo TEXTO TIPO LINK"); return new Symbol(Simbolos1.TextoTLink, yycolumn, yyline, yytext()); }

        ("\"")~("\"") { System.out.println("Se reconocio "+yytext()+" de tipo TEXTO ENTRE COMILLAS"); return new Symbol(Simbolos1.TextoEComillas, yycolumn, yyline, yytext());}



          ("<%") { System.out.println("Se reconocio "+yytext()+" de tipo Abrir CODIGO EMBEBIDO"); return new Symbol(Simbolos1.AbrirCE, yycolumn, yyline, yytext()); }
       
          ("%>") { System.out.println("Se reconocio "+yytext()+" de tipo Cerrar CODIGO EMBEBIDO"); return new Symbol(Simbolos1.CerrarCE, yycolumn, yyline, yytext()); }

         "["    { System.out.println("Se reconocio "+yytext()+" de tipo Abrir Corchetes"); return new Symbol(Simbolos1.AbrirCorchetes, yycolumn, yyline, yytext()); }

         ("'")~("'")    { System.out.println("Se reconocio "+yytext()+" de tipo TEXTO ENTRE COMILLA SIMPLE"); return new Symbol(Simbolos1.TextoEComilla, yycolumn, yyline, extraerInfo(yytext())); }

         ("\"")    { System.out.println("Se reconocio "+yytext()+" de tipo COMILLAS"); return new Symbol(Simbolos1.Comillas, yycolumn, yyline, extraerInfo(yytext())); }

         ":"    { System.out.println("Se reconocio "+yytext()+" de tipo Dos Puntos"); return new Symbol(Simbolos1.DosPuntos, yycolumn, yyline, yytext()); }

         ";"    { System.out.println("Se reconocio "+yytext()+" de tipo Punto y Coma"); return new Symbol(Simbolos1.PuntoYComa, yycolumn, yyline, yytext()); }

         "]"    { System.out.println("Se reconocio "+yytext()+" de tipo Cerrar Corchetes"); return new Symbol(Simbolos1.CerrarCorchetes, yycolumn, yyline, yytext()); }

         "("    { System.out.println("Se reconocio "+yytext()+" de tipo Abrir Parentesis"); return new Symbol(Simbolos1.AbrirParentesis, yycolumn, yyline, yytext()); }

         ")"    { System.out.println("Se reconocio "+yytext()+" de tipo Cerrar Parentesis"); return new Symbol(Simbolos1.CerrarParentesis, yycolumn, yyline, yytext()); }

         ","    { System.out.println("Se reconocio "+yytext()+" de tipo Coma"); return new Symbol(Simbolos1.Coma, yycolumn, yyline, yytext()); }

         "="    { System.out.println("Se reconocio "+yytext()+" de tipo Igual"); return new Symbol(Simbolos1.Igual, yycolumn, yyline, yytext()); }

         "+"    { System.out.println("Se reconocio "+yytext()+" de tipo Suma"); return new Symbol(Simbolos1.Mas, yycolumn, yyline, yytext()); }

         "-"    { System.out.println("Se reconocio "+yytext()+" de tipo Resta"); return new Symbol(Simbolos1.Menos, yycolumn, yyline, yytext()); }

         "/"    { System.out.println("Se reconocio "+yytext()+" de tipo Division"); return new Symbol(Simbolos1.Diagonal, yycolumn, yyline, yytext()); }

         "*"    { System.out.println("Se reconocio "+yytext()+" de tipo Multiplicacion"); return new Symbol(Simbolos1.Asterisco, yycolumn, yyline, yytext()); }

        ">" { System.out.println("Se reconocio "+yytext()+" de tipo MAYOR QUE"); return new Symbol(Simbolos1.MayorQue, yycolumn, yyline, yytext()); }

        "<" { System.out.println("Se reconocio "+yytext()+" de tipo MENOR QUE"); return new Symbol(Simbolos1.MenorQue, yycolumn, yyline, yytext()); }

        ">=" { System.out.println("Se reconocio "+yytext()+" de tipo MAYOR O IGUAL"); return new Symbol(Simbolos1.MayorIgual, yycolumn, yyline, yytext()); }

        "<=" { System.out.println("Se reconocio "+yytext()+" de tipo MENOR O IGUAL"); return new Symbol(Simbolos1.MenorIgual, yycolumn, yyline, yytext()); }

        "<>" { System.out.println("Se reconocio "+yytext()+" de tipo DIFERENTE DE"); return new Symbol(Simbolos1.DiferenteDe, yycolumn, yyline, yytext()); }

        "AND" { System.out.println("Se reconocio "+yytext()+" de tipo AND"); return new Symbol(Simbolos1.andd, yycolumn, yyline, yytext()); }

        "OR" { System.out.println("Se reconocio "+yytext()+" de tipo OR"); return new Symbol(Simbolos1.orr, yycolumn, yyline, yytext()); }

        "IF" { System.out.println("Se reconocio "+yytext()+" de tipo IF"); return new Symbol(Simbolos1.iff, yycolumn, yyline, yytext()); }

        "THEN" { System.out.println("Se reconocio "+yytext()+" de tipo THEN"); return new Symbol(Simbolos1.thenn, yycolumn, yyline, yytext()); }

        "ELSE" { System.out.println("Se reconocio "+yytext()+" de tipo ELSE"); return new Symbol(Simbolos1.elsee, yycolumn, yyline, yytext()); }

        "WHILE" { System.out.println("Se reconocio "+yytext()+" de tipo WHILE"); return new Symbol(Simbolos1.whilee, yycolumn, yyline, yytext()); }

        "FOR" { System.out.println("Se reconocio "+yytext()+" de tipo FOR"); return new Symbol(Simbolos1.forr, yycolumn, yyline, yytext()); }

        "TO" { System.out.println("Se reconocio "+yytext()+" de tipo TO"); return new Symbol(Simbolos1.too, yycolumn, yyline, yytext()); }

        "PRINT" { System.out.println("Se reconocio "+yytext()+" de tipo PRINT"); return new Symbol(Simbolos1.printt, yycolumn, yyline, yytext()); }

        "BEGIN" { System.out.println("Se reconocio "+yytext()+" de tipo BEGIN"); return new Symbol(Simbolos1.begin, yycolumn, yyline, yytext()); }

        "END" { System.out.println("Se reconocio "+yytext()+" de tipo END"); return new Symbol(Simbolos1.end, yycolumn, yyline, yytext()); }

        "TRUE" { System.out.println("Se reconocio "+yytext()+" de tipo TRUE"); return new Symbol(Simbolos1.truee, yycolumn, yyline, yytext()); }

        "FALSE" { System.out.println("Se reconocio "+yytext()+" de tipo FALSE"); return new Symbol(Simbolos1.falsee, yycolumn, yyline, yytext()); }

        ":=" { System.out.println("Se reconocio "+yytext()+" de tipo ASIGNACION"); return new Symbol(Simbolos1.Asignacion, yycolumn, yyline, yytext()); }

        "INTEGER" { System.out.println("Se reconocio "+yytext()+" de tipo INTEGER"); return new Symbol(Simbolos1.integerr, yycolumn, yyline, yytext()); }

        "BOOLEAN" { System.out.println("Se reconocio "+yytext()+" de tipo BOOLEAN"); return new Symbol(Simbolos1.booleann, yycolumn, yyline, yytext()); }

        "STRING" { System.out.println("Se reconocio "+yytext()+" de tipo STRING"); return new Symbol(Simbolos1.stringg, yycolumn, yyline, yytext()); }
  
        "VAR" { System.out.println("Se reconocio "+yytext()+" de tipo VAR"); return new Symbol(Simbolos1.var, yycolumn, yyline, yytext()); }                          

         {IDVAR}    { System.out.println("Se reconocio "+yytext()+" de tipo Variable"); return new Symbol(Simbolos1.Variable, yycolumn, yyline, yytext()); }

        {WHITE} { /*Se ignora*/}
        
        {LINETERMINATOR} {/*Se Ingnora*/}

        {D}+    { System.out.println("Se reconocio "+yytext()+" de tipo Numero"); return new Symbol(Simbolos1.Numero, yycolumn, yyline, yytext()); }
         
}

. {System.out.println("Se reconocio el error lexico: "+yytext()+"."); return new Symbol(Simbolos1.ErrorLexico, yycolumn, yyline, yytext()); }


