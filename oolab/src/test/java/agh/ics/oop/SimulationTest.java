package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SimulationTest {

    @Test
    void runsCorrect(){
        //given

        List<Vector2d> positions = List.of(new Vector2d(1,1),new Vector2d(2,2));
        String[] args = {"f","b","r","l","f","f","f","f","f","f"};
        List<MoveDirection> directions = OptionsParser.convertDirections(args);

        Simulation simulation = new Simulation(positions, directions);

        Animal animal1 = simulation.getAnimals().get(0);
        Animal animal2 = simulation.getAnimals().get(1);

        //czy pozycja startowa sie zgadza
        assertEquals(new Vector2d(1,1),animal1.getPosition());
        assertEquals(new Vector2d(2,2),animal2.getPosition());

        //czy kierunek poczatkowy sie zgadza
        assertEquals(animal1.getDirection(), MapDirection.NORTH);
        assertEquals(animal2.getDirection(), MapDirection.NORTH);


        //when
        simulation.run();

        //then


        //czy kierunek koncowy sie zgadza
        assertEquals(animal1.getDirection(), MapDirection.EAST);
        assertEquals(animal2.getDirection(), MapDirection.WEST);

        //czy pozycja koncowa sie zgadza
        assertTrue(animal1.isAt(new Vector2d(4,2)));
        assertTrue(animal2.isAt(new Vector2d(0,1)));
    }
}
