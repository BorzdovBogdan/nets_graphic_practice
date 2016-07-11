package nets_graphic_practice.com.practice.model;
import java.io.*;
public class GameMapReader {
    private char map[][];
    private int width;
    private int length;
    public GameMapReader(){
        length = 0;
        width = 1;
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
        for (int i = 0; i < width; i++) {
                for (int j = 0; j < length; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
        }
    }

    public char[][] getMap() {
        return map;
    }
}

