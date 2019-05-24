package browser.gui.ventanas;

import backend.objetos.ManejadorDeErrores;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author angel
 */
public class Principal extends javax.swing.JFrame {

    String path;
    String pathRpm;
    int contadorArchivos = 0;
    ArrayList<String> listaDeNombresArchivos = new ArrayList<>();
    ManejadorDeErrores erroresManager = new ManejadorDeErrores();   
    ArrayList<Pestaña> listaPestanas = new ArrayList<>();

        
    public Principal() {
        this.setLocationRelativeTo(null);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        filesOpenTabbedPane = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        optionsMenu = new javax.swing.JMenu();
        openFileMenuItem = new javax.swing.JMenuItem();
        newFileMenuItem = new javax.swing.JMenuItem();
        CloseMenuItem = new javax.swing.JMenuItem();
        aCercaDe = new javax.swing.JMenu();
        infoMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        porErrorMenuItem = new javax.swing.JMenuItem();
        porTipoErrorMenuItem = new javax.swing.JMenuItem();
        porArchivoMenuItem = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compiladores 1 | Proyecto 2 2019");

        optionsMenu.setText("Archivo");

        openFileMenuItem.setText("Abrir");
        openFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileMenuItemActionPerformed(evt);
            }
        });
        optionsMenu.add(openFileMenuItem);

        newFileMenuItem.setText("Nuevo");
        newFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileMenuItemActionPerformed(evt);
            }
        });
        optionsMenu.add(newFileMenuItem);

        CloseMenuItem.setText("Cerrar Pestaña");
        CloseMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseMenuItemActionPerformed(evt);
            }
        });
        optionsMenu.add(CloseMenuItem);

        jMenuBar1.add(optionsMenu);

        aCercaDe.setText("Acerca de");
        aCercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aCercaDeActionPerformed(evt);
            }
        });

        infoMenuItem.setText("Información");
        infoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoMenuItemActionPerformed(evt);
            }
        });
        aCercaDe.add(infoMenuItem);

        jMenuBar1.add(aCercaDe);

        jMenu1.setText("Errores");

        porErrorMenuItem.setText("Por error");
        porErrorMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                porErrorMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(porErrorMenuItem);

        porTipoErrorMenuItem.setText("Por tipo de error");
        porTipoErrorMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                porTipoErrorMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(porTipoErrorMenuItem);

        porArchivoMenuItem.setText("Por archivo");
        porArchivoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                porArchivoMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(porArchivoMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filesOpenTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(filesOpenTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileMenuItemActionPerformed
        ImportarArchivo();
    }//GEN-LAST:event_openFileMenuItemActionPerformed

    private void newFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileMenuItemActionPerformed
        String contadorString;
        contadorString = String.valueOf(contadorArchivos);
        String nombreArchivo = "NuevoArchivo-" + contadorString;
        Pestaña nuevaPestaña = null;
        try {
            nuevaPestaña = new Pestaña("", "", nombreArchivo);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        filesOpenTabbedPane.add(nombreArchivo, nuevaPestaña);
        contadorArchivos++;
        listaDeNombresArchivos.add(nombreArchivo);
        listaPestanas.add(nuevaPestaña);
    }//GEN-LAST:event_newFileMenuItemActionPerformed

    private void CloseMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseMenuItemActionPerformed
        //Pestaña auxV = (Pestaña) this.filesOpenTabbedPane.getSelectedComponent();
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea cerrar la pestaña actual?", "Cerrar pestaña actual", JOptionPane.YES_NO_OPTION);
        if (respuesta == 0) {
            this.filesOpenTabbedPane.remove(this.filesOpenTabbedPane.getSelectedComponent());
        }

    }//GEN-LAST:event_CloseMenuItemActionPerformed

    private void aCercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aCercaDeActionPerformed

    }//GEN-LAST:event_aCercaDeActionPerformed

    private void infoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoMenuItemActionPerformed
        JOptionPane.showMessageDialog(this, "Desarrollado por: \nJonathan Daniel Chiroy Rivera. \nCarné: 201631722  \nCompiladores 1 2019", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_infoMenuItemActionPerformed

    private void porErrorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porErrorMenuItemActionPerformed
        erroresManager.listaDeErrores.clear();
        for (int i = 0; i < listaPestanas.size(); i++) {
            erroresManager.capturarTodosLosErrores(listaPestanas.get(i).manejador1.retornarErrores(), listaPestanas.get(i).manejador2.retornarErrores());
        }
        erroresManager.GuardarPorError();
    }//GEN-LAST:event_porErrorMenuItemActionPerformed

    private void porTipoErrorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porTipoErrorMenuItemActionPerformed
        erroresManager.listaDeErrores.clear();
       erroresManager.listaDeErrores.clear();
        for (int i = 0; i < listaPestanas.size(); i++) {
            erroresManager.capturarTodosLosErrores(listaPestanas.get(i).manejador1.retornarErrores(), listaPestanas.get(i).manejador2.retornarErrores());
        }
        erroresManager.GuardarPorTipoDeError();
    }//GEN-LAST:event_porTipoErrorMenuItemActionPerformed

    private void porArchivoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porArchivoMenuItemActionPerformed
        erroresManager.listaDeErrores.clear();
        erroresManager.listaDeErrores.clear();
        for (int i = 0; i < listaPestanas.size(); i++) {
            erroresManager.capturarTodosLosErrores(listaPestanas.get(i).manejador1.retornarErrores(), listaPestanas.get(i).manejador2.retornarErrores());
        }
        erroresManager.GuardarPorArchivoAnalizado(listaDeNombresArchivos);
    }//GEN-LAST:event_porArchivoMenuItemActionPerformed

    private void ImportarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Importar archivo de Texto");
        //Aqui se filtraran los archivos por su extension. Unicamente permitiraobservar archivos txt
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto .txt", "txt");
        fileChooser.setFileFilter(filtro);
        //condición para verificar si selecciona algún archivo
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File fichero = fileChooser.getSelectedFile();

            String pathArchivo = fileChooser.getSelectedFile().getPath();
            try {
                try (BufferedReader reader = new BufferedReader(new FileReader(fichero))) {
                    String lineaTotal = "";
                    String linea = reader.readLine();
                    while (linea != null) {
                        lineaTotal = lineaTotal + linea + System.getProperty("line.separator");
                        linea = reader.readLine();
                    }
                    reader.close();
                    try {
                        Pestaña nuevaPestaña = new Pestaña(pathArchivo, lineaTotal, obtnerNombreArchivo(pathArchivo));
                        filesOpenTabbedPane.add(obtnerNombreArchivo(pathArchivo), nuevaPestaña);
                        listaDeNombresArchivos.add(obtnerNombreArchivo(pathArchivo));
                        listaPestanas.add(nuevaPestaña);
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No has seleccionado ningun archivo de texto", "Sin archivo de texto", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private String obtnerNombreArchivo(String path) {
        String file = path.substring(path.lastIndexOf('/') + 1, path.lastIndexOf('.'));
        return file;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CloseMenuItem;
    private javax.swing.JMenu aCercaDe;
    private javax.swing.JTabbedPane filesOpenTabbedPane;
    private javax.swing.JMenuItem infoMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem newFileMenuItem;
    private javax.swing.JMenuItem openFileMenuItem;
    private javax.swing.JMenu optionsMenu;
    private javax.swing.JMenuItem porArchivoMenuItem;
    private javax.swing.JMenuItem porErrorMenuItem;
    private javax.swing.JMenuItem porTipoErrorMenuItem;
    // End of variables declaration//GEN-END:variables

}
