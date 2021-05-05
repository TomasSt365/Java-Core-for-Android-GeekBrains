package Lessons.Lesson13;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static Lock lock = new ReentrantLock();
    private static int CARS_COUNT;
    private static CyclicBarrier cyclicBarrier;
    private static boolean isNotPrintWin = true;

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public static int getCarsCount() {
        return CARS_COUNT;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Participant #" + CARS_COUNT;
        cyclicBarrier = new CyclicBarrier(CARS_COUNT);
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " is preparing");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " is ready");
            Main.raceBeginsMessageCdl.countDown();//До последнего не хотел делать привязку к главному классу
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
            if(i == race.getStages().size() - 1){
                printWinMessage(this.name);
                Main.gameOverMessageCdl.countDown();//Та же ситуация, что и с выводом сообщения о начале гонки
            }
        }

    }

    private static void printWinMessage(String name){
        try {
            lock.lock();
            if(isNotPrintWin) {
                System.out.println(name + " - WIN");
                isNotPrintWin = false;
            }
        }finally {
            lock.unlock();
        }

    }

}
