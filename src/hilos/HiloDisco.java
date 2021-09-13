package hilos;

import servidorCliente.Cliente;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloDisco extends Thread {
    
    javax.swing.JLabel porcentajedisco;
    Cliente c;
    String porcentaje=null;
    
    public HiloDisco(javax.swing.JLabel porcentajedisco, Cliente c){
        this.porcentajedisco=porcentajedisco;
        this.c=c;
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
