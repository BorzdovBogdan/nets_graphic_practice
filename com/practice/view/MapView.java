package nets_graphic_practice.com.practice.view;

import nets_graphic_practice.com.practice.model.GameMap;
import nets_graphic_practice.com.practice.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class MapView extends JPanel implements ActionListener{

    private Timer timer;
    private Player player1;
    private GameView gameView;
    private GameMap gameMap;
    private ArrayList<Image> images;
    private int step;
    public MapView(GameMap gm){
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        gameMap = gm;
        gameView = new GameView(gameMap);
        step = GameWindow.blockCount/2;
        images = new ArrayList<>(4);
        images.add(loadImage("background.png"));
        images.add(loadImage("block.png"));
        images.add(loadImage("wall.png"));
        images.add(loadImage("bomb1.png"));
        timer = new Timer(5, this);
        timer.start();
    }
    public Image loadImage(String imageName){
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("images/"+imageName));
        return imageIcon.getImage();
    }

    public void paint(Graphics g) {
        super.paint(g);
        int stepY = gameMap.getPlayers().get(0).getStepY();
        int stepX = gameMap.getPlayers().get(0).getStepX();
        int x = gameMap.getPlayers().get(0).getX();
        int y = gameMap.getPlayers().get(0).getY();
        for (int i = y-step; i < y+step; i++) {
            for (int j = x-step; j < x+step; j++) {
                switch (gameMap.getMap()[i][j]) {
                    case 'B': {
                        g.drawImage(images.get(1), (j-stepX )*GameWindow.step, (i-stepY)*GameWindow.step, this);
                        break;
                    }
                    case '0': {
                        g.drawImage(images.get(0), (j-stepX)*GameWindow.step, (i-stepY)*GameWindow.step, this);
                        break;
                    }
                    case '1': {
                        g.drawImage(images.get(2), (j-stepX)*GameWindow.step, (i-stepY)*GameWindow.step, this);
                        break;
                    }
                }
            }
            //g.drawImage(images.get(1), gameMap.getMap()[i].length*GameWindow.step, i*GameWindow.step, this);
        }

        /*for (int i = GameWindow.step; i <gameMap.getMap()[0].length ; i+=32) {
            g.drawImage(images.get(1), i, gameMap.getMap().length, this);
        }*/


        for (int i = 0; i < gameMap.getPlayers().size(); i++) {
            int xP = gameMap.getPlayers().get(i).getX();
            int yP = gameMap.getPlayers().get(i).getY();
            g.drawImage(gameMap.getPlayers().get(i).getImage(), (xP-stepX)*GameWindow.step, (yP-stepY)*GameWindow.step, this);
        }

        for(int i =0; i < gameMap.getBombs().size();i++){
            g.drawImage(images.get(3),(gameMap.getBombs().get(i).getX()-stepX)*GameWindow.step,(gameMap.getBombs().get(i).getY()-stepY)*GameWindow.step,this);
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
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