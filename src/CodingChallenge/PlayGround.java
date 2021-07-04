package CodingChallenge;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class PlayGround {
    public static void main(String[] args) throws IOException {
//        var serverSocket=new ServerSocket(4040);
//        System.out.println("Started Server At Port: "+4040);
//        while (true)
//        {
//            var socket=serverSocket.accept();
//            var thread=new Thread(()->{
//                handleClinet(socket);
//
//            });
//            thread.start();
//        }
        DataInputStream in=new DataInputStream(System.in);
        var s= in.readUTF();
        if (in.equals("x"))
            in.close();

        System.out.println(s);
    }
    private static void handleClinet(Socket socket)
    {
        try {
            socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
