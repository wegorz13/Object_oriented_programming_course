package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{
    private int mapChanges =0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        this.mapChanges++;
        System.out.println(message);
        System.out.println(worldMap);
        System.out.println("Changes made: " + mapChanges);
    }
}
