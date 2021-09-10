package graficos;

import hilos.HiloRam;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class GraficoRam extends Thread{
  
    javax.swing.JPanel graficoMemoria;
    HiloRam ram;

    public GraficoRam(javax.swing.JPanel graficoMemoria, HiloRam ram){
        this.ram=ram;
        this.graficoMemoria=graficoMemoria;
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(GraficoRam.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void run(){
        while(true){
            try {
                String ramUsada=ram.getMemoria().replace("%","");
                ramUsada=ramUsada.replace(" ","");
                DefaultPieDataset datos = new DefaultPieDataset();
                datos.setValue("Usado",Double.parseDouble(ramUsada));
                datos.setValue("Disponible", 100.00-Double.parseDouble(ramUsada));
                JFreeChart grafico_circular = ChartFactory.createPieChart(
                "Memoria usada",
                 datos,
                 true,
                 true,
                 false
                );
                ChartPanel panel = new ChartPanel(grafico_circular);
                panel.setMouseWheelEnabled(true);
                panel.setPreferredSize(new Dimension(350, 185));
                this.graficoMemoria.setLayout(new BorderLayout());
                this.graficoMemoria.add(panel,BorderLayout.NORTH);  
                panel.repaint();
                Thread.sleep(4*1000);
            } catch (Exception e) {
            }
        }
    }
    
}
