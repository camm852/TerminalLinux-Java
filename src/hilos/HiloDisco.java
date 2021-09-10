package hilos;

import servidorCliente.Cliente;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloDisco extends Thread {
    
    javax.swing.JLabel porcentajedisco;
    javax.swing.JPanel graficoDisco;
    Cliente c;
    String porcentaje=null;
    
    public HiloDisco(javax.swing.JLabel porcentajedisco, Cliente c,javax.swing.JPanel graficoDisco){
        this.porcentajedisco=porcentajedisco;
        this.c=c;
        this.graficoDisco=graficoDisco;
        /*try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloDisco.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    public void run(){
        while(true){
            try {
                Thread.sleep(1);
                String porcentaje=c.comando("df --output=pcent /dev/sda2","-.-2");
                porcentaje=porcentaje.replace("Uso%","");
                this.porcentaje=porcentaje;
                Thread.sleep(5*1000);
                porcentajedisco.setText(porcentaje);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloRam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public String getDisco(){
        return this.porcentaje;
    }
    
  
}
