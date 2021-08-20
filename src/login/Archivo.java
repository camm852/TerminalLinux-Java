package login;

import java.io.*;

public class Archivo {

	public Archivo() 
	{
		File archi = new File("bdusuarios.txt");
		FileOutputStream fosArchivo;
		
                if(archi.length()==0){
                
                    try {
                            fosArchivo = new FileOutputStream(archi);
                            String credencial = "camm852:305bdf60585d82e592bfb4f18d73960f50989e74243a648bfe90a9d072b6480f";

                            DataOutputStream dosArchivo = new DataOutputStream(fosArchivo);
                            dosArchivo.writeBytes(credencial);

                            dosArchivo.close();
                            fosArchivo.close();

                    } catch (Exception e) {

                    }
                }    
        }  

	
	String[] cargarDatos(){
            File archi = new File("bdusuarios.txt");

            try {
                FileReader frArchivo = new FileReader(archi);
                BufferedReader brArchivo = new BufferedReader(frArchivo);
                String contenido = "";

                contenido = brArchivo.readLine();

                String[] param = contenido.split(":");
                return param;
            } catch (Exception e) {
                return null;
            }
            
	}
}
