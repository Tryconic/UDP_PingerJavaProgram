import java.net.*;
import java.io.*;

public class CBoothUDPClient {
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 9999;
        String[] sentences = {
            "I'm deeply passionate about computer networking because it's the foundation of our interconnected world, enabling seamless communication, data sharing, and the backbone of the digital age.",
            "The intricacies of routing, protocols, and network security fascinate me, and I find immense joy in troubleshooting and optimizing network performance to ensure a smooth online experience for users.",
            "Studying computer networking isn't just a subject for me; it's a lifelong journey filled with endless fascination, innovation, and the thrill of mastering the technology that keeps our modern world connected."
        };

        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName(serverName);

            for (String sentence : sentences) {
                byte[] sendData = sentence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

                // Start timer
                long startTime = System.nanoTime();
                clientSocket.send(sendPacket);

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                try {
                    clientSocket.setSoTimeout(1000);
                    clientSocket.receive(receivePacket);
                    long endTime = System.nanoTime();

                    String receivedSentence = new String(receivePacket.getData(), 0, receivePacket.getLength());

                    if (receivedSentence.equals(sentence)) {
                        // Calculate RTT in milliseconds
                        double rtt = (endTime - startTime) / 1_000_000.0;
                        System.out.printf("RTT for sentence: %.2f ms%n", rtt);

                        // Calculate throughput in Mbps
                        double throughput = (sentence.length() * 8.0) / (rtt / 2) / 1_000_000.0;
                        System.out.printf("Throughput: %.1f Mbps%n", throughput);
                    } else {
                        System.out.println("Error: Received sentence does not match sent sentence.");
                    }
                } catch (SocketTimeoutException e) {
                    System.out.println("Packet lost.");
                }
            }
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
