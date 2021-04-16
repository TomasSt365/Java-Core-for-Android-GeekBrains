package Lessons.Lesson8;

public class Human implements Jumping, Running {
    private String name;
    private int runLimit;
    private int swimLimit;

    public Human(String name, int runLimit, int swimLimit){
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
    }

    @Override
    public void jump(Wall wall) {
        if(wall.getDistance() > swimLimit){
            System.out.println(name  + " did not overcome the obstacle");
        }
        else
            System.out.println(name + " overcame the obstacle");
    }

    @Override
    public void run(Treadmill treadmill) {
        if(treadmill.getDistance() > runLimit){
            System.out.println(name  + " did not overcome the obstacle");
        }
        else
            System.out.println(name + " overcame the obstacle");
    }
}
