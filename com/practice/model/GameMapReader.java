package nets_graphic_practice.com.practice.model;
<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
=======
import java.io.*;
import java.util.Random;
>>>>>>> d5dd83c0bf0b1d4b46738808090c70a908272f0e

public class GameMapReader {
    private char map[][];
    private int width;
    private int length;
    private int sizeOfThing;
    private int border;
    public GameMapReader(int sizeOfThing, int border){
        length = 0;
        width = 1;
        this.sizeOfThing = sizeOfThing;
        this.border = border;
    }

    public String pathCanon(){

        String[] path = GameMapReader.class.getResource("").toString().split(":");
        StringBuilder str = new StringBuilder();

        path[1] = path[1]+":";

        for(int i = 1; i < path.length; i++){
            str.append(path[i]);
        }

        return new String(str);
    }
    private void getSizeOfMap(String fileName){
        try {
            FileReader reader = new FileReader(pathCanon()+fileName);
            while(reader.read()!='\n'){
                length++;
            }
            length-=1;
            int c;
            while ((c=reader.read())!=-1){
                if(c=='\n')
                    width++;
            }
            width+=1;
            reader.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public void load(String fileName) {
        getSizeOfMap(fileName);
        map = new char[width][length];

        try {
            FileReader reader = new FileReader(pathCanon()+fileName);
            int c=0;
            for(int i = 0;i<width&&c!=-1;i++){
                c = reader.read();

                for(int j = 0;j<length;c=reader.read(),j++){
                    if (c == '\n'||c == '\r') {
                        c = reader.read();
                    }
                    if(c!=-1)
                        map[i][j] =(char) c;
                    else
                        break;
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void initGameMap(String fileName){
        length = 0;
        width = 0;

        try{
            BufferedReader fileReader = new BufferedReader(new FileReader(pathCanon()+fileName));

            width = ((Integer.parseInt(fileReader.readLine()))/sizeOfThing)+border;
            length = ((Integer.parseInt(fileReader.readLine()))/sizeOfThing)+border;
            fileReader.close();
        }catch(IOException e){
            System.out.println("Problems with map txt file");
        }

        map = new char[width][length];
        for (int i = 0; i < width; i++){
            for (int j = 0; j < length; j++){
                if((i==border||i==width-border-1)&&(j>=border&&j<length-border-1)){
                    map[i][j]='B';
                    continue;
                }
                if(i>=border&&i<width-border &&(j==border||j==length-border-1)){
                    map[i][j]='B';
                    continue;
                }
                map[i][j] = '0';
            }
        }
        for (int i = border+2; i < width-border-2; i+=2) {
            for (int j = border+2; j < length-border-2; j+=2) {
                map[i][j]='1';
            }
        }
        //TODO for multi player coordinates
        map[border+1][border+1]='c';
        for (int i = 0; i < width; i++) {
            for (int j = 0; j <length ; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }

    public char[][] getMap() {
        return map;
    }
}