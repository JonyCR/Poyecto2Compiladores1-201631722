package backend.objetos;

import backend.analizadores.Primer_Analizador_Sintactico;
import java.util.logging.Level;
import java.util.logging.Logger;

public class nuevoHilo extends Thread {
     Primer_Analizador_Sintactico analizador;
     
    public nuevoHilo(String nombreHilo,Primer_Analizador_Sintactico analizador){
        super(nombreHilo);
        this.analizador=analizador;
    }
     
    @Override
    public void run(){
         try {
             this.analizador.parse();
         } catch (Exception ex) {
             Logger.getLogger(nuevoHilo.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
