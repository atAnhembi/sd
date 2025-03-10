package cliente;

import java.io.PrintStream;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        final String HOST = "localhost"; // 127.0.0.1
        final int PORT = 9999;
        Socket socket;

        // cria o socket e solicita a conexão
        try {
            System.out.println("Procurando o servidor...");
            socket = new Socket(HOST, PORT);
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println("Erro de conexão");
            System.out.println(e.getMessage());
            return;
        }
        // faz a comunicação
        try {
            PrintStream out = new PrintStream(socket.getOutputStream());
            out.println("Boa noite servidor!");
            out.close();
        } catch (Exception e) {
            System.out.println("Erro na comunicação");
        }
        // encerra a conexão
        try {
            socket.close();
            System.out.println("Conexão encerrada.");
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
