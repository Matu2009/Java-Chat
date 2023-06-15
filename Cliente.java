package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    

    public static void main(String[] agrs) {
        


        final String host = "192.168.0.114";
        final int port = 5000;
        DataInputStream in;
        DataOutputStream out;

        try {
            Socket sc = new Socket(host, port);

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            Scanner ch = new Scanner(System.in);
            String chat = ch.nextLine();
            out.writeUTF(chat);

            String message = in.readUTF();

            System.out.println(message);

            
            sc.close();
            



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
