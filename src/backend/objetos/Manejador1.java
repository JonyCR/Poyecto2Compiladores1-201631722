package backend.objetos;

import javax.swing.JTextArea;
import browser.gui.ventanas.*;
import java.io.StringReader;
import backend.analizadores.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jonyasus
 */
public class Manejador1 {

    List<String> codigoWhile = new ArrayList<>();
    List<String> condiciones = new ArrayList<>();
    public List<String> ops = new ArrayList<>();
    String operaciones = "";
    List<Boolean> condicionesIf;
    List<Variable> variables = new ArrayList<>();
    List<String> codigoHtml = new ArrayList<>();
    JTextArea areaDeEdicion;
    JTextArea areaDeHTML;
    Pestaña pestañaPrincipal;
    String print = "";
    String texto = "";
    String valVar = "";
    String nombreArchivo;
    JTable tablaDeSimbolos;
    DefaultTableModel modelo;
    Object[] simbolo = new Object[2];
    public ArrayList<NuevoError> erroresRecibidos = new ArrayList<>();
    ArrayList<String> codigoHtmlFinal = new ArrayList<>();
    public String htmlCompletoF = "";


    public Manejador1(JTextArea areaDeEdicion, Pestaña pestañaPrincipal, String nombreArchivo, JTable tablaDeSimbolos, JTextArea areaDeHTML) {
        this.condicionesIf = new ArrayList<>();
        this.areaDeEdicion = areaDeEdicion;
        this.areaDeHTML = areaDeHTML;
        this.pestañaPrincipal = pestañaPrincipal;
        this.nombreArchivo = nombreArchivo;
        this.tablaDeSimbolos = tablaDeSimbolos;
        modelo = (DefaultTableModel) tablaDeSimbolos.getModel();
    }

    public void analizarTexto(String texto, int tiempo) {
        //this.codigoHtml.clear();
        //this.condicionesIf.clear();
        this.areaDeHTML.setText("");
        this.codigoHtmlFinal.clear();
        this.texto = "";
        this.print = "";
        Primer_Analizador_Lexico lexico = new Primer_Analizador_Lexico(new StringReader(texto));
        Primer_Analizador_Sintactico sintactico = new Primer_Analizador_Sintactico(lexico, this, nombreArchivo, tiempo);
        try {
            nuevoHilo hilo = new nuevoHilo("hilo",sintactico);
            hilo.start();
        } catch (Exception e) {
        }
    }

    public void obtenerErrores(ArrayList<NuevoError> lista) {
        if (erroresRecibidos.isEmpty()) {
            erroresRecibidos = lista;
        } else {
            for (int i = 0; i < lista.size(); i++) {
                erroresRecibidos.add(lista.get(i));
            }
        }
    }

    public ArrayList<NuevoError> retornarErrores() {
        return erroresRecibidos;
    }

    public String retornarHTMLGenerado() {
        String htmlCompleto = "";
        for (int i = 0; i < codigoHtmlFinal.size(); i++) {
            htmlCompleto = htmlCompleto + " " + codigoHtmlFinal.get(i);
        }
        return htmlCompleto;
    }

    //instrucciones codigo embebido
    public void addVariable(String variable, String tipo, int fila, int columna) throws InterruptedException {
        codigoWhile.add("VAR " + variable + ":" + tipo + ";");
        if (obtenerVar(variable) == null) {
            if (agregar()) {
                this.variables.add(new Variable(variable, tipo));
                System.out.println("\n-----------------\n\n\n");
                System.out.println("variable: " + variable + ", tipo: " + tipo);
                System.out.println("\n------------------\n\n\n");
                simbolo[0] = variable;
                simbolo[1] = tipo;
                modelo.addRow(simbolo);
                //Thread.sleep(2000);
            }
        } else {
            //la variable ya existe
            System.out.println("La variable: " + variable + " ya existe.");
            erroresRecibidos.add(new NuevoError(fila, columna, "La variable: " + variable + " ya existe.", nombreArchivo, "Semantico"));
        }
    }

