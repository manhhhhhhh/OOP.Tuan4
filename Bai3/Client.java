package Bai3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String addressIPServer = "127.0.0.1";
        int serverPost = 8888;
        boolean status = true;
    while (status) {
        Socket socket = new Socket(addressIPServer, serverPost);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap tin nhan: ");
        String message = scanner.nextLine();
        if (message == null) {
            status = false;
        } else {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(message.getBytes());

            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int byteRead = inputStream.read(buffer);
            String messages = new String(buffer, 0, byteRead);
            System.out.println("Server : " + messages);

            socket.close();
        }
    }
    }
}
