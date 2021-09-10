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