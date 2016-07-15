/*
package com.company;
import jdk.nashorn.internal.ir.annotations.Ignore;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class FileToHashmap {
    String filePath = "in.txt";
    HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    private String line;
    BufferedReader reader = new BufferedReader(new FileReader(filePath));
    String key = null;
    //putting words in key and cat strings in value of  map
    int count = 0;
    String cats[] = null;
    while((String line =reader.readLine())!=null){
        List<String> value = new ArrayList<String>();
        String[] parts = line.split(":", 2);
        count++;
        key = parts[0].trim();
        cats = parts[1].split(", ");
        for (int i = 0; i < cats.length; i++) {
            cats[i] = cats[i].trim();
            cats[i] = cats[i].replace("[", "");
            cats[i] = cats[i].replace("]", "");
            value.add(cats[i]);
        }
        map.put(key, value);
        //map.put(key, value);
    }
    public FileToHashmap() throws IOException {
    }
}*/