package nets_graphic_practice.com.practice.test;

import nets_graphic_practice.com.practice.model.GameMap;
import nets_graphic_practice.com.practice.model.GameMapReader;
import nets_graphic_practice.com.practice.model.Player;

import java.util.ArrayList;

/**
 * Created by Bogdan on 11.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        //players.add(new Player(14,14));
        GameMapReader gmr = new GameMapReader();
        GameMap gameMap = new GameMap(gmr);
        GameWindow gw = new GameWindow(gameMap);
    }
}
