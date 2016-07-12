package nets_graphic_practice.com.practice.test;

import nets_graphic_practice.com.practice.model.GameMap;
import nets_graphic_practice.com.practice.model.Player;
import nets_graphic_practice.com.practice.test2.nets_graphic_practice.Player1;
import nets_graphic_practice.com.practice.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < gameMap.getPlayers().size();i++){
            int x = gameMap.getPlayers().get(i).getX();
            int y = gameMap.getPlayers().get(i).getY();
            g.drawImage(gameMap.getPlayers().get(i).getImage(), x, y, this);
            Toolkit.getDefaultToolkit().sync();
            g.dispose();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        if(!(gameMap.move(key,gameMap.getPlayers().get(0))))
            return;

        if (key == KeyEvent.VK_SPACE){
            gameMap.setBomb(gameMap.getPlayers().get(0));
        }
        repaint();

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }


}

