/*
package nets_graphic_practice.com.practice.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player2 implements Runnable{

    private String sprite2 = "2.png";
    private int dx2;
    private int dy2;
    private int x2;
    private int y2;
    private boolean r = false;
    private Image image2;

    public Player2() {
        ImageIcon ii2 = new ImageIcon(this.getClass().getResource(sprite2));
        image2 = ii2.getImage();
        x2 = 400;
        y2 = 60;
    }


    public void move() {
        x2 += dx2;
        y2 += dy2;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public Image getImage2() {
        return image2;
    }

    public void keyPressed2(KeyEvent e2) {

        int key2 = e2.getKeyCode();

        if (key2 == KeyEvent.VK_F){
            //setBomb();
        }

        if (key2 == KeyEvent.VK_A) {
            dx2 = -1;
            if (r == true){dx2 = -3;}
        }

        if (key2 == KeyEvent.VK_D) {
            dx2 = 1;
            if (r == true){dx2 = 3;}
        }

        if (key2 == KeyEvent.VK_W) {
            dy2 = -1;
        }

        if (key2 == KeyEvent.VK_S) {
            dy2 = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key2 = e.getKeyCode();

        if (key2 == KeyEvent.VK_F) {
            //  setBomb();
        }

        if (key2 == KeyEvent.VK_A) {
            dx2 = 0;
        }

        if (key2 == KeyEvent.VK_D) {
            dx2 = 0;
        }

        if (key2 == KeyEvent.VK_W) {
            dy2 = 0;
        }

        if (key2 == KeyEvent.VK_S) {
            dy2 = 0;
        }
    }

    public void run() {

        Player2 s2 = new Player2();
        new Thread(s2).start();
    }
}

*/