    public void defVar(String variable, String valor, int fila, int columna) throws InterruptedException {
        if (valor.contains("\"")) {
            codigoWhile.add(variable + " := " + "'" + valor.substring(0, valor.length() - 1) + "';");
        } else {
            if (operaciones.isEmpty()) {
                operaciones = ops.get(0);
            }
            codigoWhile.add(variable + " := " + operaciones + ";");
        }
        ops.clear();
        if (!variables.isEmpty()) {
            Variable var = obtenerVar(variable);
            if (var != null) {
                if (evaluarTipo(var.getTipo(), valor)) {
                    //todo en orden
                    if (agregar()) {
                        var.setValor(valor);
                        simbolo[0] = var.getNombre();
                        simbolo[1] = valor;
                        modelo.addRow(simbolo);
                        //Thread.sleep(5000);
                    }
                } else {
                    //no son del mismo tipo
                    System.out.println("Asignacion incompatible a: " + var.getNombre());
                    erroresRecibidos.add(new NuevoError(fila, columna, "Asignacion incompatible a: " + var.getNombre(), nombreArchivo, "Semantico"));
                }
            } else {
                //no se encontro la variable
                System.out.println("Variable " + var.getNombre() + " aun no declarada.");
                erroresRecibidos.add(new NuevoError(fila, columna, "Variable " + var.getNombre() + " aun no declarada.", nombreArchivo, "Semantico"));
            }
        } else {
            //no hay variables
            System.out.println("Actualmente no existe ninguna varaible.");
            erroresRecibidos.add(new NuevoError(fila, columna, "No existe ninguna variable declarada.", nombreArchivo, "Semantico"));
        }
    }

    public Variable obtenerVar(String nombre) {
        Variable resultado = null;
        for (int i = 0; i < variables.size(); i++) {
            if (variables.get(i).getNombre().equals(nombre)) {
                resultado = variables.get(i);
                break;
            }
        }
        return resultado;
    }

    public boolean evaluarTipo(String tipo, String valor) {
        boolean resultado = false;
        switch (tipo) {
            case "INTEGER":
                try {
                    int val = Integer.parseInt(valor);
                    resultado = true;
                } catch (Exception e) {

                }
                break;
            case "STRING":
                try {
                    if (valor.substring(valor.length() - 1, valor.length()).equals("\"")) {
                        String val = valor.substring(0, valor.length() - 1);
                        resultado = true;
                    }

                } catch (Exception e) {

                }

                break;
            case "BOOLEAN":
                if (valor.equals("TRUE") || valor.equals("FALSE")) {
                    resultado = true;
                }
                break;
        }
        return resultado;
    }

    public String getVarInt(String nombre, int fila, int columna) {
        ops.add(nombre);
        String resultado = "0";
        Variable var = obtenerVar(nombre);
        if (var != null) {
            if (var.getTipo().equals("INTEGER") && !var.getValor().equals("null")) {
                resultado = var.getValor();
            } else {
                //no es de tipo entero o el valor es null
                System.out.println("Asignacion incompatible a: " + var.getNombre());
                erroresRecibidos.add(new NuevoError(fila, columna, "No es de tipo entero o el valor es null", nombreArchivo, "Semantico"));
            }

        } else {
            //no existe la variable
            System.out.println("Variable aun no definida.");
            erroresRecibidos.add(new NuevoError(fila, columna, "Variable: " + nombre + " aun no definida.", nombreArchivo, "Semantico"));
        }
        return resultado;
    }

    public String getValorVar(String variable, int fila, int columna) {
        String resultado = "";
        Variable var = obtenerVar(variable);
        if (var != null) {
            resultado = var.getValor();
        } else {
            //no se encontro la variable
            System.out.println("No se encontro la variable: " + variable);
            erroresRecibidos.add(new NuevoError(fila, columna, "Variable: " + variable + " no encontrada.", nombreArchivo, "Semantico"));
        }
        return resultado;
    }

    public void print(String texto) {

        this.codigoWhile.add("PRINT(" + print + ");");
        if (agregar()) {
            this.codigoHtml.add(texto);
            codigoHtmlFinal.add(texto);
        }
    }

    public void addTexto(String texto) {
        this.codigoHtmlFinal.add(texto);
    }

    public void imprimirHTMLFinal() {
        for (int i = 0; i < this.codigoHtmlFinal.size(); i++) {
            System.out.print(" " + codigoHtmlFinal.get(i));
        }
         
        for (int i = 0; i < codigoHtmlFinal.size(); i++) {
            htmlCompletoF = htmlCompletoF + " " + codigoHtmlFinal.get(i);
        }
     
        areaDeHTML.setText(htmlCompletoF);
    }

    public boolean agregar() {
        boolean resultado = false;
        if (!condicionesIf.isEmpty()) {
            for (int i = 0; i < condicionesIf.size(); i++) {
                if (condicionesIf.get(i)) {
                    resultado = true;
                } else {
                    resultado = false;
                    break;
                }
            }
        } else {
            resultado = true;
        }
        return resultado;
    }

