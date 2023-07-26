package Bai2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class USER {
    public static void main(String[] args) {
        String serverIP = "127.0.0.1";
        int serverPost = 8080;
       Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Khách hàng đang kết nối...");
            Socket socket = new Socket (serverIP, serverPost);
            System.out.println("Máy khách đã kết nối");

            OutputStream output = socket.getOutputStream();
            String message = "Nhập số IP : " + scanner.nextLine();
            output.write(message.getBytes());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
