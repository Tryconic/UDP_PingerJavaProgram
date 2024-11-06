# UDP Pinger Program

## Overview
This Java-based UDP Pinger program simulates the functionality of the standard ping program found in modern operating systems but uses UDP instead of ICMP. The client sends ping messages to a server, receives pong responses, and calculates the Round Trip Time (RTT). The program handles potential packet loss by setting a timeout period of one second, after which it considers the packet lost.

## Features
- **Client-Server Architecture**: Both client and server run on `localhost` with the server on port `9999`.
- **RTT Measurement**: Calculates and displays the RTT for each ping message.
- **Throughput Calculation**: Computes throughput in Mbps using the formula `throughput = (bits / (RTT / 2))`, converted to Mbps.
- **Timeout Handling**: If no response is received within one second, the client reports a packet loss.
- **Multiple Sentences**: The client sends three different pre-defined sentences to the server for testing.

## Requirements
- Java Development Kit (JDK)
- Basic knowledge of running Java programs

## Program Details
### Sentences to Be Sent
1. `"I'm deeply passionate about computer networking because it's the foundation of our interconnected world, enabling seamless communication, data sharing, and the backbone of the digital age."`
2. `"The intricacies of routing, protocols, and network security fascinate me, and I find immense joy in troubleshooting and optimizing network performance to ensure a smooth online experience for users."`
3. `"Studying computer networking isn't just a subject for me; it's a lifelong journey filled with endless fascination, innovation, and the thrill of mastering the technology that keeps our modern world connected."`

### Client Behavior
1. Sends a ping message to the server and starts a timer.
2. Waits for a pong message from the server.
3. If a pong is received:
   - Stops the timer.
   - Verifies that the received message matches the sent message.
   - Prints the RTT (in ms) and the length of the message in bits.
   - Calculates and prints the throughput (in Mbps).
4. If no pong is received within one second, prints "Packet lost."

### Server Behavior
1. Listens for incoming packets on port `9999`.
2. Receives and prints the ping message.
3. Sends an echo (pong) of the received message back to the client.

## Sample Output Format (PDF)
Create a PDF report similar to the format shown below:

| **Server Location** | **RTT for First Sentence**  | **Throughput for First Sentence**  | **RTT for Second Sentence** | **Throughput for Second Sentence**  | **RTT for Third Sentence**  | **Throughput for Third Sentence**  |
|---------------------|-----------------------------|------------------------------------|-----------------------------|-------------------------------------|-----------------------------|------------------------------------|
| `localhost`         | `0.74 ms`                   | `4.1 Mbps`                         | `0.66 ms`                   | `4.8 Mbps`                          | `0.75 ms`                   | `4.4 Mbps`                         |

## Files
- **CBoothUDPClient.java**: Contains the client-side code.
- **CBoothUDPServer.java**: Contains the server-side code.
- **Cbooth.pdf**: The output report with RTT and throughput measurements.

## Usage
1. Compile both Java files:
   ```bash
   javac CBoothUDPClient.java CBoothUDPServer.java
   ```
2. Run the Server:
   ```bash
   java CBoothUDPServer
   ```
3. Run the client in a new Terminal Window
   ```bash
   java CBoothUDPClient
   ```

## Notes
- Ensure that both the client and server are running on the same machine (localhost).
- The server will print "Waiting for client on port 9999..." when ready.

## Program Author(s):
Colton Booth [github.com/Tryconic](https://github.com/Tryconic), Email: [127cboot@gmail.com](127cboot@gmail.com)
