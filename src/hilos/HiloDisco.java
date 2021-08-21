package hilos;

import comunicacion.Cliente;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloDisco extends Thread {
    javax.swing.JLabel porcentajedisco;
    Cliente c;
    int contador=0;
    public HiloDisco(javax.swing.JLabel porcentajedisco, Cliente c){
        this.porcentajedisco=porcentajedisco;
        this.c=c;
    }
    
    public void run(){
        while(true){
            try {
                Thread.sleep((long) (0.3*1000));
                String porcentaje=c.comando("df --output=pcent /dev/sda2","-.-2");
                porcentaje=porcentaje.replace("Uso%","");
                porcentajedisco.setText(porcentaje);
                Thread.sleep(3*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloRam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
