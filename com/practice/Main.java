package nets_graphic_practice.com.practice;

import nets_graphic_practice.com.practice.model.GameMap;
import nets_graphic_practice.com.practice.model.GameMapReader;

public class Main {

    public static void main(String[] args) {
        GameMapReader gmr = new GameMapReader();
        GameMap gm = new GameMap(gmr);
    }
}
