package nets_graphic_practice.com.practice.test;

import nets_graphic_practice.com.practice.model.GameMap;

import javax.swing.JFrame;

public class GameWindow extends JFrame {

    private JFrame frame;
    private GameMap gameMap;
    public GameWindow(GameMap gm){
        gameMap = gm;
        frame = new JFrame("BOMBERMAN!ULTRA!MEGA!EDITION!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setResizable(false);
        frame.add(new MapView(gm));
        frame.setVisible(true);

    }


}