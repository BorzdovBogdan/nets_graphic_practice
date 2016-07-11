package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GameScreen extends JPanel implements ActionListener{
    private static final long serialVersionUID = 1L;

    private Timer timer;
    private Player1 sprite;
    private Player2 sprite2;

    public GameScreen(){
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        sprite = new Player1();
        sprite2 = new Player2();
        timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g1d = (Graphics2D)g;
        Graphics2D g2d = (Graphics2D)g;
        g1d.drawImage(sprite.getImage(), sprite.getX(), sprite.getY(), this);
        g2d.drawImage(sprite2.getImage2(), sprite2.getX2(), sprite2.getY2(), this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void run() {
        GameScreen t1 = new GameScreen();
        new Thread((Runnable) t1).start();

    }

    public void actionPerformed(ActionEvent e) {

        sprite.move();
        repaint();
        sprite2.move();
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            sprite.keyReleased(e);
            sprite2.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            sprite.keyPressed(e);
            sprite2.keyPressed2(e);
        }

    }

}