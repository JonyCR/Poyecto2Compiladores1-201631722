/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package browser.gui.ventanas;

import backend.objetos.*;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author angel
 */
public class Pestaña extends javax.swing.JPanel {

    TextLineNumber lineNumber;
    TextLineNumber lineNumber2;
    String pathIn, nombreDeArchivo;
    String textoImportado;
    Manejador1 manejador1;
    Manejador2 manejador2;
    ArrayList<NuevoError> erroresEncontrados = new ArrayList<>();
    String htmlGenerado = "";

    /**
     * Creates new form ventana
     */
    public Pestaña(String path, String textoImportado, String nombreDeArchivo) throws IOException {

        initComponents();
        this.pathIn = path;
        this.nombreDeArchivo = nombreDeArchivo;
        this.textoImportado = textoImportado;
        manejador1 = new Manejador1(this.entradaTextArea, this, nombreDeArchivo, this.jTable1, this.htmlFinalTextArea);
        manejador2 = new Manejador2(this.entradaTextArea, this, this.salidaTextPane, this.tituloHTMLLabel, nombreDeArchivo);
        TextLineNumber lineNumber = new TextLineNumber(salidaTextPane);
        TextLineNumber lineNumber2 = new TextLineNumber(entradaTextArea);
        jScrollPane1.setRowHeaderView(lineNumber);
        jScrollPane3.setRowHeaderView(lineNumber2);
        entradaTextArea.setLineWrap(true);
        entradaTextArea.setText(textoImportado);
        entradaTextArea.addCaretListener(new CaretListener() {

            public void caretUpdate(CaretEvent e) {
                JTextArea editArea = (JTextArea) e.getSource();
                int linenum = 1;
                int columnnum = 1;
                try {
                    int caretpos = editArea.getCaretPosition();
                    linenum = editArea.getLineOfOffset(caretpos);
                    columnnum = caretpos - editArea.getLineStartOffset(linenum);
                    linenum += 1;
                } catch (Exception ex) {
                }
                updateStatus(linenum, columnnum);
            }
        });

    }

