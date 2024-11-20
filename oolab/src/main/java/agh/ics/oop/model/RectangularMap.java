package agh.ics.oop.model;
import agh.ics.oop.model.util.MapVisualizer;
import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int width, int height) {
        super(new Vector2d(0,0),new Vector2d(width-1,height-1));
    }
}




