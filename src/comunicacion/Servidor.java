
package comunicacion;


import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

//***** EJECUTAR EN GNU/LINUX ********

public class Servidor {

        public static void main(String[] args) {
            new Servidor();
        }
	public Servidor() {
		
		ServerSocket sServer;
		String comando,comandoSalida="";
		try {
                    sServer = new ServerSocket(2704);
                    Socket sConexion = sServer.accept();
                    System.out.println("Conexion establecida correctamente");
                    DataInputStream fEntrada; //lo que entra
			
                    DataOutputStream fSalida; // lo que sale                
        	
                    ProcessBuilder b;
        	

                    do {

                        // lo que recibe del cliente
                        fEntrada = new DataInputStream(sConexion.getInputStream());
                        comando = fEntrada.readUTF();
                        String identificador = null;
                        if(comando.contains("-.-0")){
                            identificador="0";
                            comando=comando.replace("-.-0","");
                        }
                        if(comando.contains("-.-1")){
                            identificador="1";
                            comando=comando.replace("-.-1","");
                        }
                        if(comando.contains("-.-2")){
                            identificador="2";
                            comando=comando.replace("-.-2","");
                        }
                        if(comando.contains("-.-3")){
                            identificador="3";
                            comando=comando.replace("-.-3","");
                        }
                        //comando a ejecutar
                        b=new ProcessBuilder().command(comando.split(" "));
                        Process p = b.start();
                        BufferedReader comandoProcesado= new BufferedReader(new InputStreamReader(p.getInputStream()));

                        //lo que le envia al cliente
                        fSalida = new DataOutputStream(sConexion.getOutputStream());
                        if(identificador=="0"){
                            System.out.println("Resultado del comando "+comando+" fue enviado");
                        }
                        if(identificador=="1"){
                            System.out.println("El consumo de ram fue enviado ");
                        }
                        if(identificador=="2"){
                            System.out.println("El consumo del disco fue enviado");
                        }
                        if(identificador=="3"){
                            System.out.println("El cosumo del procesador fue enviado");
                        }
                        
                        //comandoSalida=entEstandar.readLine();
                        //fSalida.writeUTF(mensajeOut);
                        String salida;
                        comandoSalida="";
                        
                        while((salida = comandoProcesado.readLine()) != null) {
                            comandoSalida+=salida+"\n";
			}
                        fSalida.writeUTF(comandoSalida);


                    } while (true/*!mensajeIn.equals("exit")*/);

                } catch (Exception e) {

                }
		
		
	}
	public String mensaje(String comando,String comando2) {
		Pattern patron = Pattern.compile("[0-9]+");
		
		String mensaje [] = comando.split(" ");
		String mensaje2 [] = comando2.split(" ");
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