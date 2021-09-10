package hilos;

import comunicacion.Cliente;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloProcesador extends Thread {
    javax.swing.JLabel porcentajeprocesador;
    Cliente c;
    String porcentaje="";
 
    public HiloProcesador(javax.swing.JLabel porcentajeprocesador, Cliente c){
        this.porcentajeprocesador=porcentajeprocesador;
        this.c=c;
    }
    
    public void run(){
        while(true){
            try {
                String porcentaje=c.comando("sar -u 1 1 | awk '{uso=($3+$5)} END {print uso \"%\"}'","-.-3");
                this.porcentaje=porcentaje;
                Thread.sleep(5*1000);
                porcentajeprocesador.setText(porcentaje);
            } catch (Exception ex) {
                Logger.getLogger(HiloRam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public String getProcesador(){
        return this.porcentaje;
    }
}
