package agh.ics.oop;

import agh.ics.oop.model.*;


import java.util.ArrayList;
import java.util.List;


public class World {
    public static void main(String[] args) {

        List<MoveDirection> directions = OptionsParser.convertDirections(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));

        ConsoleMapDisplay console = new ConsoleMapDisplay();

        List<Simulation> sims = new ArrayList<>(500);

        for (int i=0;i<500;i++){
            GrassField gf = new GrassField(10);
            RectangularMap rm = new RectangularMap(10,10);
            gf.addSubscriber(console);
            rm.addSubscriber(console);
            sims.add(new Simulation(positions,directions,gf));
            sims.add(new Simulation(positions,directions,rm));
        }

        SimulationEngine simulationEngine= new SimulationEngine(sims);
//        simulationEngine.runSync();
//        simulationEngine.runAsync();
        simulationEngine.runAsyncInThreadPool();


        System.out.println("System finished work");

    }
}



