package Bai2;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Pattern;

public class ServerCheckIP {
    public static void main(String[] args) throws IOException {
        int serverPost = 8080;

        ServerSocket server = new ServerSocket(serverPost);
        Socket socket = server.accept();

        String IP = takeData(socket);
        String regex0_255 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";

        if (Pattern.matches(regex0_255 + "\\." + regex0_255, IP)) {
            System.out.println("IP này đúng! ");
        } else {
            System.out.println("Ip này sai...");
        }

    }

    private static String takeData(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readByte = inputStream.read(bytes);
        String IP = new String(bytes, 0 , readByte);
        return IP;
    }

}
