package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author nevin
 */
public class Server {

    Socket socket;
    Scanner scan;
    String in;

    public Server() throws IOException {
        scan = new Scanner(System.in);
        StartServer();
        scan = new Scanner(System.in);
    }

    private void StartServer() throws IOException {
        ServerSocket listener = new ServerSocket(9090);
        try {
            socket = listener.accept();

            while (true) {
                PrintWriter out
                        = new PrintWriter(socket.getOutputStream(), true);
                System.out.println("Enter a direction");
                in = scan.nextLine();
                out.println(in);
            }
        } finally {
            listener.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();

    }
}
