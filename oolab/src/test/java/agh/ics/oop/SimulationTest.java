package agh.ics.oop;

//czy zwierzę ma właściwą orientację,
//czy zwierzę przemieszcza się na właściwe pozycje,
//czy zwierzę nie wychodzi poza mapę,
//czy dane wejściowe podane jako tablica łańcuchów znaków
//są poprawnie interpretowane.

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
        List<Vector2d> positions = List.of(new Vector2d(1,1),new Vector2d(2,2));
        String[] args = {"f","b","r","l","f","f","f","f","f","f"};
        List<MoveDirection> directions = OptionsParser.convertDirections(args);

        Simulation simulation = new Simulation(positions, directions);
        simulation.run();

        Animal animal1 = simulation.getAnimals().get(0);
        Animal animal2 = simulation.getAnimals().get(1);

        assertEquals(animal1.getDirection(), MapDirection.EAST);
        assertEquals(animal2.getDirection(), MapDirection.WEST);
        assertTrue(animal1.isAt(new Vector2d(4,2)));
        assertTrue(animal2.isAt(new Vector2d(0,1)));
    }
}
