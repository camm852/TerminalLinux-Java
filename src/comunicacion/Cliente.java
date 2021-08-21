package comunicacion;

import java.io.*;
import javax.swing.*;
import java.net.*;
import java.util.Scanner;

//********** EJECUTAR EN WINDOWS **********

public class Cliente {
    
    private String ip;
    private int puerto;
    
    Socket socket;
    
    public Cliente(String ip,int puerto) {
    	
    	this.ip=ip;
        this.puerto=puerto;
    	
    	/*try {

			
			
        	do {
        		
        		// lo que le envia al servidor
        		Process p = b.start();
    			BufferedReader entEstandar = new BufferedReader(new InputStreamReader(p.getInputStream()));
    			mensajeOut=null;
        		fSalida = new DataOutputStream(socket.getOutputStream());
        		while((salida = entEstandar.readLine()) != null) {
        			if(salida.contains("so")) {
        				continue;
        			}
        			else mensajeOut=salida;
    			}
        		mensajeOut=mensajeOut.replace(" ","");
        		fSalida.writeUTF(mensajeOut);
        		
        		// lo que recibe del servidor
        		fEntrada = new DataInputStream(socket.getInputStream());
				mensajeIn = fEntrada.readUTF();
				System.out.println("Cliente: El servidor dice que su consumo de memoria es: "+ mensajeIn);
				Thread.sleep(1*1000);
            	
			} while (!mensajeOut.equals("exit"));
        	
        	
		} catch (Exception e) {
			
		}*/
    	
    	
    }
    public boolean conectar(){
    	InetAddress IP;
    	
        try {
            String ip=null;
            IP = InetAddress.getByName(this.ip);
            socket = new Socket(IP,this.puerto); 
            return true;
        
        }catch(Exception e){
            return false;
        }
    }
    public String comando(String comando,String idenfificador){
        DataOutputStream fSalida; //lo que envia
        DataInputStream fEntrada; // lo que recibe 
        try{
            //lo que envia al servidor

            fSalida = new DataOutputStream(socket.getOutputStream());
            fSalida.writeUTF(comando+idenfificador);
            //lo que trae del servidor
            fEntrada = new DataInputStream(socket.getInputStream());
            String comandoEntrada = fEntrada.readUTF();
            return comandoEntrada;
        }catch(Exception e){
            return "No se realizo ningun";
        }
    }
    
}