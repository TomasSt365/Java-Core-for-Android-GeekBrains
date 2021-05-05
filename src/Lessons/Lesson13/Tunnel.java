package Lessons.Lesson13;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    public static final int tunnelCapacity = 2;
    //не получилось привязаться к количеству участников(когда я делил участников на 2 , то получался 0)
    //использовал метод Car.getCarsCount()
    private static final Semaphore smp = new Semaphore(tunnelCapacity);

    public Tunnel() {
        this.length = 80;
        this.description = "Tunnel " + length + " meters";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " prepares for stage (waits): " + description);
                smp.acquire();
                System.out.println(c.getName() + " started the stage: " + description);
                Thread.sleep(length / c.getSpeed() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " finished stage: " + description);
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
