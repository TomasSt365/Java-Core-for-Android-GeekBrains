package Lessons.Lesson8.Participants;

import Lessons.Lesson8.Obstacles.Obstacle;
import Lessons.Lesson8.Obstacles.Treadmill;
import Lessons.Lesson8.Obstacles.Wall;

public class Human implements Participant {

    private final String name;
    private final int runLimit;
    private final int jumpLimit;
    private boolean fail = false;

    public Human(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    @Override
    public void jump(Wall wall) {
        if (wall.height() > jumpLimit) {
            System.out.println(name + " did not overcome the wall");
            fail = true;
        } else
            System.out.println(name + " overcame the wall");
    }

    @Override
    public void run(Treadmill treadmill) {
        if (treadmill.length() > runLimit) {
            System.out.println(name + " did not overcome the treadmill");
            fail = true;
        } else
            System.out.println(name + " overcame the treadmill");
    }

    @Override
    public void overcomeObstacle(Obstacle obstacle) {
        {
            switch (obstacle.getObstacleType()){
                case Wall -> jump((Wall) obstacle);
                case Treadmill -> run((Treadmill) obstacle);
            }
        }
    }

    @Override
    public boolean isFail() {
        return fail;
    }
}
