package Bai3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        int serverPost = 8888;
        boolean status = true;
        while (status) {
            ServerSocket serverSocket = new ServerSocket(serverPost);
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int byteRead = inputStream.read(buffer);
            String messages = new String(buffer, 0, byteRead);
            System.out.println("Client : " + messages);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhap tin nhan: ");
            String message = scanner.nextLine();
            if (message == null) {
                status = false;
            } else {
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(message.getBytes());
                serverSocket.close();
                socket.close();
            }
        }
    }
}
