package nets_graphic_practice.com.practice.default_classes;

/**
 * Created by Bogdan on 11.07.2016.
 */
public class MapEvent {
    private int eventType=0;
    private int PLAYER_MOVE_UP=1;
    private int PLAYER_MOVE_DOWN=2;
    private int PLAYER_MOVE_RIGHT=3;
    private int PLAYER_MOVE_LEFT=4;
    private int BOMB_CRASHED=5;
    public void setEventType(int eventType){
        this.eventType = eventType;
    }
    public int getEventType() {
        return eventType;
    }
}
