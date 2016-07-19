package nets_graphic_practice.com.practice.view;

import nets_graphic_practice.com.practice.model.Client;
import nets_graphic_practice.com.practice.model.Server;

/**
 * Created by User on 19.07.2016.
 */
public class UDP {
    public static void main(String[] args) {
        Server serverGame = new Server();
        Client clientGame = new Client();
        Thread t1 = new Thread(serverGame);
        Thread t2 = new Thread(clientGame);
        t1.start();
        t2.start();

    }
}
