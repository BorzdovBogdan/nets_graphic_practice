package nets_graphic_practice.com.practice.model;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Bogdan on 06.07.2016.
 */
public class Player {
    private int health;
    private int killed;
    private int x;
    private int y;
    private int prevX;
    private int prevY;
    private int ID;
    private Image image;
    private int stepX;
    private int stepY;
    public Player(int x, int y,int id){
        stepX = 0;
        stepY = 0;
        ID =id;
        prevX =31;
        prevY =31;
        this.x = x;
        this.y = y;
        ImageIcon iiPlayer1 = new ImageIcon(this.getClass().getResource("1.png"));
        image = iiPlayer1.getImage();
    }
    public void setStepX(int stepX){
        if(stepX<0)
            return;
        this.stepX = stepX;
    }
    public void setStepY(int stepY){
        if(stepY<0)
            return;
        this.stepY = stepY;
    }

    public int getStepX() {
        return stepX;
    }

    public int getStepY() {
        return stepY;
    }

    public Image getImage(){
        return image;
    }
    public void setID(int id){
        ID = id;
    }
    public int getID() {
        return ID;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPrevX(int prevX) {
        this.prevX = prevX;
    }

    public void setPrevY(int prevY) {
        this.prevY = prevY;
    }

    public int getPrevX() {
        return prevX;
    }

    public int getPrevY() {
        return prevY;
    }
    public int getX() {

        return x;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setKilled(int killed) {
        this.killed = killed;
    }

    public int getKilled() {

        return killed;
    }

    public int getHealth() {

        return health;
    }
}
