package backend.objetos;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author jonyasus
 */
public class ManejadorDeErrores {

    public ArrayList<NuevoError> listaDeErrores = new ArrayList<>();

    public ManejadorDeErrores() {
    }

    public void capturarTodosLosErrores(ArrayList<NuevoError> listaErrores1, ArrayList<NuevoError> listaErrores2) {
        for (int i = 0; i < listaErrores1.size(); i++) {
            listaDeErrores.add(listaErrores1.get(i));
        }
        for (int i = 0; i < listaErrores2.size(); i++) {
            listaDeErrores.add(listaErrores2.get(i));
        }
    }

    public void GuardarPorError() {

        if (listaDeErrores.isEmpty()) {//compara si en el JTextArea hay texto sino muestrtra un mensaje en pantalla
            JOptionPane.showMessageDialog(null, "¡No hay errores para guardar!", "Oops!", JOptionPane.ERROR_MESSAGE);
        } else {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivo tipo XML", "xml", "XML"));//filtro para ver solo archivos Kok
            int seleccion = fileChooser.showSaveDialog(null);
            try {
                if (seleccion == JFileChooser.APPROVE_OPTION) {//comprueba si ha presionado el boton de aceptar
                    File JFC = fileChooser.getSelectedFile();
                    String PATH = JFC.getAbsolutePath();//obtenemos el path del archivo a guardar
                    PrintWriter printwriter = new PrintWriter(JFC);
                    printwriter.print("<errores>\n");
                    for (int i = 0; i < listaDeErrores.size(); i++) {
                        printwriter.print("\t<error>\n");
                        printwriter.print("\t\t<linea> " + listaDeErrores.get(i).getLinea() + " </linea>\n");
                        printwriter.print("\t\t<columna> " + listaDeErrores.get(i).getColumna() + " </columna>\n");
                        printwriter.print("\t\t<descripcion> " + listaDeErrores.get(i).getDescripcion() + " </descripcion>\n");
                        printwriter.print("\t\t<archivo> " + listaDeErrores.get(i).getArchivo() + " </archivo>\n");
                        printwriter.print("\t</error>\n");
                    }
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

    public void GuardarPorTipoDeError() {
//listaDeErrores.add(new NuevoError(1, 2, "DescrSem", "ArcSem", "Semantico"));
//listaDeErrores.add(new NuevoError(1, 2, "DescrSin", "ArcSin", "Sintactico"));

        if (listaDeErrores.isEmpty()) {//compara si en el JTextArea hay texto sino muestrtra un mensaje en pantalla
            JOptionPane.showMessageDialog(null, "¡No hay errores para guardar!", "Oops!", JOptionPane.ERROR_MESSAGE);
        } else {
            ArrayList<NuevoError> erroresSemanticos = new ArrayList<>();
            ArrayList<NuevoError> erroresSintacticos = new ArrayList<>();
            for (int i = 0; i < listaDeErrores.size(); i++) {
                if (listaDeErrores.get(i).getTipo().equals("Semantico")) {
                    erroresSemanticos.add(listaDeErrores.get(i));
                } else if (listaDeErrores.get(i).getTipo().equals("Sintactico")) {
                    erroresSintacticos.add(listaDeErrores.get(i));
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
                    for (int i = 0; i < erroresSemanticos.size(); i++) {
                        printwriter.print("\t\t<error" + i + ">\n");
                        printwriter.print("\t\t\t<linea> " + erroresSemanticos.get(i).getLinea() + " </linea>\n");
                        printwriter.print("\t\t\t<columna> " + erroresSemanticos.get(i).getColumna() + " </columna>\n");
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

    public void GuardarPorArchivoAnalizado(ArrayList<String> nombreArchivos) {

        if (listaDeErrores.isEmpty()) {//compara si en el JTextArea hay texto sino muestrtra un mensaje en pantalla
            JOptionPane.showMessageDialog(null, "¡No hay errores para guardar!", "Oops!", JOptionPane.ERROR_MESSAGE);
        } else {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivo tipo XML", "xml", "XML"));//filtro para ver solo archivos Kok
            int seleccion = fileChooser.showSaveDialog(null);
            try {
                if (seleccion == JFileChooser.APPROVE_OPTION) {//comprueba si ha presionado el boton de aceptar
                    File JFC = fileChooser.getSelectedFile();
                    String PATH = JFC.getAbsolutePath();//obtenemos el path del archivo a guardar
                    PrintWriter printwriter = new PrintWriter(JFC);
                    printwriter.print("<errores>\n");
                    for (int i = 0; i < nombreArchivos.size(); i++) {
                        printwriter.print("\t<archivo nombre=\"" + nombreArchivos.get(i) + "\">\n");
                        for (int j = 0; j < listaDeErrores.size(); j++) {
                            if (listaDeErrores.get(j).getArchivo().equals(nombreArchivos.get(i))) {
                                printwriter.print("\t\t<error>\n");
                                printwriter.print("\t\t\t<linea> " + listaDeErrores.get(j).getLinea() + " </linea>\n");
                                printwriter.print("\t\t\t<columna> " + listaDeErrores.get(j).getColumna() + " </columna>\n");
                                printwriter.print("\t\t\t<descripcion> " + listaDeErrores.get(j).getDescripcion() + " </descripcion>\n");
                                printwriter.print("\t\t\t<tipo> " + listaDeErrores.get(j).getTipo() + " </tipo>\n");
                                printwriter.print("\t\t</error>\n");
                            }
                        }
                        printwriter.print("\t</archivo>\n");
                    }
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

}
