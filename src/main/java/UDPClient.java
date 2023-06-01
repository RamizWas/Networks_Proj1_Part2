import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {

        String serverAddress = "192.168.1.255";
        int serverPort = 8855;
        int intervalSeconds = 2;
        String studentName = "Ramiz Wasaya";

        try {

            DatagramSocket clientSocket = new DatagramSocket();
            System.out.println("Client started.");

            while (true) {

                String message = studentName;
                byte[] sentData = message.getBytes();

                DatagramPacket packet = new DatagramPacket(sentData, sentData.length,
                InetAddress.getByName(serverAddress),serverPort);

                clientSocket.send(packet);

                System.out.println("Sent message: " + message);

                Thread.sleep(intervalSeconds * 1000);
            }
        }
        catch (Exception ex) {
            System.out.println("Error in client: ");
        }
    }
}
