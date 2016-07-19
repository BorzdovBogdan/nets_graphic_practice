package nets_graphic_practice.com.practice.view;

/**
 * Created by User on 19.07.2016.
 */
public class MapEvent {
    private int eventType;
    public final int UP=0;
    public final int DOWN=1;
    public final int RIGHT=2;
    public final int LEFT=3;
    public final int BOMB_PLANTED=4;
    public final int BOMB_EXPLODED=5;
    public MapEvent(int eventType){
        this.eventType = eventType;
    }
    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public int getEventType(){
        return eventType;
    }
}
