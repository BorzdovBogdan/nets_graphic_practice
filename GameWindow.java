package com.company;
import javax.swing.JFrame;

public class GameWindow {

    JFrame frame;

    public GameWindow(){
        frame = new JFrame("BOMBERMAN!ULTRA!MEGA!EDITION!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setResizable(false);
        frame.add(new GameScreen());
        frame.setVisible(true);

    }


}