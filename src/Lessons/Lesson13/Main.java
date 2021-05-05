package Lessons.Lesson13;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static final int CARS_COUNT = 4;
    public static final CountDownLatch gameOverMessageCdl = new CountDownLatch(CARS_COUNT);
    public static final CountDownLatch raceBeginsMessageCdl = new CountDownLatch(CARS_COUNT);

    public static void main(String[] args) {
        System.out.println("IMPORTANT MESSAGE >>> Preparation !!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));

        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        for (Car car : cars) {
            new Thread(car).start();
        }
        try {
            raceBeginsMessageCdl.await();
            System.out.println("IMPORTANT MESSAGE >>> The race begins !!!");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            gameOverMessageCdl.await();
            System.out.println("IMPORTANT MESSAGE >>> The race is over !!!");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
