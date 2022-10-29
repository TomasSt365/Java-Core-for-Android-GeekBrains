package Lessons.Lesson8;

import Lessons.Lesson8.Obstacles.Obstacle;
import Lessons.Lesson8.Obstacles.Treadmill;
import Lessons.Lesson8.Obstacles.Wall;
import Lessons.Lesson8.Participants.Cat;
import Lessons.Lesson8.Participants.Human;
import Lessons.Lesson8.Participants.Participant;
import Lessons.Lesson8.Participants.Robot;

public class Main {

    public static void main(String[] args) {
        Obstacle[] obstacles = {
                new Wall(10),
                new Wall(15),
                new Treadmill(200),
                new Treadmill(300),
        };

        Participant[] participants = {
                new Human("David", 2000, 5),
                new Cat("Max", 200, 10),
                new Robot("Alfa1", 3000, 25)
        };

        for (Participant participant : participants) {
                for (Obstacle obstacle : obstacles) {
                    participant.overcomeObstacle(obstacle);
                    if(participant.isFail()){
                        break;
                }
            }
        }
    }

}
