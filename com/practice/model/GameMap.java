package nets_graphic_practice.com.practice.model;

import nets_graphic_practice.com.practice.view.GameView;
import nets_graphic_practice.com.practice.view.MapEvent;
import nets_graphic_practice.com.practice.view.MapView;
import sun.swing.BakedArrayList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


/**
 * Created by Bogdan on 06.07.2016.
 */
public class GameMap implements ActionListener {

    private final char map[][];
    public final int UP=0;
    public final int DOWN=1;
    public final int RIGHT=2;
    public final int LEFT=3;
    public final int BOMB_PLANTED=4;
    public final int BOMB_EXPLODED=5;
    private ArrayList<Player> players;
    private ArrayList<Bomb> bombs;
    private Timer timer;
    private MapView mapView;
    private ArrayList<Thread> bombsThreads;
    public GameMap(GameMapReader gmr/*,ArrayList<Player> players*/){
        gmr.initGameMap("map.txt");
        this.map = gmr.getMap();
        players = new ArrayList<>();
        int c;
        for(int i = 0; i < map.length;i++) {
            for (int j = 0; j < map[i].length; j++) {
                c = map[i][j];
                if (c == 'c' ) {
                    /*if(i%31!=0&&j%31!=0){
                        int modi=0;
                        int modj=0;
                        if(i<31){
                            i =31;
                        }
                        if(j<31){
                            j=31;
                        }
                        if(i>31&&j>31){
                            modi = i%31;
                            modj = j%31;
                        }
                        players.add(new Player(i+modi, j+modj, c));
                        map[i][j] = ' ';
                        map[i+modi][j+modj] = (char)c;
                        continue;
                    }*/
                    map[i][j]='0';
                    players.add(new Player(i, j, c));
                }
            }
            //this.players = players;
            bombs = new ArrayList<>();
            bombsThreads = new ArrayList<>();
            timer = new Timer(5,this);
            timer.start();
        }
    }
    public void setMapView(MapView mapView){
        this.mapView = mapView;
    }
    public boolean canJoin(){
        if(players.size()==4){
            return false;
        }
        return true;
    }

    public ArrayList<Bomb> getBombs() {
        return bombs;
    }

    private void addBlocks(){
        for (int i = 63; i < map.length-64 ; i+=64) {
            for (int j = 63; j < map[i].length-64; j+=64) {
                map[i][j]='1';
            }
        }
    }
    public char[][] getMap(){
        return map;
    }
    public boolean move(int key, Player player, MapView mapView){
        int x = player.getX();
        int y = player.getY();
        switch (key){
            case KeyEvent.VK_DOWN: {
                if(y+1 < map.length && map[y+1][x]=='0'){
                    //map[y+1][x] =(char) player.getID();
                    player.setPrevMove(1);
                    player.setPrevX(player.getX());
                    player.setPrevY(player.getY());
                    player.setY(y + 1);
                    player.setStepY(player.getStepY() + 1);
                    player.setPlantedBomb(false);
                    map[y][x] = '0';
                    mapView.newEvent(new MapEvent(DOWN));
                    return true;
                }
                return false;
            }
            case KeyEvent.VK_UP : {
                if(y-1 >-1 && map[y-1][x]=='0'){
                    //map[y-1][x] = (char) player.getID();
                    player.setPrevMove(2);
                    player.setPrevX(player.getX());
                    player.setPrevY(player.getY());
                    player.setY(y - 1);
                    player.setStepY(player.getStepY() - 1);
                    player.setPlantedBomb(false);
                    map[y][x] = '0';
                    mapView.newEvent(new MapEvent(UP));
                    return true;
                }
                return false;
            }
            case KeyEvent.VK_RIGHT : {
                if(x+1 < map[y].length && map[y][x+1]=='0'){
                    //map[y][x+1] = (char) player.getID();
                    player.setPrevMove(4);
                    player.setPrevX(player.getX());
                    player.setPrevY(player.getY());
                    player.setX(x + 1);
                    player.setStepX(player.getStepX() + 1);
                    player.setPlantedBomb(false);
                    map[y][x] = '0';
                    mapView.newEvent(new MapEvent(RIGHT));
                    return true;
                }
                return false;
            }
            case KeyEvent.VK_LEFT: {
                if(x-1 > -1  && map[y][x-1]=='0'){
                    //map[y][x-1] = (char) player.getID();
                    player.setPrevMove(3);
                    player.setPrevX(player.getX());
                    player.setPrevY(player.getY());
                    player.setX(x-1);
                    player.setStepX(player.getStepX()-1);
                    player.setPlantedBomb(false);
                    map[y][x] = '0';
                    mapView.newEvent(new MapEvent(LEFT));
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
    public void setBomb(Player player,MapView mapView){
        if(player.isPlantedBomb()){
            return;
        }
        int prX,prY,prevMove=player.getPrevMove();
        prX=player.getX();
        prY=player.getY();
        //map[player.getY()][player.getX()] = '*';
        Bomb bomb = new Bomb(player.getX(),player.getY());
        /*bombsThreads.add(new Thread(new Runnable() {
            @Override
            public void run() {
                while (bomb.getTime()>0){
                    bomb.tickTime();
                }
                mapView.newEvent();
            }
        }));*/
        bombs.add(bomb);
        player.setPlantedBomb(true);
        player.setX(player.getPrevX());
        player.setY(player.getPrevY());
        player.setPrevX(prX);
        player.setPrevY(prY);
        switch (prevMove){
            case DOWN:{
                player.setStepY(player.getStepY()-1);
                break;
            }
            case UP:{
                player.setStepY(player.getStepY()+1);
                break;
            }
            case LEFT:{
                player.setStepX(player.getStepX()+1);
                break;
            }
            case RIGHT:{
                player.setStepX(player.getStepX()-1);
                break;
            }
        }
        mapView.newEvent(new MapEvent(BOMB_PLANTED));

        //map[player.getY()][player.getX()] =(char) player.getID();
    }

    public void tick(){
        if(bombs.size()==0)
            return;
        for (int i = 0; i < bombs.size();i++){
            bombs.get(i).tickTime();
            if(bombs.get(i).getTime() == 0){
                bombs.get(i).setExploded(true);
                mapView.newEvent(new MapEvent(BOMB_EXPLODED));
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
        //tick();

    }
}