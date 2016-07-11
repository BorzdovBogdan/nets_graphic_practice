package nets_graphic_practice.com.practice.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Bogdan on 06.07.2016.
 */
public class GameMap implements ActionListener {
    private char map[][];
    private ArrayList<Player> players;
    private ArrayList<Bomb> bombs;
    private GameMapReader gmr;
    public GameMap(GameMapReader gmr/*,ArrayList<Player> players*/){
        gmr.load("field.txt");
        this.map = gmr.getMap();
        players = new ArrayList<>();
        bombs = new ArrayList<>();
    }
    public void move(){

    }
    /**
     * a bomb set to location of player and player move to previous location
     */
    public void setBomb(){
        map[players.get(0).getX()][players.get(0).getY()] = '*';
        bombs.add(new Bomb(players.get(0).getX(),players.get(0).getY()));
    }
    public void tick(){
        for (int i = 0; i < bombs.size();i++){
            bombs.get(i).tickTime();
            if(bombs.get(i).getTime() == 0){
                //explode
                map[bombs.get(i).getX()][bombs.get(i).getY()] = ' ';
                bombs.remove(i);
            }
        }
    }
    public boolean isEnd(Player player){
        return player.getHealth()==0;
    }
    public void set(int x, int y,Object thing){

    }
    public void set(){

    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i = 0;i <map.length;i++){
            for(int j = 0;j <map.length;j++){
                str.append(map[i][j]);
            }
            str.append('\n');
        }
        return new String(str);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
