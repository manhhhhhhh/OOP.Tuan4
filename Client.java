package thucHanh;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String serverIP = "127.0.0.1";
        int severPost = 8080;

        try {
            Socket socket = new Socket(serverIP, severPost);

            OutputStream outputStream = socket.getOutputStream();
            String message = "Xin chào, máy chủ!";
            outputStream.write(message.getBytes());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
