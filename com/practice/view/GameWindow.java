package nets_graphic_practice.com.practice.view;

import nets_graphic_practice.com.practice.model.GameMap;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
    public static int step=128;
    public static int blockCount = 8;
    private JFrame frame;
    private GameMap gameMap;
    public GameWindow(GameMap gm){
        gameMap = gm;
        frame = new JFrame("BOMBERMAN!ULTRA!MEGA!EDITION!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(806,636);
        frame.setSize(step*blockCount,step*blockCount);
        frame.setResizable(false);
        frame.add(new MapView(gm));
        frame.setVisible(true);

    }


}