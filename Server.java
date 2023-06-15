package server;

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{


    public static void main(String[] agrs) {
        

        final int port = 5000;
        ServerSocket server;
        Socket sc;
        DataInputStream in;
        DataOutputStream out;

        try {
            server = new ServerSocket(port);
            System.out.println("Server initialitiated successfully");

            while(true){

                sc = server.accept();

                System.out.println("Conection recived from: " + sc.getInetAddress().getHostAddress());
                System.out.println("");
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                String message = in.readUTF();

                System.out.println(message);
                
                out.writeUTF("Message sent successfully");

                sc.close();
                System.out.println("Cliente desconectado");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}