    private void updateStatus(int linenumber, int columnnumber) {
        lineColLabel.setText("Linea: " + linenumber + " Columna: " + columnnumber);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        salidaTextPane = new javax.swing.JTextPane();
        codigoEmbebidoButton = new javax.swing.JButton();
        lineColLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        entradaTextArea = new javax.swing.JTextArea();
        guardarButton = new javax.swing.JButton();
        verHTMLButton = new javax.swing.JButton();
        guardarComoButton = new javax.swing.JButton();
        tituloHTMLLabel = new javax.swing.JLabel();
        guardarErroresButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tiempoSpinner = new javax.swing.JSpinner();
        guardarHTMLButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        htmlFinalTextArea = new javax.swing.JTextArea();

        salidaTextPane.setEditable(false);
        jScrollPane1.setViewportView(salidaTextPane);

        codigoEmbebidoButton.setText("Codigo Embebido");
        codigoEmbebidoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoEmbebidoButtonActionPerformed(evt);
            }
        });

        lineColLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lineColLabel.setText("0");

        entradaTextArea.setColumns(20);
        entradaTextArea.setRows(5);
        jScrollPane3.setViewportView(entradaTextArea);

        guardarButton.setText("Guardar");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        verHTMLButton.setText("Visualizar HTML");
        verHTMLButton.setEnabled(false);
        verHTMLButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verHTMLButtonActionPerformed(evt);
            }
        });

        guardarComoButton.setText("Guardar Como");
        guardarComoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarComoButtonActionPerformed(evt);
            }
        });

        tituloHTMLLabel.setFont(new java.awt.Font("Laksaman", 1, 14)); // NOI18N
        tituloHTMLLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloHTMLLabel.setText("HMTL sin título");

        guardarErroresButton.setText("Errores por tipo");
        guardarErroresButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarErroresButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre de Variable", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel1.setText("Tiempo de debbug");

        tiempoSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        guardarHTMLButton.setText("Guardar HTML");
        guardarHTMLButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarHTMLButtonActionPerformed(evt);
            }
        });

        htmlFinalTextArea.setEditable(false);
        htmlFinalTextArea.setColumns(20);
        htmlFinalTextArea.setRows(5);
        jScrollPane4.setViewportView(htmlFinalTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(guardarButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(guardarComoButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lineColLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(codigoEmbebidoButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tiempoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(verHTMLButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(guardarHTMLButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                                .addComponent(guardarErroresButton))
                            .addComponent(jScrollPane1)
                            .addComponent(tituloHTMLLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarButton)
                    .addComponent(guardarComoButton)
                    .addComponent(lineColLabel)
                    .addComponent(tituloHTMLLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoEmbebidoButton)
                    .addComponent(verHTMLButton)
                    .addComponent(guardarErroresButton)
                    .addComponent(jLabel1)
                    .addComponent(tiempoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardarHTMLButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void codigoEmbebidoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoEmbebidoButtonActionPerformed
        htmlFinalTextArea.setText("");
        manejador1.limpiar();
        int value = (Integer) tiempoSpinner.getValue();
        int tiempoMs = value * 1000;
        manejador1.analizarTexto(entradaTextArea.getText(), tiempoMs);
        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
        htmlGenerado = manejador1.htmlCompletoF;
        verHTMLButton.setEnabled(true);
    }//GEN-LAST:event_codigoEmbebidoButtonActionPerformed

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        GuardarMenu();
    }//GEN-LAST:event_guardarButtonActionPerformed

    private void verHTMLButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verHTMLButtonActionPerformed
        System.out.println(" INICIO +++"+htmlGenerado+" ++++ FINAL");
        manejador2.analizarTexto(htmlFinalTextArea.getText(), 0);
       
        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~ HTML ANALIZADO ~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
        verHTMLButton.setEnabled(false);
    }//GEN-LAST:event_verHTMLButtonActionPerformed

    private void guardarComoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarComoButtonActionPerformed
        GuardarComo();
    }//GEN-LAST:event_guardarComoButtonActionPerformed

    private void guardarErroresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarErroresButtonActionPerformed
        erroresEncontrados.clear();
        erroresEncontrados = manejador1.erroresRecibidos;
        GuardarPorTipoDeError();
    }//GEN-LAST:event_guardarErroresButtonActionPerformed

    private void guardarHTMLButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarHTMLButtonActionPerformed
        // TODO add your handling code here:
        GuardarHTML();
    }//GEN-LAST:event_guardarHTMLButtonActionPerformed

    public void GuardarHTML() {

        if (htmlGenerado.equals("")) {//compara si en el JTextArea hay texto sino muestrtra un mensaje en pantalla
            JOptionPane.showMessageDialog(null, "¡No hay HTML para guardar!", "Oops!", JOptionPane.ERROR_MESSAGE);
        } else {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivo tipo HTML", "html", "HTML"));//filtro para ver solo archivos HTML
            int seleccion = fileChooser.showSaveDialog(null);
            try {
                if (seleccion == JFileChooser.APPROVE_OPTION) {//comprueba si ha presionado el boton de aceptar
                    File JFC = fileChooser.getSelectedFile();
                    String PATH = JFC.getAbsolutePath();//obtenemos el path del archivo a guardar
                    PrintWriter printwriter = new PrintWriter(JFC);
                    printwriter.print(htmlGenerado);
                    printwriter.close();//cierra el archivo
                    //comprobamos si a la hora de guardar obtuvo la extension y si no se la asignamos
                    if (!(PATH.endsWith(".html"))) {
                        File temp = new File(PATH + ".html");
                        JFC.renameTo(temp);//renombramos el archivo
                    }
                    JOptionPane.showMessageDialog(null, "El HTML se guardo correctamente.", "Guardado exitoso!", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {//por alguna excepcion salta un mensaje de error
                JOptionPane.showMessageDialog(null, "¡Error al guardar el archivo HTML!", "Oops! Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void GuardarPorTipoDeError() {
//listaDeErrores.add(new NuevoError(1, 2, "DescrSem", "ArcSem", "Semantico"));
//listaDeErrores.add(new NuevoError(1, 2, "DescrSin", "ArcSin", "Sintactico"));

        if (erroresEncontrados.isEmpty()) {//compara si en el JTextArea hay texto sino muestrtra un mensaje en pantalla
            JOptionPane.showMessageDialog(null, "¡No hay errores para guardar!", "Oops!", JOptionPane.ERROR_MESSAGE);
        } else {
            ArrayList<NuevoError> erroresSemanticos = new ArrayList<>();
            ArrayList<NuevoError> erroresSintacticos = new ArrayList<>();
            for (int i = 0; i < erroresEncontrados.size(); i++) {
                if (erroresEncontrados.get(i).getTipo().equals("Semantico")) {
                    erroresSemanticos.add(erroresEncontrados.get(i));
                } else if (erroresEncontrados.get(i).getTipo().equals("Sintactico")) {
                    erroresSintacticos.add(erroresEncontrados.get(i));
                }
            }
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivo tipo XML", "xml", "XML"));//filtro para ver solo archivos Kok
            int seleccion = fileChooser.showSaveDialog(null);
            try {
                if (seleccion == JFileChooser.APPROVE_OPTION) {//comprueba si ha presionado el boton de aceptar
                    File JFC = fileChooser.getSelectedFile();
                    String PATH = JFC.getAbsolutePath();//obtenemos el path del archivo a guardar
                    PrintWriter printwriter = new PrintWriter(JFC);
                    printwriter.print("<errores>\n");
                    printwriter.print("\t<sintacticos>\n");
                    for (int i = 0; i < erroresSintacticos.size(); i++) {
                        printwriter.print("\t\t<error" + i + ">\n");
                        printwriter.print("\t\t\t<linea> " + erroresSintacticos.get(i).getLinea() + " </linea>\n");
                        printwriter.print("\t\t\t<columna> " + erroresSintacticos.get(i).getColumna() + " </columna>\n");
                        printwriter.print("\t\t\t<descripcion> " + erroresSintacticos.get(i).getDescripcion() + " </descripcion>\n");
                        printwriter.print("\t\t\t<archivo> " + erroresSintacticos.get(i).getArchivo() + " </archivo>\n");
                        printwriter.print("\t\t</error" + i + ">\n");
                    }
                    printwriter.print("\t</sintacticos>\n");
                    printwriter.print("\t<semanticos>\n");
                    for (int i = 0; i < erroresSintacticos.size(); i++) {
                        printwriter.print("\t\t<error" + i + ">\n");
                        printwriter.print("\t\t\t<linea> " + erroresSemanticos.get(i).getLinea() + " </linea>\n");
                        printwriter.print("\t\t\t<columna> " + erroresSintacticos.get(i).getColumna() + " </columna>\n");
                        printwriter.print("\t\t\t<descripcion> " + erroresSemanticos.get(i).getDescripcion() + " </descripcion>\n");
                        printwriter.print("\t\t\t<archivo> " + erroresSemanticos.get(i).getArchivo() + " </archivo>\n");
                        printwriter.print("\t\t</error" + i + ">\n");
                    }
                    printwriter.print("\t</semanticos>\n");
                    printwriter.print("</errores>");
                    printwriter.close();//cierra el archivo
                    //comprobamos si a la hora de guardar obtuvo la extension y si no se la asignamos
                    if (!(PATH.endsWith(".xml"))) {
                        File temp = new File(PATH + ".xml");
                        JFC.renameTo(temp);//renombramos el archivo
                    }
                    JOptionPane.showMessageDialog(null, "Guardado exitoso!", "Guardado exitoso!", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {//por alguna excepcion salta un mensaje de error
                JOptionPane.showMessageDialog(null, "Error al guardar el archivo!", "Oops! Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton codigoEmbebidoButton;
    private javax.swing.JTextArea entradaTextArea;
    private javax.swing.JButton guardarButton;
    private javax.swing.JButton guardarComoButton;
    private javax.swing.JButton guardarErroresButton;
    private javax.swing.JButton guardarHTMLButton;
    private javax.swing.JTextArea htmlFinalTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lineColLabel;
    private javax.swing.JTextPane salidaTextPane;
    private javax.swing.JSpinner tiempoSpinner;
    private javax.swing.JLabel tituloHTMLLabel;
    private javax.swing.JButton verHTMLButton;
    // End of variables declaration//GEN-END:variables

    public void setText(String textIn) {
        entradaTextArea.setText(textIn);
    }

    /**
     * devuelve el texto del lado sin formato
     *
     * @return
     */
    public String getEntradaTextArea() {
        return entradaTextArea.getText();
    }

    /**
     * obtenemos el path de la ventana
     *
     *
     * @return
     */
    public String getPathIn() {
        return pathIn;
    }

    private void GuardarComo() {
        String texto = entradaTextArea.getText();//variable para comparacion
        if (texto.matches("[[ ]*[\n]*[\t]]*")) {//compara si en el JTextArea hay texto sino muestrtra un mensaje en pantalla
            JOptionPane.showMessageDialog(null, "¡No hay nada para guardar!", "Oops!", JOptionPane.ERROR_MESSAGE);
        } else {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivos de texto", "txt", "TXT"));//filtro para ver solo archivos Kok
            int seleccion = fileChooser.showSaveDialog(null);
            try {
                if (seleccion == JFileChooser.APPROVE_OPTION) {//comprueba si ha presionado el boton de aceptar
                    File JFC = fileChooser.getSelectedFile();
                    String PATH = JFC.getAbsolutePath();//obtenemos el path del archivo a guardar
                    PrintWriter printwriter = new PrintWriter(JFC);
                    printwriter.print(entradaTextArea.getText());//escribe en el archivo todo lo que se encuentre en el JTextArea
                    printwriter.close();//cierra el archivo
                    //comprobamos si a la hora de guardar obtuvo la extension y si no se la asignamos
                    if (!(PATH.endsWith(".txt"))) {
                        File temp = new File(PATH + ".txt");
                        JFC.renameTo(temp);//renombramos el archivo
                    }
                    JOptionPane.showMessageDialog(null, "Guardado exitoso!", "Guardado exitoso!", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {//por alguna excepcion salta un mensaje de error
                JOptionPane.showMessageDialog(null, "Error al guardar el archivo!", "Oops! Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void GuardarMenu() {
        if (pathIn.equals("")) {
            //Si detecta que estas trabajando un nuevo archivo abrira Guardar Como
            GuardarComo();
        } else {
            //si tienes un archivo abierto simplemente sobreescribira los cambios
            String ruta = pathIn;
            File archivo = new File(ruta);
            BufferedWriter bw;
            if (archivo.exists()) {
                try {
                    bw = new BufferedWriter(new FileWriter(archivo));
                    bw.write(entradaTextArea.getText());
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(Pestaña.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this, "Cambios guardados correctamente", "Guardado", JOptionPane.INFORMATION_MESSAGE);
                //Si el archivo abierto no existe por alguna razon, entonces creara uno nuevo
            } else {
                GuardarComo();
            }
        }
    }

}