    public void cambiarValIf() {    
        condicionesIf.set(condicionesIf.size() - 1, !condicionesIf.get(condicionesIf.size() - 1));
    }

    public void funcionIf(String res) {
        if (res.equals("TRUE")) {
            condicionesIf.add(Boolean.TRUE);
        } else {
            condicionesIf.add(Boolean.FALSE);
        }
    }

    public String evaluarCondicion(Variable val1, String op, Variable val2, int fila, int columna) {
        String res = "FALSE";

        if (val1 != null && val2 != null) {

            switch (op) {
                case ">":
                    if (val1.getTipo().equals("INTEGER") && val2.getTipo().equals("INTEGER")) {
                        int num1 = Integer.parseInt(val1.getValor());
                        int num2 = Integer.parseInt(val2.getValor());
                        String aux;
                        if (val1.getNombre().contains(".")) {
                            aux = val1.getValor();
                        } else {
                            aux = val1.getNombre();
                        }
                        aux += op;
                        if (val2.getNombre().contains(".")) {
                            aux += val2.getValor();
                        } else {
                            aux += val2.getNombre();
                        }
                        condiciones.add(aux);
                        if (num1 > num2) {
                            res = "TRUE";
                        }
                    } else {
                        //los valores no son del mismo tipo
                        System.out.println("Los valores no son del mismo tipo.");
                        erroresRecibidos.add(new NuevoError(fila, columna, "Comparacion invalida.", nombreArchivo, "Semantico"));
                    }

                    break;
                case "<":
                    if (val1.getTipo().equals("INTEGER") && val2.getTipo().equals("INTEGER")) {
                        int num1 = Integer.parseInt(val1.getValor());
                        int num2 = Integer.parseInt(val2.getValor());
                        String aux;
                        if (val1.getNombre().contains(".")) {
                            aux = val1.getValor();
                        } else {
                            aux = val1.getNombre();
                        }
                        aux += op;
                        if (val2.getNombre().contains(".")) {
                            aux += val2.getValor();
                        } else {
                            aux += val2.getNombre();
                        }
                        condiciones.add(aux);
                        if (num1 < num2) {
                            res = "TRUE";
                        }
                    } else {
                        //los valores no son del mismo tipo
                        System.out.println("Los valores no son del mismo tipo.");
                        erroresRecibidos.add(new NuevoError(fila, columna, "Comparacion invalida.", nombreArchivo, "Semantico"));
                    }

                    break;
                case ">=":
                    if (val1.getTipo().equals("INTEGER") && val2.getTipo().equals("INTEGER")) {
                        int num1 = Integer.parseInt(val1.getValor());
                        int num2 = Integer.parseInt(val2.getValor());
                        String aux;
                        if (val1.getNombre().contains(".")) {
                            aux = val1.getValor();
                        } else {
                            aux = val1.getNombre();
                        }
                        aux += op;
                        if (val2.getNombre().contains(".")) {
                            aux += val2.getValor();
                        } else {
                            aux += val2.getNombre();
                        }
                        condiciones.add(aux);
                        if (num1 >= num2) {
                            res = "TRUE";
                        }
                    } else {
                        //los valores no son del mismo tipo
                        System.out.println("Los valores no son del mismo tipo.");
                        erroresRecibidos.add(new NuevoError(fila, columna, "Comparacion invalida.", nombreArchivo, "Semantico"));
                    }

                    break;
                case "<=":
                    if (val1.getTipo().equals("INTEGER") && val2.getTipo().equals("INTEGER")) {
                        int num1 = Integer.parseInt(val1.getValor());
                        int num2 = Integer.parseInt(val2.getValor());
                        String aux;
                        if (val1.getNombre().contains(".")) {
                            aux = val1.getValor();
                        } else {
                            aux = val1.getNombre();
                        }
                        aux += op;
                        if (val2.getNombre().contains(".")) {
                            aux += val2.getValor();
                        } else {
                            aux += val2.getNombre();
                        }
                        condiciones.add(aux);
                        if (num1 <= num2) {
                            res = "TRUE";
                        }
                    } else {
                        //los valores no son del mismo tipo o no son enteros
                        System.out.println("Los valores no son del mismo tipo.");
                        erroresRecibidos.add(new NuevoError(fila, columna, "Comparacion invalida.", nombreArchivo, "Semantico"));
                    }

                    break;
                case "=":
                    if (val1.getTipo().equals(val2.getTipo())) {
                        if (val1.getTipo().equals("STRING")) {
                            String aux;
                            if (val1.getNombre().contains(".")) {
                                aux = "'" + val1.getValor() + "'";
                            } else {
                                aux = val1.getNombre();
                            }
                            aux += op;
                            if (val2.getNombre().contains(".")) {
                                aux += "'" + val2.getValor() + "'";
                            } else {
                                aux += val2.getNombre();
                            }
                            condiciones.add(aux);
                        } else {
                            condiciones.add(val1.getValor() + op + val2.getValor());
                        }
                        if (val1.getValor().equals(val2.getValor())) {
                            res = "TRUE";
                        }
                    } else {
                        //las variables no son del mismo tipo
                        System.out.println("Los valores no son del mismo tipo.");
                        erroresRecibidos.add(new NuevoError(fila, columna, "Comparacion invalida.", nombreArchivo, "Semantico"));
                    }
                    break;
                case "<>":
                    if (val1.getTipo().equals(val2.getTipo())) {
                        if (val1.getTipo().equals("STRING")) {
                            String aux;
                            if (val1.getNombre().contains(".")) {
                                aux = "'" + val1.getValor() + "'";
                            } else {
                                aux = val1.getNombre();
                            }
                            aux += op;
                            if (val2.getNombre().contains(".")) {
                                aux += "'" + val2.getValor() + "'";
                            } else {
                                aux += val2.getNombre();
                            }
                            condiciones.add(aux);
                        } else {
                            condiciones.add(val1.getValor() + op + val2.getValor());
                        }
                        if (!val1.getValor().equals(val2.getValor())) {
                            res = "TRUE";
                        }
                    } else {
                        //las variables no son del mismo tipo
                        System.out.println("Los valores no son del mismo tipo.");
                        erroresRecibidos.add(new NuevoError(fila, columna, "Comparacion invalida.", nombreArchivo, "Semantico"));
                    }
                    break;
            }
        } else {
            //una variable no existe
            System.out.println("Una de las varialbes no existe.");
            erroresRecibidos.add(new NuevoError(fila, columna, "Una de las varialbes no existe.", nombreArchivo, "Semantico"));
        }
        return res;
    }

