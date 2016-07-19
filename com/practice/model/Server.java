package nets_graphic_practice.com.practice.model;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by User on 19.07.2016.
 */
public class Server implements Runnable{
    private DatagramSocket serverSocket;
    private DatagramPacket receivePacket;
    private byte[] receiveData;
    public Server(){
        receiveData = new byte[50];
        receivePacket = new DatagramPacket(receiveData, receiveData.length);
    }
    public void startServer(int port)throws Exception{
        serverSocket = new DatagramSocket(port);
    }
    public boolean isReceived()throws Exception{
        serverSocket.receive(receivePacket);
        if(receiveData!=null){
            System.out.println(new String(receiveData));

            return true;
        }
        return false;
    }
    @Override
    public void run(){
        try{
            startServer(8080);
            while (true) {
                if (!isReceived())
                    System.out.println("Empty");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
