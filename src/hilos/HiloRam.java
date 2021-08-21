package hilos;

import comunicacion.Cliente;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HiloRam extends Thread {
    javax.swing.JLabel porcentajememoria;
    Cliente c;
    int contador=0;
    public HiloRam(javax.swing.JLabel porcentajememoria, Cliente c){
        this.porcentajememoria=porcentajememoria;
        this.c=c;
    }
    
    public void run(){        
        while(true){
           
            try {
                String resultadoComando=c.comando("vmstat -s -S M","-.-1");
                String [] usedMemory= null;
                String porcentajeUsado = null,porcentajeTotal=null;
                
                usedMemory=resultadoComando.split("\n");
                System.out.println(usedMemory);
                for(int i=0;i<usedMemory.length;i++){
                    System.out.println(usedMemory[i]+"\n");
                    if(usedMemory[i].contains("used memory")){
                        porcentajeUsado=usedMemory[i];
                        break;
                    }
                }
                for(int i=0;i<usedMemory.length;i++){
                    System.out.println(usedMemory[i]+"\n");
                    if(usedMemory[i].contains("total memory")){
                        porcentajeTotal=usedMemory[i];
                        break;
                    }
                }
                
                   
                System.out.println("usado:"+ porcentajeUsado);
                System.out.println("total: "+ porcentajeTotal);
                porcentajememoria.setText(arreglarComando(porcentajeUsado, porcentajeTotal)+"");
                Thread.sleep(2*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloRam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private String arreglarComando(String usado,String total){
        Pattern patron = Pattern.compile("[0-9]+");	
        String mensaje [] = usado.split(" ");
        String mensaje2 [] = total.split(" ");
        String usedMemory=null,totalMemory=null;


        for(int i=0; i<mensaje.length;i++) {
                Matcher matcher = patron.matcher(mensaje[i]);
                if(matcher.matches()) {
                        usedMemory=(mensaje[i]);
                        break;
                }
        }
        for(int i=0; i<mensaje2.length;i++) {
                Matcher matcher = patron.matcher(mensaje2[i]);
                if(matcher.matches()) {
                        totalMemory=(mensaje2[i]);
                        break;
                }
        }

        Double resultado= (((Double.parseDouble(usedMemory) / Double.parseDouble(totalMemory))*100));
        String retorno =Double.toString(Math.round(resultado*100d)/100d);
        return retorno+"%"; 
    }
}
