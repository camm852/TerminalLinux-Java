package hilos;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Ram extends Thread{
    public Ram(){
        
    }
    public void run(){
        ServerSocket sServer;

        String comando,comandoSalida="";


        try {
            sServer = new ServerSocket(2707);

            Socket sConexion = sServer.accept();
            System.out.println("Conexion establecida correctamente ram");

            DataInputStream fEntrada; //lo que entra
            DataOutputStream fSalida; // lo que sale      


            ProcessBuilder b = null;

            do {

                // lo que recibe del cliente
                fEntrada = new DataInputStream(sConexion.getInputStream());

                comando = fEntrada.readUTF();


                String identificador = null;

               
                identificador="0";
                comando=comando.replace("-.-1","");
                
           
                b=new ProcessBuilder().command(comando.split(" "));


                Process p = b.start();

                BufferedReader comandoProcesado= new BufferedReader(new InputStreamReader(p.getInputStream()));

                //lo que le envia al cliente
                fSalida = new DataOutputStream(sConexion.getOutputStream());


                
                System.out.println("El consumo de ram fue enviado ");
           
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
}
