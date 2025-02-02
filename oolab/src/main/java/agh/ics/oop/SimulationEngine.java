package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine {
    private final List<Simulation> simulations;
    private final List<Thread> threads;
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public SimulationEngine(List<Simulation> simulations){
        this.simulations=simulations;
        this.threads = new ArrayList<>(simulations.size());
    }

    public void runSync(){
        for (Simulation simulation : this.simulations){
            simulation.run();
        }
    }

    public void runAsync() {
        for (Simulation simulation : this.simulations) {
            Thread thread = new Thread(simulation);
            this.threads.add(thread);
            thread.start();
        }
    }

    public void runAsyncInThreadPool(){
        for (Simulation simulation : this.simulations){
            this.executorService.submit(simulation);
        }

    }

    public void awaitSimulationsEnd() {
        try {
            executorService.shutdown();
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Thread pool didn't terminate in due time");
                executorService.shutdownNow();
            }
            for (Thread thread : this.threads) {
                thread.join();
            }
        }
        catch(InterruptedException e){
            System.err.println(e.getMessage());
        }
    }
}