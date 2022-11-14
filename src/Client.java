import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) throws Exception {
        //Localhost and Admin port will connect to the server:
        Socket serverSocket = new Socket("127.0.0.1", 8080);
        //Scanner methods:
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        OutputStream ostream = serverSocket.getOutputStream();
        //Printer methods:
        PrintWriter pwrite = new PrintWriter(ostream, true);
        InputStream istream = serverSocket.getInputStream();
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

        System.out.println("Client is ready on: " + serverSocket+ "type and press Enter!");

        //client codes
        String receiver;
        String sender;
        String temp;

        while (true) {
            System.out.println("\nEnter an operation to perform. Use: add,sub,multiply,division");
            temp = keyRead.readLine();
            sender = temp.toLowerCase();
            pwrite.println(sender);
            System.out.println("Enter your first parameter :");
            sender = keyRead.readLine();
            pwrite.println(sender);
            System.out.println("Enter your second parameter : ");
            sender = keyRead.readLine();
            pwrite.println(sender);
            System.out.flush();
            if ((receiver = receiveRead.readLine()) != null) {
                System.out.println(receiver);
            }
        }
    }
}
