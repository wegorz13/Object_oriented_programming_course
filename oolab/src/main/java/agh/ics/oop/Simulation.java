package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<MoveDirection> animal_moves;
    private final List<Animal> animals = new ArrayList<Animal>(0);

    public List<MoveDirection> getAnimalMoves() {
        return this.animal_moves;
    }

    public List<Animal> getAnimals() {
        return this.animals;
    }

    public Simulation(List<Vector2d> positions, List<MoveDirection> moves){
        this.animal_moves = moves;

        for (Vector2d position : positions){
            this.animals.add(new Animal(position));
        }
    }

    public void run(){
        int number_of_animals = this.animals.size();
        int number_of_moves = this.animal_moves.size();

        for (int i=0;i<number_of_moves;i++){
            this.animals.get(i % number_of_animals).move(this.animal_moves.get(i));
            System.out.println("Zwierzę " + i%number_of_animals + " : " + this.animals.get(i%number_of_animals).getPosition().toString());
        }
    }


}
