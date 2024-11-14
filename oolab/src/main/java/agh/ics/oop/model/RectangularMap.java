package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap{

    private final Map<Vector2d, Animal> animals = new HashMap<>();
    private final int width;
    private final int height;
    private final Vector2d upperRightCorner;
    private final Vector2d lowerLeftCorner= new Vector2d(0,0);
    private final MapVisualizer visualizer= new MapVisualizer(this);

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.upperRightCorner = new Vector2d(width,height);
    }

    @Override
    public String toString() {
        return this.visualizer.draw(lowerLeftCorner,upperRightCorner);
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
        if (canMoveTo(position)) {
            this.animals.put(position,animal);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d lastPosition = animal.getPosition();
        animal.move(this,direction);
        Vector2d newPosition = animal.getPosition();

        if (!lastPosition.equals(newPosition)){
            this.animals.remove(lastPosition);
            this.animals.put(newPosition,animal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return this.animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (position.follows(this.lowerLeftCorner) && position.precedes(this.upperRightCorner) && !isOccupied(position));
    }
}


