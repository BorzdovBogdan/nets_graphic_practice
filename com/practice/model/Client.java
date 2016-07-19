package nets_graphic_practice.com.practice.model;

import sun.security.x509.IPAddressName;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by User on 19.07.2016.
 */
public class Client implements Runnable {
    private DatagramSocket clientSocket;
    private DatagramPacket sendPacket;
    private byte[] sendData;
    private byte[] receivedData;
    private InetAddress IPAddress;
    public Client(){
        sendData = new byte[50];
        String str = "Hello, server!";
        sendData = str.getBytes();
        receivedData = new byte[50];

        try{
            clientSocket = new DatagramSocket();
            IPAddress = InetAddress.getByName("localhost");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void startClient(int port){
        try{
            while (true) {
                sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                clientSocket.send(sendPacket);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void run(){
        startClient(8080);
    }
}
