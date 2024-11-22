package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SimulationTest {

    @Test
    void runsCorrect(){
        //given

        List<Vector2d> positions = List.of(new Vector2d(1,1),new Vector2d(2,2), new Vector2d(1,2));
        String[] args = {"f","r","f","l","f","r","f","f","f","f","r","f"};
        List<MoveDirection> directions = OptionsParser.convertDirections(args);
        RectangularMap map = new RectangularMap(4,4);

        Simulation simulation = new Simulation(positions, directions,map);
        Animal animal1 = simulation.getAnimals().get(0);
        Animal animal2 = simulation.getAnimals().get(1);
        Animal animal3 = simulation.getAnimals().get(2);

        //czy pozycja startowa sie zgadza
        assertEquals(new Vector2d(1,1),animal1.getPosition());
        assertEquals(new Vector2d(2,2),animal2.getPosition());
        assertEquals(new Vector2d(1,2),animal3.getPosition());

        //czy kierunek poczatkowy sie zgadza
        assertEquals(animal1.getDirection(), MapDirection.NORTH);

        //when
        simulation.run();

        //then


        //czy kierunek koncowy sie zgadza
        assertEquals(animal1.getDirection(), MapDirection.WEST);
        assertEquals(animal2.getDirection(), MapDirection.SOUTH);
        assertEquals(animal3.getDirection(), MapDirection.EAST);

        //czy pozycja koncowa sie zgadza
        assertTrue(animal1.isAt(new Vector2d(0,1)));
        System.out.println(animal2.getPosition());
        assertTrue(animal2.isAt(new Vector2d(3,2)));
        assertTrue(animal3.isAt(new Vector2d(3,3)));
    }
}
