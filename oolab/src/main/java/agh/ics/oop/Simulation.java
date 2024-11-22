package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<MoveDirection> animalMoves;
    private final List<Animal> animals = new ArrayList<Animal>();
    private final RectangularMap map;

    List<MoveDirection> getAnimalMoves() {
        return this.animalMoves;
    }

    List<Animal> getAnimals() {
        return this.animals;
    }

    public Simulation(List<Vector2d> positions, List<MoveDirection> moves, RectangularMap map){
        this.animalMoves = moves;
        this.map = map;
        for (Vector2d position : positions){
            Animal animal = new Animal(position);
            if (this.map.place(animal)) {
                this.animals.add(animal);
            };

        }
    }

    public void run(){
        int numberOfAnimals = this.animals.size();
        int numberOfMoves = this.animalMoves.size();

        for (int i=0;i<numberOfMoves;i++){
            this.map.move(this.animals.get(i % numberOfAnimals),this.animalMoves.get(i));
            System.out.println(this.map);

        }
    }
}
