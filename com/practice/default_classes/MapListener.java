package nets_graphic_practice.com.practice.default_classes;

import java.awt.event.KeyListener;

/**
 * Created by Bogdan on 11.07.2016.
 */
public interface MapListener extends KeyListener {
    void newEvent(MapEvent m);
}
