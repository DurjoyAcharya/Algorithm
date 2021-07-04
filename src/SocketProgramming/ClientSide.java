package SocketProgramming;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientSide {

    public static void main(String[] args) throws IOException {
        System.out.println("Waiting For Server....");
        var socket=new Socket("192.168.43.149",8992);
        System.out.println("Client Connected..");


        var oos=new ObjectOutputStream(socket.getOutputStream());
        var ois=new ObjectInputStream(socket.getInputStream());

        System.out.println("Enter Something ");
        var Sc=new Scanner(System.in);
        String msg= Sc.nextLine();
        oos.writeObject(msg);

        Object fromServer= null;
        try {
            fromServer = ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("From Server: "+fromServer.toString());

    }
}
