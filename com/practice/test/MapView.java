package nets_graphic_practice.com.practice.test;

import nets_graphic_practice.com.practice.model.GameMap;
import nets_graphic_practice.com.practice.model.Player;
import nets_graphic_practice.com.practice.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class MapView extends JPanel implements ActionListener{
    private static final long serialVersionUID = 1L;

    private Timer timer;
    private Player player1;
    private GameView gameView;
    private GameMap gameMap;
    public MapView(GameMap gm){
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        gameMap = gm;
        gameView = new GameView(gameMap);
        add(gameView);
        timer = new Timer(5, this);
        timer.start();

    }
    public void paint(Graphics g) {
        super.paint(g);
        for(int i = 0; i < gameMap.getPlayers().size();i++){
            Graphics2D g1d = (Graphics2D)g;
            g1d.drawImage(gameMap.getPlayers().get(i).getImage(), gameMap.getPlayers().get(i).getX(), gameMap.getPlayers().get(i).getY(), this);
            Toolkit.getDefaultToolkit().sync();
            g.dispose();
        }
    }
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {

            gameView.keyPressed(e);
        }

    }

}