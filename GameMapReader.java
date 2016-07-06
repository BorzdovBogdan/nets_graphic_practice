package com.company;
import java.io.*;
public class GameMapReader {

    public void load(String filename) {

        try(FileReader reader = new FileReader("field.txt"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}

