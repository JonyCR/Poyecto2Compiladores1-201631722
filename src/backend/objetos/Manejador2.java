package backend.objetos;

import javax.swing.JTextArea;
import browser.gui.ventanas.*;
import java.io.StringReader;
import backend.analizadores.*;
import java.awt.Color;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java_cup.runtime.SymbolFactory;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jonyasus
 */
public class Manejador2 {

    JTextArea areaDeEdicion;
    Pestaña pestañaPrincipal;
    JTextPane areadeHTML;
    JLabel labelTitulo;
    String nombreArchivo;
    public ArrayList<NuevoError> erroresRecibidos = new ArrayList<>();
    Pintar pintar;
    public ArrayList<Etiqueta> etiquetasCreadas = new ArrayList<>();
    

    public Manejador2(JTextArea areaDeEdicion, Pestaña pestañaPrincipal, JTextPane areadeHTML, JLabel labelTitulo, String nombreArchivo) {
        this.areaDeEdicion = areaDeEdicion;
        this.nombreArchivo = nombreArchivo;
        this.pestañaPrincipal = pestañaPrincipal;
        this.areadeHTML = areadeHTML;
        this.labelTitulo = labelTitulo;
        pintar=new Pintar(areadeHTML);
    }

    public void analizarTexto(String texto, int tiempo) {
        this.areadeHTML.setText(""); 
        Segundo_Analizador_Lexico lexico = new Segundo_Analizador_Lexico(new StringReader(texto));
        Segundo_Analizador_Sintactico sintactico = new Segundo_Analizador_Sintactico(lexico, this, nombreArchivo, tiempo);
        try {
            sintactico.parse();
        } catch (Exception e) {
        }
    }

    public void colocarTitulo(String titulo) {
        labelTitulo.setText(titulo);
    }

    public void obtenerErrores(ArrayList<NuevoError> lista) {
        erroresRecibidos = lista;
    }

    public ArrayList<NuevoError> retornarErrores() {
        return erroresRecibidos;
    }
    

    public void pintarFondo(String color) {
        switch (color) {
            case "black":
                        areadeHTML.setBackground(Color.black);
                break;
                case "olive":
                        areadeHTML.setBackground(Color.decode("#818723"));
                break;
                case "teal":
                        areadeHTML.setBackground(Color.decode("#139782"));
                break;
                case "red":
                        areadeHTML.setBackground(Color.red);
                break;
                case "blue":
                        areadeHTML.setBackground(Color.BLUE);
                break;
                case "maroon":
                        areadeHTML.setBackground(Color.decode("#AC0B0B"));
                break;
                case "navy":
                        areadeHTML.setBackground(Color.decode("#053872"));
                break;
                case "gray":
                        areadeHTML.setBackground(Color.GRAY);
                break;
                case "lime":
                        areadeHTML.setBackground(Color.decode("#9BEC18"));
                break;
                case "fuchsia":
                        areadeHTML.setBackground(Color.decode("#EB158D"));
                break;
                case "green":
                        areadeHTML.setBackground(Color.GREEN);
                break;
                case "white":
                        areadeHTML.setBackground(Color.WHITE);
                break;
                case "purple":
                        areadeHTML.setBackground(Color.decode("#7F0CEC"));
                break;
                case "silver":
                        areadeHTML.setBackground(Color.decode("#ADADAE"));
                break;
                case "yellow":
                        areadeHTML.setBackground(Color.YELLOW);
                break;
                case "aqua":
                        areadeHTML.setBackground(Color.decode("#11E3EF"));
                break;
                default:
                    areadeHTML.setBackground(Color.decode(color));
                    break;
        }
    }
    
    public void crearReferencia(String nombre, int fila, int columna) {
        etiquetasCreadas.add(new Etiqueta(fila, columna, nombre));
    }
    
    public void colorTexto(String color){
        pintar.ColorTexto(color); 
    }
    public void escribir(String texto){
        pintar.insertar(texto);
    }
    public void escribirCentrado(String texto){
        pintar.insertarCenter(texto); 
    }
    public void pAlign(String texto,String align){
        pintar.insertarAlineado(texto,align);
    }

    public void addUl(String tipo) {
        pintar.insertarUl(tipo);
    }
    public void addLi(String texto){
        pintar.insertarLi(texto);
    }
    public void finUl(){
        pintar.finUl();
    }
    public void addSizeF(String size){
        pintar.addSizeF(size);
    }
    public void addAlinF(String align){
        pintar.addAlinF(align); 
    }
    public void addTextF(String texto){
        pintar.addTextF(texto); 
    }
    public void addColorF(String color){
        pintar.addColorF(color); 
    }
    public void agregarFont(String texto){
        pintar.agregarFont(texto); 
    }
    
    //funciones anidadas
    
    public void agregarNegrita(String texto) {
        pintar.agregarNegrita(texto);
    }

    public void agregarSubrayada(String texto) {
        pintar.agregarSubrayada(texto);
    }

    public void agregarItalica(String texto) {
        pintar.agregarItalica(texto);
    }

    public void agregarTachado(String texto) {
        pintar.agregarTachado(texto);
    }

    public void agregarParpadeante(String texto) {
        pintar.agregarParpadeante(texto);
    }

    public void agregarSubIndice(String texto) {
        pintar.agregarSubIndice(texto);
    }

    public void agregarSuperIndice(String texto) {
        pintar.agregarSuperIndice(texto);
    }

    public void olTipo(String e) {
        pintar.olTipo(e);
    }

    public void olInicio(String e) {
        pintar.olInicio(e); 
    }

    public void addLiOl(String e) {
        pintar.addLiOl(e); 
    }

    public void finOl() {
        pintar.finOl();
    }
    
    
    public void saltoLinea(){
        pintar.saltoLinea();
    }
    public void addEnlaceName(String nombre,String texto){
        pintar.addEnlaceName(nombre, texto);
    }
    public void addEnlaceRef(String ref,String texto){
        pintar.addEnlaceRef(ref, texto); 
    }
    public void agregarNobr(String texto){
        pintar.agregarNobr(texto); 
    }
    public void sangria(String texto){
        pintar.sangria(texto); 
    }

}
