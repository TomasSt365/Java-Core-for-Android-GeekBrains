package Lessons.Lesson8.Participants;

import Lessons.Lesson8.Obstacles.Obstacle;
import Lessons.Lesson8.Obstacles.Treadmill;
import Lessons.Lesson8.Obstacles.Wall;

public interface Participant {
    void run(Treadmill treadmill);
    void jump(Wall wall);
    void overcomeObstacle(Obstacle obstacle);

    boolean isFail();
}
