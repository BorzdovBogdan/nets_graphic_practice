package nets_graphic_practice.com.practice.model;

/**
 * Created by Bogdan on 06.07.2016.
 */
public class Bomb {
    private int time;
    private static final int INITIAL_TIME = 50;
    private int x;
    private int y;
    private boolean isExploded;
    private int explosionTime;
    public Bomb(int x,int y){
        time = INITIAL_TIME;
        this.x = x;
        this.y = y;
        isExploded=false;
        explosionTime = 5;
    }

    public void setExploded(boolean exploded) {
        isExploded = exploded;
    }

    public int getExplosionTime() {
        return explosionTime;
    }

    public void setExplosionTime(int explosionTime) {
        this.explosionTime = explosionTime;
    }

    public boolean isExploded() {
        return isExploded;
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
