package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
        run(OptionsParser.convertDirections(args));
        System.out.println("system zakończył działanie");
    }

    public static void run(MoveDirection[] directions) {
        System.out.println("Start");
        for (MoveDirection direction: directions)  {
            switch (direction){
                case FORWARD -> System.out.println("Zwierzak idzie do przodu"+',');
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu"+',');
                case RIGHT -> System.out.println("Zwierzak skręca w prawo"+',');
                case LEFT -> System.out.println("Zwierzak skręca w lewo"+',');
            }
            }
        System.out.println("Stop");
        }

    }

