package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> convertDirections (String [] args) {
        List<MoveDirection> directions = new ArrayList<>(args.length);

        for (String argument : args) {
            switch (argument) {
                case "f" -> directions.add(MoveDirection.FORWARD);
                case "b" -> directions.add(MoveDirection.BACKWARD);
                case "r" -> directions.add(MoveDirection.RIGHT);
                case "l" -> directions.add(MoveDirection.LEFT);
                default -> throw new IllegalArgumentException(argument + " is not legal move specification");
            }
        }
        return directions;
    }
}
