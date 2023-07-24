package thucHanh;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int serverPost = 8080;
        try {
            ServerSocket serverSocket = new ServerSocket(serverPost);
            System.out.println("Máy chủ đang chạy và chờ kết nối...");

            Socket socket = serverSocket.accept();
            System.out.println("khách hàng kết nối.");

            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String message = new String(buffer, 0, bytesRead);
            System.out.println("Nhận được tin nhắn từ khách hàng : " + message);

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

