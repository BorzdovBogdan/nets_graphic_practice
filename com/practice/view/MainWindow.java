package nets_graphic_practice.com.practice.view;

import nets_graphic_practice.com.practice.model.GameMap;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Bogdan on 11.07.2016.
 */
public class MainWindow extends JFrame implements KeyListener {
    private GameMap gameMap;
    private GameView gameView;
    public MainWindow(GameMap gm){
        gameMap = gm;
        gameView = new GameView();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
