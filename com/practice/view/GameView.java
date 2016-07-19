package nets_graphic_practice.com.practice.view;

import nets_graphic_practice.com.practice.model.GameMap;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Bogdan on 11.07.2016.
 */
public class GameView extends JPanel implements KeyListener{

    private GameMap gameMap;
    private MapView mapView;
    public GameView(GameMap gameMap,MapView mapView) {
        this.gameMap = gameMap;
        this.mapView =mapView;
    }
    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        gameMap.move(key,gameMap.getPlayers().get(0),mapView);
        if(key==KeyEvent.VK_SPACE)
            gameMap.setBomb(gameMap.getPlayers().get(0),mapView);
        /*if (key == KeyEvent.VK_SPACE){
            gameMap.setBomb(gameMap.getPlayers().get(0));
            repaint();
        }
        if(!(gameMap.move(key,gameMap.getPlayers().get(0))))
            return;

        repaint();*/


    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }


}

