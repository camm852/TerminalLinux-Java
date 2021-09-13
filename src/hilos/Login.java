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
import login.Entrar;

/**
 *
 * @author root
 */
public class Login extends Thread{
    public void run(){
        ServerSocket sServer;

        try {
            sServer = new ServerSocket(2708);

            Socket sConexion = sServer.accept();
            System.out.println("Conexion establecida correctamente login");

            DataInputStream fEntrada; //lo que entra
            DataOutputStream fSalida; // lo que sale    
            do{
                // lo que recibe del cliente
                fEntrada = new DataInputStream(sConexion.getInputStream());

                String datos = fEntrada.readUTF();
                String [] credenciales = datos.split("-");
                
                System.out.println(credenciales[0] + "-" + credenciales[1]);
                
                Entrar login = new Entrar();
                
                String siEntra="";
                
                if(login.ingresar(credenciales[0], credenciales[1])==true){
                    siEntra="true";
                }else{
                    siEntra="false";
                }

                //lo que le envia al cliente
                fSalida = new DataOutputStream(sConexion.getOutputStream());
                
                System.out.println(siEntra);
                fSalida.writeUTF(siEntra);
                
            }while(true);

        } catch (Exception e) {

        }
    }
}
