package nets_graphic_practice.com.practice.default_classes;

import nets_graphic_practice.com.practice.model.GameMap;

import javax.swing.*;

/**
 * Created by Bogdan on 11.07.2016.
 */
public class MainWindow extends JFrame {
    private GameMap gameMap;
    private GameView gameView;
    private MapView mapView;
    public MainWindow(GameMap gm){
        gameMap = gm;
        gameView = new GameView();

    }
}
