package agh.ics.oop.model;

import agh.ics.oop.model.exceptions.IncorrectPositionException;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap{
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected final MapVisualizer visualizer= new MapVisualizer(this);
    private final List<MapChangeListener> subscribers = new LinkedList<>();
    private static int mapsCreated=0;
    private final int id;

    protected AbstractWorldMap() {
        synchronized (this){
            this.id = mapsCreated;
            mapsCreated++;
        }
    }

    @Override
    public void place(Animal animal) throws IncorrectPositionException {
        Vector2d position = animal.getPosition();
        if (canMoveTo(position)) {
            this.animals.put(position,animal);
            mapChanged("Animal placed at position: " + position);
        }
        else{
        throw new IncorrectPositionException(position);
    }
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d lastPosition = animal.getPosition();
        animal.move(this,direction);
        Vector2d newPosition = animal.getPosition();

        if (!lastPosition.equals(newPosition)){
            this.animals.remove(lastPosition);
            this.animals.put(newPosition,animal);
            mapChanged("Animal moved to position: " + newPosition);
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
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public List<WorldElement> getElements() {
        return new ArrayList<>(animals.values());
    }

    @Override
    public String toString() {
        Boundary boundaries = this.getCurrentBounds();
        return this.visualizer.draw(boundaries.lowerLeftCorner(),boundaries.upperRightCorner());
    }

    public abstract Boundary getCurrentBounds();

    public void addSubscriber (MapChangeListener subscriber){
        this.subscribers.add(subscriber);
    }

    public void removeSubscriber (MapChangeListener subscriber){
        this.subscribers.remove(subscriber);
    }

    private void mapChanged(String message){
        for (MapChangeListener subscriber : this.subscribers){
            subscriber.mapChanged(this,message);
        }
    }

    @Override
    public int getId(){
        return this.id;
    }
}
