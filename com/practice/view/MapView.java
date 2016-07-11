package nets_graphic_practice.com.practice.view;

import nets_graphic_practice.com.practice.model.GameMap;

import javax.swing.*;

/**
 * Created by Bogdan on 11.07.2016.
 */
public class MapView extends JPanel implements MapListener {
    private GameMap gameMap;
    public MapView(GameMap gm){
        gameMap = gm;
    }
    @Override
    public void newEvent(MapEvent m) {

    }
}
