package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> convertDirections (String [] args) {
        // zdecydowałem się na użycie ArrayList zamiast LinkedList ponieważ na ten moment w klasie Simulation
        // dodajemy do listy n zwierząt raz, a sięgamy po ruchy/zwierzęta z listy wielokrotnie,
        // z czego pierwsza operacja jest wolniejsza na ArrayList, natomiast druga jest szybsza na ArrayList
        List<MoveDirection> directions = new ArrayList<>(0);

        for (String dir : args) {
            switch (dir) {
                case "f" -> directions.add(MoveDirection.FORWARD);
                case "b" -> directions.add(MoveDirection.BACKWARD);
                case "r" -> directions.add(MoveDirection.RIGHT);
                case "l" -> directions.add(MoveDirection.LEFT);
            }
        }
        return directions;
    }
}
