package Bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        String serverIP = "127.0.0.1";
        int serverPost = 8080;
        Scanner scanner = new Scanner(System.in);
        try {

            System.out.println("Khách hàng đang kết nối...");
            Socket socket = new Socket(serverIP, serverPost);
            System.out.println("Máy khách đã kết nối");
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("Nhập số thứ nhất: ");
            outputStream.writeDouble(scanner.nextDouble());
            outputStream.flush();

            System.out.println("Nhập số thứ 2: ");
            outputStream.writeDouble(scanner.nextDouble());
            outputStream.flush();

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            double sum = inputStream.readDouble();
            System.out.println("Tổng : " + sum);

            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
