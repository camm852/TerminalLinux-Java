package hilos;

import comunicacion.Cliente;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloProcesador extends Thread {
    javax.swing.JLabel porcentajeprocesador;
    Cliente c;
    int contador=0;
    public HiloProcesador(javax.swing.JLabel porcentajeprocesador, Cliente c){
        this.porcentajeprocesador=porcentajeprocesador;
        this.c=c;
    }
    
    public void run(){
        while(true){
            try {
                Thread.sleep((long) (0.1*1000));
                String porcentaje=c.comando("df --output=pcent /dev/sda2","-.-3");
                porcentaje=porcentaje.replace("Uso%","");
                porcentajeprocesador.setText(porcentaje);
                Thread.sleep((long) (1*1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloRam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
