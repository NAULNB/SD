import java.io.*;
import java.net.*;
import java.util.*;
/**
 * @author lycog
 */
public class MSender {
  public static void main(String[] args) {
    DatagramSocket socket = null;
    DatagramPacket outPacket = null;
    byte[] outBuf;
    final int PORT = 8888;
    Scanner e = new Scanner(System.in);
 
    try {
      socket = new DatagramSocket();
      long counter = 0;
      String msg;
 
      while (true) {

        

        msg = e.nextLine();
        counter++;
        outBuf = msg.getBytes();
 
        //Send to multicast IP address and port
        InetAddress address = InetAddress.getByName("224.2.2.3");
        outPacket = new DatagramPacket(outBuf, outBuf.length, address, PORT);
 
        socket.send(outPacket);
 
        System.out.println("Server sends : " + msg);
        try {
          Thread.sleep(500);
        } catch (InterruptedException ie) {
        }
      }
    } catch (IOException ioe) {
      System.out.println(ioe);
    }
  }
}
