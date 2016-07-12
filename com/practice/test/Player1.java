/*
package nets_graphic_practice.com.practice.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player1 implements Runnable{

    private String sprite = "1.png";

    private int dx;
    private int dy;
    private int x;
    private int y;
    private boolean r = false;
    private Image image;


    public Player1() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(sprite));
        image = ii.getImage();
        x = 40;
        y = 60;
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

    public Image getImage() {
        return image;

    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE){
            //setBomb();
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
            if (r == true){dx = -3;}
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
            if (r == true){dx = 3;}
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
          //  setBomb();
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }

    }

    public void run() {

        Player1 s1 = new Player1();

        new Thread(s1).start();

    }
}*/
