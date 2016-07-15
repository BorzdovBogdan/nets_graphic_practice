package nets_graphic_practice.com.practice;

import nets_graphic_practice.com.practice.model.GameMap;
import nets_graphic_practice.com.practice.model.GameMapReader;
import nets_graphic_practice.com.practice.view.GameWindow;
public class Main {
        public static void main(String[] args) {
                GameMapReader gmr = new GameMapReader(32,3);
                GameMap gameMap = new GameMap(gmr);
                GameWindow gw = new GameWindow(gameMap);
        }
}