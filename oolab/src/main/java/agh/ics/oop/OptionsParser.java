package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] convertDirections (String [] args) {
        MoveDirection[] directions = new MoveDirection[args.length];
        int k=0;
        int d=0;
        while (k < args.length) {
            switch (args[k]) {
                case "f" -> directions[k-d] = MoveDirection.FORWARD;
                case "b" -> directions[k-d] = MoveDirection.BACKWARD;
                case "r" -> directions[k-d] = MoveDirection.RIGHT;
                case "l" -> directions[k-d] = MoveDirection.LEFT;
                default -> d++;
            }
            k++;
        }
        return Arrays.copyOfRange(directions,0,k-d) ;
    }
}
