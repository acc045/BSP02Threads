package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class SimRace {

    static final int ROUNDS = 5;
    private static final int CARS = 5;

    private static ArrayList<Car> cars = new ArrayList<>();

    private SimRace() {
        initialize();
    }

    private void initialize() {
        for (int i = 0; i < CARS; i++) {
            cars.add(new Car("Driver " + i));
        }
    }

    private void start() {
        for (Car car : cars) {
            car.startCar();
        }
        finishRace();
    }

    private void finishRace() {
        cars.sort(Comparator.comparingInt(Car::getFinalTime));

        int place = 1;

        System.out.println("**** FINAL SCORE ****");
        for (Car car : cars) {
            String result = String.format("%d. PLACE: %s TIME: %d", place++, car.getName(), car.getFinalTime());
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        SimRace race = new SimRace();
        race.start();
    }
}
