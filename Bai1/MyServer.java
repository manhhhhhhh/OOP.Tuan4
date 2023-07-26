package Bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
    public static void main(String[] args) {
        int serverPost = 8080;

        try {
            ServerSocket server = new ServerSocket(serverPost);
            System.out.println("Máy chủ đang được kết nối....");
            Socket socket = server.accept();
            System.out.println("Máy chủ được kết nối.");
// nhan data tu client

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            double a = inputStream.readDouble();
            double b = inputStream.readDouble();
            System.out.println("số thứ nhất " + a);
            System.out.println("số thứ hai " + b);
            double sum = a + b;


// truyen ket qua sang client
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeDouble(sum);
            outputStream.flush();

            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}










//nếu ko chạy method flush thì nó sẽ ko đẩy bất cứ dữ liệu về server , nhưng sau khi chạy method flush thì nó mới đẩy về
