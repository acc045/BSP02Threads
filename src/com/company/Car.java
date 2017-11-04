package com.company;

import java.util.Random;

public class Car extends Thread {

    private int finalTime;

    private static final Random RANDOM = new Random();

    Car(String name) {
        super(name);
        this.finalTime = 0;
    }

    void startCar() {
        try {
            this.start();
            this.join();
        } catch (InterruptedException e) {
            System.err.println("An error occurred in startCar():" + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            int roundTime;
            for (int round = 0; round < SimRace.ROUNDS; round++) {
                roundTime = RANDOM.nextInt(100);
                finalTime += roundTime;
                sleep(roundTime);
            }
        } catch (InterruptedException e) {
            System.err.println("An error occurred in run():" + e.getMessage());
        }
    }

    int getFinalTime() {
        return finalTime;
    }

}
