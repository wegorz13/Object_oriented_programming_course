package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.exceptions.IncorrectPositionException;

import java.util.ArrayList;
import java.util.List;

public class Simulation implements Runnable{
    private final List<MoveDirection> animalMoves;
    private final List<Animal> animals = new ArrayList<>();
    private final WorldMap map;

    List<Animal> getAnimals() {
        return this.animals;
    }

    public Simulation(List<Vector2d> positions, List<MoveDirection> moves, WorldMap map){
        this.animalMoves = moves;
        this.map = map;
        for (Vector2d position : positions){
            Animal animal = new Animal(position);
            try {
                this.map.place(animal);
                this.animals.add(animal);
            } catch (IncorrectPositionException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public void run(){
        int numberOfAnimals = this.animals.size();
        int numberOfMoves = this.animalMoves.size();

        for (int i=0;i<numberOfMoves;i++){
            this.map.move(this.animals.get(i % numberOfAnimals),this.animalMoves.get(i));
        }
    }
}
