package thucHanh;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkingUseInetAddress {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.example.com");

            String ipAddress = address.getHostAddress();
            System.out.println(" IP address " + ipAddress);

            String hostName = address.getHostName();
            System.out.println("Host Name " + hostName);

            boolean reachable = address.isReachable(500);
            System.out.println(" reachable :  " + reachable);
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}
