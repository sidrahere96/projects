import java.io.*;
import java.net.*;

public class chat_server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server running on port 5000...");

        Socket socket = server.accept();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        String msg;
        while ((msg = in.readLine()) != null) {
            System.out.println("Client: " + msg);
        }
    }
}