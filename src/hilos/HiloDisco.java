package hilos;

import comunicacion.Cliente;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class HiloDisco extends Thread {
    javax.swing.JLabel porcentajedisco;
    javax.swing.JPanel graficoDisco;
    Cliente c;
    int contador=0;
    public HiloDisco(javax.swing.JLabel porcentajedisco, Cliente c,javax.swing.JPanel graficoDisco){
        this.porcentajedisco=porcentajedisco;
        this.c=c;
        this.graficoDisco=graficoDisco;
    }
    
    public void run(){
        while(true){
            try {
                Thread.sleep((long) (0.3*1000));
                String porcentaje=c.comando("df --output=pcent /dev/sda2","-.-2");
                porcentaje=porcentaje.replace("Uso%","");
                porcentajedisco.setText(porcentaje);
                pintar(porcentaje);
                Thread.sleep(1*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloRam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void pintar(String porcentaje){
        String discoUsado=porcentaje.replace("%","");
        
        DefaultPieDataset datos = new DefaultPieDataset();
        datos.setValue("Usado",Double.parseDouble(discoUsado));
        datos.setValue("Disponible", 100.00-Double.parseDouble(discoUsado));

        JFreeChart grafico_circular = ChartFactory.createPieChart(
        "Disco usado",
         datos,
         true,
         true,
         false
        );
        ChartPanel panel = new ChartPanel(grafico_circular);

        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(303,269));
        this.graficoDisco.setLayout(new BorderLayout());
        panel.repaint();
        this.graficoDisco.add(panel,BorderLayout.NORTH);              

        
    }
}
