/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Minska
 */
public class ClienteThread implements Runnable {
    Socket cliente;
    ServerSocket servidor;
    
    ClienteThread(ServerSocket servidor){
        this.servidor = servidor;
    }
    
    @Override
    public void run() {
        try {
            cliente = servidor.accept();
            Socket_Servidor.textArea.append("\nNova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
            Socket_Servidor.textArea.append("\n************************************************************");
            
            Scanner entrada = new Scanner(cliente.getInputStream());
            
            while (entrada.hasNextLine()) {
                Socket_Servidor.textArea.append("\n"+cliente.getInetAddress().getHostAddress()+": "+ entrada.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Erro na thread cliente: " + e);
        }
    }
}