package nets_graphic_practice.com.practice.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import static nets_graphic_practice.com.practice.test.Actions.*;

/**
 * Created by Bogdan on 06.07.2016.
 */
public class GameMap implements ActionListener {

    private final char map[][];
    private ArrayList<Player> players;
    private ArrayList<Bomb> bombs;
    public GameMap(GameMapReader gmr/*,ArrayList<Player> players*/){
        gmr.load("field.txt");
        this.map = gmr.getMap();
        players = new ArrayList<>();
        int c;

        for(int i = 0; i < map.length;i++) {
            for (int j = 0; j < map[i].length; j++) {
                c = map[i][j];
                if (c == 'c' ) {
                    players.add(new Player(4, 4, c));
                }
            }
            //this.players = players;
            bombs = new ArrayList<>();

        }
    }
    public boolean move(int key,Player player){
        int x = player.getX();
        int y = player.getY();
        switch (key){
            case KeyEvent.VK_DOWN: {
                if(y+1 < map.length && map[y+1][x]==' '){
                    map[y+1][x] =(char) player.getID();
                    player.setY(y+1);
                    map[y][x] = ' ';
                    return true;
                }
                return false;
            }
            case KeyEvent.VK_UP : {
                if(y-1 >-1 && map[y-1][x]==' '){
                    map[y-1][x] = (char) player.getID();
                    player.setY(y-1);
                    map[y][x] = ' ';
                    return true;
                }
                return false;
            }
            case KeyEvent.VK_RIGHT : {
                if(x+1 < map[y].length && map[y][x+1]==' '){
                    map[y][x+1] = (char) player.getID();
                    player.setX(x+1);
                    map[y][x] = ' ';
                    return true;
                }
                return false;
            }
            case KeyEvent.VK_LEFT: {
                if(x-1 > -1  && map[y][x-1]==' '){
                    map[y][x-1] = (char) player.getID();
                    player.setX(x-1);
                    map[y][x] = ' ';
                    return true;
                }
                return false;
            }
        }
        return false;
    }
    /**
     * a bomb set to location of player and player move to previous location
     */
    public void setBomb(Player player){
        map[player.getX()][player.getY()] = '*';
        bombs.add(new Bomb(player.getX(),player.getY()));
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

    public ArrayList<Player> getPlayers() {
        return players;
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
