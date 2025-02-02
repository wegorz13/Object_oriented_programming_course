package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{
    private int mapChanges =0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        synchronized (System.out){
            this.mapChanges++;
            System.out.println(message);
            System.out.println(worldMap);
            System.out.println("Changes made: " + mapChanges + ", the one above to map with ID: " + worldMap.getId());
        }
    }
}
