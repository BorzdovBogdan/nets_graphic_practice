package nets_graphic_practice.com.practice;

import nets_graphic_practice.com.practice.model.GameMap;
import nets_graphic_practice.com.practice.model.GameMapReader;
import nets_graphic_practice.com.practice.view.GameWindow;
<<<<<<< HEAD
public class Main {
        public static void main(String[] args) {
                GameMapReader gmr = new GameMapReader(32,3);
                GameMap gameMap = new GameMap(gmr);
                GameWindow gw = new GameWindow(gameMap);
        }
}
=======

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        GameMapReader gmr = new GameMapReader(32,3);
        GameMap gameMap = new GameMap(gmr);
        GameWindow gw = new GameWindow(gameMap);
    }
}
>>>>>>> d5dd83c0bf0b1d4b46738808090c70a908272f0e
