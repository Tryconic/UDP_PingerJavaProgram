import java.io.*;
import java.net.*;
import java.util.Arrays;

public class CBoothUPDServer {  
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(9999);
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            System.out.println("Waiting for client on port 9999...");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                InetAddress clientIPAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                String receivedSentence = new String(receivePacket.getData(), 0, receivePacket.getLength());

                System.out.println("RECEIVED: " + receivedSentence);

                // Echo back the received message (pong)
                sendData = receivedSentence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIPAddress, clientPort);
                serverSocket.send(sendPacket);

                // Clear arrays for the next packet
                Arrays.fill(receiveData, (byte) 0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}