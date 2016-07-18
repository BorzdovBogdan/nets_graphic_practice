package nets_graphic_practice.com.practice.model;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by User on 18.07.2016.
 */
public class ServerGame implements Runnable {
    private DatagramSocket serverSocket;
    private DatagramPacket datagramPacket;
    private InetAddress IPAdress;
    private byte[] receivedPacket;
    private byte[] sendPacket;
    private GameMap gm;
    private int port;
    public ServerGame(GameMap gm){
        this.gm = gm;
        receivedPacket = new byte[50];
        sendPacket = new byte[50];
        try{
            serverSocket = new DatagramSocket(8080);
            datagramPacket = new DatagramPacket(receivedPacket, receivedPacket.length);
            IPAdress = datagramPacket.getAddress();
            port = datagramPacket.getPort();
            parsePackets();
        }catch (SocketException e){
            System.out.println(e.getMessage());
        }

    }
    private void parsePackets(){
        try{
            switch (receivedPacket[0]){
                case 0:{
                    if(!gm.canJoin()){
                        sendPacket[0] = '0';
                        datagramPacket = new DatagramPacket(sendPacket,sendPacket.length,port);
                        serverSocket.send(datagramPacket);
                    }
                    break;
                }
            }
            for (int i = 0; i < receivedPacket.length; i++) {

            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
    @Override
    public void run() {
        try{
            serverSocket.receive(datagramPacket);

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
