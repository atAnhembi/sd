package server;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        final int PORT = 9999;
        ServerSocket serverSocket;
        Socket clientSocket;

        // cria o socket do servidor E faz o bind (pedi a porta)
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (Exception e) {
            System.out.println("Erro de bind. Porta em uso.");
            return;
        }

        // aceita a solicitação de conexão
        try {
            System.out.println("Aguardando o cliente...");
            clientSocket = serverSocket.accept();
            System.out.println("Conectado.");
        } catch (Exception e) {
            System.out.println("Erro na conexão.");
            return;
        }

        // faz a comunicação
        try {
            Scanner input = new Scanner(clientSocket.getInputStream());
            String msg = input.nextLine();
            System.out.println("Recebida: " + msg);
            
            input.close();
        } catch (Exception e) {
            System.out.println("Erro na comunicação");
        }


        // encerra a comunicação
        try {
            serverSocket.close();
            System.out.println("Servidor encerrado");
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}