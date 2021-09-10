package graficos;

import hilos.HiloProcesador;
import java.awt.BorderLayout;
import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class GraficoProcesador extends Thread{
    javax.swing.JPanel graficoProcesador;
    HiloProcesador procesador;
    
    public GraficoProcesador(javax.swing.JPanel graficoProcesador, HiloProcesador procesador){
        this.graficoProcesador=graficoProcesador;
        this.procesador=procesador;
        try {
            Thread.sleep(1);
        } catch (Exception e) {
        }
    }
    public void run(){
        while(true){
            try {
                String procesadorUsado=procesador.getProcesador().replace("%","");
                procesadorUsado=procesadorUsado.replace(" ","");
                DefaultPieDataset datos = new DefaultPieDataset();
                datos.setValue("Usado",Double.parseDouble(procesadorUsado));
                datos.setValue("Disponible", 100.00-Double.parseDouble(procesadorUsado));
                JFreeChart grafico_circular = ChartFactory.createPieChart(
                "Procesador usado",
                 datos,
                 true,
                 true,
                 false
                );
                ChartPanel panel = new ChartPanel(grafico_circular);
                panel.setMouseWheelEnabled(true);
                panel.setPreferredSize(new Dimension(350, 185));
                this.graficoProcesador.setLayout(new BorderLayout());
                this.graficoProcesador.add(panel,BorderLayout.NORTH);  
                panel.repaint();
                Thread.sleep(4*1000);
            } catch (Exception e) {
            }
        }
    }
    
}