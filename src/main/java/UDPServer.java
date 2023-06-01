import java.util.*;
import java.net.*;


public class UDPServer {
    public static void main(String[] args) {

        int serverPort = 8855;
        byte[] buffer = new byte[1024]; // 1 kb **

        Map<String, String> clientMessages = new HashMap<>(); // to store last received messages from clients

        try {

            DatagramSocket serverSocket = new DatagramSocket(serverPort); // UDP socket with the port 8855
            System.out.println("Server started. Listening on port " + serverPort);

            while (true) {

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length); // packet of data with the size of 1 kb
                serverSocket.receive(packet); // socket will receive the packet with the client address

                InetAddress clientAddress = packet.getAddress();
                // int clientPort = packet.getPort();
                String message = new String(packet.getData(), 0, packet.getLength()); // get client address + message

                clientMessages.put(clientAddress.getHostAddress(), message);// stores the client message and updates the timestamp

                System.out.println("Received message from " + clientAddress.getHostAddress() + ": " + message); // prints out the host address and message

            }
        }
        catch (Exception ex) {
            System.out.println("Error in server: " + ex.getMessage());;
        }
    }
}
