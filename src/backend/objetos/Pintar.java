package backend.objetos;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class Pintar {

    int posicion;
    public String tabulacion;
    public String sangria="     ";
    public JTextPane caja2;
    public StyleContext sc;
    public DefaultStyledDocument doc;
    Color colorText = Color.black;
    List<SimpleAttributeSet> estilos = new ArrayList();
    SimpleAttributeSet estiloAnidados;
    SimpleAttributeSet estiloFont;
    String tipoUl;
    List<datosOl> datosOl;
    int inicioOl=0;
    String tipoOl="1";

    Pintar(JTextPane caja2) {
        datosOl=new ArrayList<>();
        estiloAnidados = new SimpleAttributeSet();
        estiloFont = new SimpleAttributeSet();
        this.caja2 = caja2;
        sc = new StyleContext();
        doc = new DefaultStyledDocument(sc);
        tabulacion = "";
        insertarDatosOl();
    }

    public void tabular() {
        this.tabulacion += "     ";
    }

    public void insertarAlineado(String texto, String alineacion) {

        if (alineacion.equalsIgnoreCase("left")) {
            insertarLeft(texto);
        } else if (alineacion.equalsIgnoreCase("right")) {
            insertarRight(texto);
        } else if (alineacion.equalsIgnoreCase("justified")) {
            insertarJustified(texto);
        } else if (alineacion.equalsIgnoreCase("center")) {
            insertarCenter(texto);
        } else {
            insertarLeft(texto);
        }

    }

    public void ColorTexto(String color) {
        colorText = getColor(color);
    }

    public void insTab() {
        posicion = caja2.getText().length();
        caja2.setDocument(doc);
        try {
            doc.insertString(posicion, tabulacion, null);

        } catch (Exception ex) {
            System.out.println("ERROR: no se pudo establecer estilo de documento");
        }

    }

    public void resTabular() {
        this.tabulacion = this.tabulacion.substring(0, this.tabulacion.length() - 5);
    }

    public void insertar(String texto) {
        posicion = caja2.getText().length();
        caja2.setDocument(doc);
        try {
            doc.insertString(posicion, texto, null);

        } catch (Exception ex) {
            System.out.println("ERROR: no se pudo establecer estilo de documento");
        }

    }

    public void insertarCenter(String texto) {
        posicion = caja2.getText().length();
        //caja2.setDocument(doc);

        StyledDocument doc = caja2.getStyledDocument();
        SimpleAttributeSet centrado = new SimpleAttributeSet();
        StyleConstants.setAlignment(centrado, StyleConstants.ALIGN_CENTER);
        StyleConstants.setForeground(centrado, colorText);
        doc.setParagraphAttributes(doc.getLength(), texto.length(), centrado, true);
        try {
            doc.insertString(doc.getLength(), texto, centrado);
            //doc.insertString(posicion, texto, null);

        } catch (Exception ex) {
            System.out.println("ERROR: no se pudo establecer estilo de documento");
        }
        //--------------------

    }

    public void insertarLeft(String texto) {
        posicion = caja2.getText().length();
        //caja2.setDocument(doc);

        StyledDocument doc = caja2.getStyledDocument();
        SimpleAttributeSet centrado = new SimpleAttributeSet();
        StyleConstants.setAlignment(centrado, StyleConstants.ALIGN_LEFT);
        StyleConstants.setForeground(centrado, colorText);
        doc.setParagraphAttributes(doc.getLength(), texto.length(), centrado, true);
        try {
            doc.insertString(doc.getLength(), texto, centrado);
            //doc.insertString(posicion, texto, null);

        } catch (Exception ex) {
            System.out.println("ERROR: no se pudo establecer estilo de documento");
        }
        //--------------------

    }

    public void insertarRight(String texto) {
        posicion = caja2.getText().length();
        //caja2.setDocument(doc);

        StyledDocument doc = caja2.getStyledDocument();
        SimpleAttributeSet left = new SimpleAttributeSet();
        StyleConstants.setAlignment(left, StyleConstants.ALIGN_RIGHT);
        StyleConstants.setForeground(left, colorText);
        doc.setParagraphAttributes(doc.getLength(), texto.length(), left, true);
        try {
            doc.insertString(doc.getLength(), texto, left);
            //doc.insertString(posicion, texto, null);

        } catch (Exception ex) {
            System.out.println("ERROR: no se pudo establecer estilo de documento");
        }
        //--------------------

    }

    public void insertarJustified(String texto) {
        posicion = caja2.getText().length();
        //caja2.setDocument(doc);

        StyledDocument doc = caja2.getStyledDocument();
        SimpleAttributeSet centrado = new SimpleAttributeSet();
        StyleConstants.setAlignment(centrado, StyleConstants.ALIGN_JUSTIFIED);
        StyleConstants.setForeground(centrado, colorText);
        doc.setParagraphAttributes(doc.getLength(), texto.length(), centrado, true);
        try {
            doc.insertString(doc.getLength(), texto, centrado);
            //doc.insertString(posicion, texto, null);

        } catch (Exception ex) {
            System.out.println("ERROR: no se pudo establecer estilo de documento");
        }
        //--------------------

    }

    public void pintaRojo(int posini, int posfin) {
        Style rojo = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(rojo, Color.red);
        doc.setCharacterAttributes(posicion + posini, posfin, rojo, false);
    }

    public void pintaAmarillo(int posini, int posfin) {
        Style amarillo = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(amarillo, Color.YELLOW);
        doc.setCharacterAttributes(posicion + posini, posfin, amarillo, false);

    }

    public void pintaVerde(int posini, int posfin) {
        Style verde = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(verde, Color.green);
        doc.setCharacterAttributes(posicion + posini, posfin, verde, false);
    }

    public void pintaAzul(int posini, int posfin) {
        Style azul = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(azul, Color.blue);
        doc.setCharacterAttributes(posicion + posini, posfin, azul, false);

    }

    public void pintaNaranja(int posini, int posfin) {
        Style azul = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(azul, Color.ORANGE);
        doc.setCharacterAttributes(posicion + posini, posfin, azul, false);

    }

    public void pintaAzulO(int posini, int posfin) {
        Style azulo = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(azulo, Color.getHSBColor(240, 100, 55));
        doc.setCharacterAttributes(posini, posfin, azulo, false);

    }

    public void pintaCafe(int posini, int posfin) {
        Style cafe = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(cafe, Color.getHSBColor(0, 75, 65));
        doc.setCharacterAttributes(posini, posfin, cafe, false);
    }

    public void pintaMora(int posini, int posfin) {
        Style mora = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(mora, Color.MAGENTA);
        doc.setCharacterAttributes(posicion + posini, posfin, mora, false);
    }

    public void pintaNara(int posini, int posfin) {
        Style nara = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(nara, Color.getHSBColor(33, 100, 100));
        doc.setCharacterAttributes(posini, posfin, nara, false);
    }

    public Color getColor(String color) {
        Color result = Color.BLACK;
        switch (color) {
            case "black":
                result = Color.black;
                break;
            case "olive":
                result = Color.decode("#818723");
                break;
            case "teal":
                result = Color.decode("#139782");
                break;
            case "red":
                result = Color.red;
                break;
            case "blue":
                result = Color.BLUE;
                break;
            case "maroon":
                result = Color.decode("#AC0B0B");
                break;
            case "navy":
                result = Color.decode("#053872");
                break;
            case "gray":
                result = Color.GRAY;
                break;
            case "lime":
                result = Color.decode("#9BEC18");
                break;
            case "fuchsia":
                result = Color.decode("#EB158D");
                break;
            case "green":
                result = Color.GREEN;
                break;
            case "white":
                result = Color.WHITE;
                break;
            case "purple":
                result = Color.decode("#7F0CEC");
                break;
            case "silver":
                result = Color.decode("#ADADAE");
                break;
            case "yellow":
                result = Color.YELLOW;
                break;
            case "aqua":
                result = Color.decode("#11E3EF");
                break;
        }
        return result;

    }

    public void insertarUl(String tipo) {
        if (!tipo.equals("null")) {
            tabulacion = "     " + tipo + " ";
        } else {
            tabulacion = "     ";
        }
    }

    public void insertarLi(String texto) {
        insertarLeft(tabulacion + texto);
    }

    public void finUl() {
        tabulacion = "";
    }

    public void addSizeF(String size) {
        Integer inte = Integer.parseInt(size);
        StyleConstants.setFontSize(estiloFont, inte);
    }

    public void addAlinF(String alineacion) {
        if (alineacion.equalsIgnoreCase("left")) {
            StyleConstants.setAlignment(estiloFont, StyleConstants.ALIGN_LEFT);
        } else if (alineacion.equalsIgnoreCase("right")) {
            StyleConstants.setAlignment(estiloFont, StyleConstants.ALIGN_RIGHT);
        } else if (alineacion.equalsIgnoreCase("justified")) {
            StyleConstants.setAlignment(estiloFont, StyleConstants.ALIGN_JUSTIFIED);
        } else if (alineacion.equalsIgnoreCase("center")) {
            StyleConstants.setAlignment(estiloFont, StyleConstants.ALIGN_CENTER);
        } else {
            StyleConstants.setAlignment(estiloFont, StyleConstants.ALIGN_LEFT);
        }
    }

    public void addTextF(String texto) {
        try {
            StyleConstants.setFontFamily(estiloFont, texto);
        } catch (Exception e) {
        }
    }

    public void addColorF(String color) {
        StyleConstants.setForeground(estiloFont, getColor(color));
    }

    public void agregarFont(String texto) {
        posicion = caja2.getText().length();
        //caja2.setDocument(doc);

        StyledDocument doc = caja2.getStyledDocument();
        doc.setParagraphAttributes(doc.getLength(), texto.length(), estiloFont, true);
        try {
            doc.insertString(doc.getLength(), texto, estiloFont);
            estiloFont = new SimpleAttributeSet();
        } catch (Exception ex) {
            System.out.println("ERROR: no se pudo establecer estilo de documento");
        }
    }

    //funciones anidadas
    public void agregarNegrita(String texto) {
        StyleConstants.setBold(estiloAnidados, true);
        if (!texto.isEmpty()) {
            ejecutrarAnidadas(texto);
        }
    }

    public void agregarSubrayada(String texto) {
        StyleConstants.setUnderline(estiloAnidados, true);
        if (!texto.isEmpty()) {
            ejecutrarAnidadas(texto);
        }
    }

    public void agregarItalica(String texto) {
        StyleConstants.setItalic(estiloAnidados, true);
        if (!texto.isEmpty()) {
            ejecutrarAnidadas(texto);
        }
    }

    public void agregarTachado(String texto) {
        StyleConstants.setStrikeThrough(estiloAnidados, true);
        if (!texto.isEmpty()) {
            ejecutrarAnidadas(texto);
        }
    }

    public void agregarParpadeante(String texto) {
        if (!texto.isEmpty()) {
            ejecutrarAnidadas(texto);
        }
    }

    public void agregarSubIndice(String texto) {
        StyleConstants.setSubscript(estiloAnidados, true);
        if (!texto.isEmpty()) {
            ejecutrarAnidadas(texto);
        }
    }

    public void agregarSuperIndice(String texto) {
        StyleConstants.setSuperscript(estiloAnidados, true);
        if (!texto.isEmpty()) {
            ejecutrarAnidadas(texto);
        }
    }

    public void ejecutrarAnidadas(String texto) {
        posicion = caja2.getText().length();
        //caja2.setDocument(doc);

        StyledDocument doc = caja2.getStyledDocument();
        doc.setParagraphAttributes(doc.getLength(), texto.concat("\n").length(), estiloAnidados, true);
        try {
            doc.insertString(doc.getLength(), texto.concat("\n"), estiloAnidados);
        } catch (Exception ex) {
            System.out.println("ERROR: no se pudo establecer estilo de documento");
        }
    }
    
    public void insertarDatosOl(){
        this.datosOl.add(new datosOl(1,"A","a"));
        this.datosOl.add(new datosOl(2,"B","b"));
        this.datosOl.add(new datosOl(3,"C","c"));
        this.datosOl.add(new datosOl(4,"D","d"));
        this.datosOl.add(new datosOl(5,"E","e"));
        this.datosOl.add(new datosOl(6,"F","f"));
        this.datosOl.add(new datosOl(7,"G","g"));
        this.datosOl.add(new datosOl(8,"H","h"));
        this.datosOl.add(new datosOl(9,"I","i"));
        this.datosOl.add(new datosOl(10,"J","j"));
        this.datosOl.add(new datosOl(11,"K","k"));
        this.datosOl.add(new datosOl(12,"L","l"));
        this.datosOl.add(new datosOl(13,"M","m"));
        this.datosOl.add(new datosOl(14,"N","n"));
        this.datosOl.add(new datosOl(15,"O","o"));
        this.datosOl.add(new datosOl(16,"P","p"));
        this.datosOl.add(new datosOl(17,"Q","q"));
        this.datosOl.add(new datosOl(18,"R","r"));
        this.datosOl.add(new datosOl(19,"S","s"));
        this.datosOl.add(new datosOl(20,"T","t"));
        this.datosOl.add(new datosOl(21,"U","u"));
        this.datosOl.add(new datosOl(22,"V","v"));
        this.datosOl.add(new datosOl(23,"W","w"));
        this.datosOl.add(new datosOl(24,"X","x"));
        this.datosOl.add(new datosOl(25,"Y","y"));
        this.datosOl.add(new datosOl(26,"Z","z"));
    }
    
    public void olTipo(String e) {
        tipoOl=e;
    }

    public void olInicio(String e) {
        inicioOl=Integer.parseInt(e)-1;
    }

    public void addLiOl(String e) {
        switch (tipoOl) {
            case "1":
                    insertarLeft("     "+datosOl.get(inicioOl).getNum()+" "+e+"\n");
                    inicioOl++;
                break;
            case "A":
                    insertarLeft("     "+datosOl.get(inicioOl).getMayuscula()+" "+e+"\n");
                    inicioOl++;
                break;
            case "a":
                    insertarLeft("     "+datosOl.get(inicioOl).getMinuscula()+" "+e+"\n");
                    inicioOl++;
                break;
            default:
                    insertarLeft("     "+datosOl.get(inicioOl).getNum()+" "+e+"\n");
                    inicioOl++;
                break;
        }
    }

    public void finOl() {
        inicioOl=0;
    }
    public void saltoLinea(){
        insertarLeft("\n"); 
    }
    public void addEnlaceName(String nombre,String texto){
        insertarLeft(texto.concat("\n")); 
    }
    public void addEnlaceRef(String ref,String texto){
        insertarLeft(texto.concat("\n")); 
    }
    public void agregarNobr(String texto){
        insertarLeft(texto.concat("\n"));  
    }
    public void sangria(String texto){
        insertarLeft(sangria+texto.concat("\n")); 
    }

}
