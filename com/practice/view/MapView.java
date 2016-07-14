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
    private static final long serialVersionUID = 1L;

    private Timer timer;
    private Player player1;
    private GameView gameView;
    private GameMap gameMap;
    private ArrayList<Image> images;
    public MapView(GameMap gm){
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        gameMap = gm;
        gameView = new GameView(gameMap);
        add(gameView);
        images = new ArrayList<>(3);
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
    public void paintComponent(Graphics g){
        for (int i = 0; i < gameMap.getPlayers().size(); i++) {
            int x = gameMap.getPlayers().get(i).getX();
            int y = gameMap.getPlayers().get(i).getY();
            g.drawImage(gameMap.getPlayers().get(i).getImage(), x, y, this);
        }
    }
    public void paint(Graphics g) {
        super.paint(g);
        int stepY = gameMap.getPlayers().get(0).getStepY();
        int stepX = gameMap.getPlayers().get(0).getStepX();
        for (int i = GameWindow.step*stepY; i < gameMap.getMap().length-30; i+=32) {
            for (int j = GameWindow.step*stepX; j < gameMap.getMap()[i].length-32; j+=32) {
                switch (gameMap.getMap()[i][j]) {
                    case 'B': {
                        g.drawImage(images.get(1), j - GameWindow.step*stepX, i - GameWindow.step*stepY, this);
                        break;
                    }
                    case ' ': {
                        g.drawImage(images.get(0), j - GameWindow.step*stepX, i - GameWindow.step*stepY, this);
                        break;
                    }

                }

                //g.drawImage(images.get(1), j, i, this);
            }
            g.drawImage(images.get(1), gameMap.getMap()[i].length-32, i, this);
        }

        for (int i = GameWindow.step; i <gameMap.getMap()[0].length ; i+=32) {
            g.drawImage(images.get(1), i, gameMap.getMap().length-32, this);
        }



        for (int i = GameWindow.step*stepY; i < gameMap.getMap().length; i++) {
            for (int j = GameWindow.step*stepX; j < gameMap.getMap()[i].length; j++) {
                if(gameMap.getMap()[i][j]=='1') {
                    g.drawImage(images.get(2), j - GameWindow.step*stepX, i - GameWindow.step*stepY, this);
                }
            }
        }

        for (int i = 0; i < gameMap.getPlayers().size(); i++) {
            int x = gameMap.getPlayers().get(i).getX();
            int y = gameMap.getPlayers().get(i).getY();
            g.drawImage(gameMap.getPlayers().get(i).getImage(), x, y, this);
        }
        for(int i =0; i < gameMap.getBombs().size();i++){
            g.drawImage(images.get(3),gameMap.getBombs().get(i).getX(),gameMap.getBombs().get(i).getY(),this);
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