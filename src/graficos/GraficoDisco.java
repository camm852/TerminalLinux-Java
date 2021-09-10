package graficos;

import hilos.HiloDisco;
import java.awt.BorderLayout;
import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class GraficoDisco extends Thread{
    javax.swing.JPanel graficoDisco;
    HiloDisco disco;
    
    public GraficoDisco(javax.swing.JPanel graficoDisco, HiloDisco disco){
        this.graficoDisco=graficoDisco;
        this.disco=disco;
        try {
            Thread.sleep(1);
        } catch (Exception e) {
        }
    }
    public void run(){
        while(true){
            try {
                String discoUsado=disco.getDisco().replace("%","");
                discoUsado=discoUsado.replace(" ","");
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
                panel.setPreferredSize(new Dimension(350, 185));
                this.graficoDisco.setLayout(new BorderLayout());
                this.graficoDisco.add(panel,BorderLayout.NORTH);  
                panel.repaint();
                Thread.sleep(4*1000);
            } catch (Exception e) {
            }
        }
    }
    
}
