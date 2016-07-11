package nets_graphic_practice.com.practice.model;

/**
 * Created by Bogdan on 06.07.2016.
 */
public class Player {
    private int health;
    private int killed;
    private int x;
    private int y;
    public Player(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {

        return x;
    }

    public int getKilled() {

        return killed;
    }

    public int getHealth() {

        return health;
    }
}
