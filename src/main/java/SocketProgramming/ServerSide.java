package SocketProgramming;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var serversocket = new ServerSocket(8992);
        System.out.println("Server Started.....");

        while(true) {
            var socket = serversocket.accept();
            System.out.println("Client Connected...");

            var ois = new ObjectInputStream(socket.getInputStream());
            var ous = new ObjectOutputStream(socket.getOutputStream());


            var Cmsg = ois.readObject();
            System.out.println("From Client: " +(String) Cmsg);

            var Smsg = Cmsg.toString().toUpperCase();
            ous.writeObject(Smsg);
        }

    }
}
