package nets_graphic_practice.com.practice.view;

import nets_graphic_practice.com.practice.model.GameMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Bogdan on 11.07.2016.
 */
public class GameView extends JPanel implements KeyListener{


    private int dx;
    private int dy;
    private int x;
    private int y;

    private Image iconPlayer1;
    private Image iconPlayer2;
    private Image iconBomb;
    private GameMap gameMap;
    private Timer timer;
    private MapView mapView;

    public GameView(GameMap gameMap) {
        this.gameMap = gameMap;

    }

    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE){
            gameMap.setBomb(gameMap.getPlayers().get(0));
        }
         if(!(gameMap.move(key,gameMap.getPlayers().get(0))))
            return;
        repaint();

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }


}


