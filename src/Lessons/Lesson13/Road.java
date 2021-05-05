package Lessons.Lesson13;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Road " + length + " meters";
    }
    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " started the stage: " + description);
            Thread.sleep(length / c.getSpeed() * 1000L);
            System.out.println(c.getName() + " finished the stage: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
