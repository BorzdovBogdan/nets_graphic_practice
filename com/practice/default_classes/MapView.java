package nets_graphic_practice.com.practice.default_classes;

import nets_graphic_practice.com.practice.model.GameMap;

import javax.swing.*;

/**
 * Created by Bogdan on 11.07.2016.
 */
public class MapView extends JPanel  {
    private GameMap gameMap;
    public MapView(GameMap gm){
        gameMap = gm;
    }

    public void newEvent(MapEvent m) {

    }
}
