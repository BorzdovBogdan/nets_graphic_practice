package nets_graphic_practice.com.practice.model;

/**
 * Created by Bogdan on 06.07.2016.
 */
public class Bomb {
    private int time;
    private static final int INITIAL_TIME = 10;
    private int x;
    private int y;
    public Bomb(int x,int y){
        time = INITIAL_TIME;
        this.x = x;
        this.y = y;
    }

    public void tickTime() {
        time--;
    }

    public int getTime() {
        return time;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
