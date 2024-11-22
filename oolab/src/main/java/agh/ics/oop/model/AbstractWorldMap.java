package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap{
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    private final Vector2d upperRightCorner;
    private final Vector2d lowerLeftCorner;
    protected final MapVisualizer visualizer= new MapVisualizer(this);

    protected AbstractWorldMap(Vector2d lowerLeftCorner, Vector2d upperRightCorner) {
        this.upperRightCorner = upperRightCorner;
        this.lowerLeftCorner = lowerLeftCorner;
    }

    @Override
    public String toString() {
        return this.visualizer.draw(this.lowerLeftCorner,this.upperRightCorner);
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
    public WorldElement objectAt(Vector2d position) {
        return this.animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (position.follows(this.lowerLeftCorner) && position.precedes(this.upperRightCorner) && !(objectAt(position) instanceof Animal));
    }

    @Override
    public List<WorldElement> getElements() {
        return new ArrayList<WorldElement>(animals.values());
    }
}