    public String conectoresLogicos(String val1, String op, String val2) {
        String resultado = "FALSE";
        if (condiciones.size() > 1) {
            texto = condiciones.get(0) + op + condiciones.get(1);
        } else {
            texto = texto + op + condiciones.get(0);
        }
        condiciones.clear();
        switch (op) {
            case "AND":
                if (val1.equals("TRUE") && val2.equals("TRUE")) {
                    resultado = "TRUE";
                }
                break;
            case "OR":
                if (val1.equals("TRUE") || val2.equals("TRUE")) {
                    resultado = "TRUE";
                }
                break;
        }
        return resultado;
    }

    public void printHtml() {
        System.out.println("\n\n\n\nCodigo: \n\n");
        for (int i = 0; i < this.codigoHtml.size(); i++) {
            System.out.println(this.codigoHtml.get(i));
        }
    }

    public void terminarIf() {
        condicionesIf.remove(condicionesIf.size() - 1);
    }

    public void addCondiconTexto(String res) {
        if (res.equals("TRUE")) {
            condicionesIf.add(Boolean.TRUE);
        } else {
            condicionesIf.add(Boolean.FALSE);
        }
        if (!condiciones.isEmpty()) {
            texto = texto + condiciones.get(0);
            condiciones.clear();
        }
        codigoWhile.clear();
    }

    public void stringPrint(String texto) {
        print = print + texto;
    }

    public void ejecutarWhile() {
        texto = "<%WHILE " + texto + "BEGIN [\n";
        for (int i = 0; i < codigoWhile.size(); i++) {
            texto += codigoWhile.get(i) + "\n";
        }
        texto = texto + "]END;%>";
        if (agregar()) {
            analizarTexto(texto, 0);
        }
        codigoWhile.clear();

    }

    public void limpiar() {
        int filas = tablaDeSimbolos.getRowCount();
        for (int i = 0; filas > i; i++) {
            modelo.removeRow(0);
        }
        htmlCompletoF="";
        this.erroresRecibidos.clear();
        this.codigoHtml.clear();
        this.codigoWhile.clear();
        this.condicionesIf.clear();
        this.texto = "";
        this.condiciones.clear();
        this.variables.clear();
        this.print = "";
    }

    public void operar(String op) {
        if (ops.size() > 1) {
            operaciones = ops.get(0) + op + ops.get(1);
        } else {
            operaciones += ops.get(0);
        }
        ops.clear();
    }
}
