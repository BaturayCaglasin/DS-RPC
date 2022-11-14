import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws Exception {

        //Admin port. Local port should be equal to port that has been used on client!
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is ready on: " + serverSocket);
        Socket sock = serverSocket.accept();
        //Scanner methods:
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        OutputStream ostream = sock.getOutputStream();
        //Printer methods:
        PrintWriter pwrite = new PrintWriter(ostream, true);
        InputStream istream = sock.getInputStream();
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

        //server codes
        String operation;
        int a;
        int b;
        int c;

        while (true) {
            operation = receiveRead.readLine();
            if (operation != null) {
                System.out.println("Operation : " + operation);
            }
            a = Integer.parseInt(receiveRead.readLine());
            System.out.println("First parameter : " + a);
            b = Integer.parseInt(receiveRead.readLine());
            if (operation.contains("add")) {
                c = a + b;
                System.out.println("Second parameter : " + b);
                System.out.println("Addition = " + c);
                pwrite.println("Addition = " + c);
            }
            if (operation.contains("sub")) {
                c = a - b;
                System.out.println("Second parameter : " + b);
                System.out.println("Substraction = " + c);
                pwrite.println("Substraction = " + c);
            }
            if (operation.contains("multiply")) {
                c = a * b;
                System.out.println("Second parameter : " + b);
                System.out.println("Multiplication = " + c);
                pwrite.println("Multiplication = " + c);
            }
            if (operation.contains("division")) {
                c = a / b;
                System.out.println("Second parameter : " + b);
                System.out.println("Division = " + c);
                pwrite.println("Division = " + c);
            }
            System.out.flush();
        }
    }

}
