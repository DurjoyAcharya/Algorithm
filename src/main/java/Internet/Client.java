package Internet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public Socket socket=null;
    public DataInputStream input=null;
    public DataOutputStream output=null;
    public Client(String address,int port) throws IOException {
        socket=new Socket(address,port);
        System.out.println("Connected");
        input=new DataInputStream(System.in);
        output=new DataOutputStream(socket.getOutputStream());
        //read data from end user
        String line="";
        while(!line.equals("Over"))
        {
            line=input.readLine();
            output.writeUTF(line);
        }
        input.close();
        output.close();
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        Client client=new Client("10.200.20.1",4040);
    }


}
