package Lessons.Lesson8;

public class Main {

    public static void main(String[] args) {
//        Obstacle[] obstacleArr = {new Wall(10),
//                                    new Wall(15),
//                                    new Treadmill(200),
//                                    new Treadmill(300),
//                                    };

        Wall wall = new Wall(3);
        Treadmill treadmill = new Treadmill(1000);

        Human participant1 = new Human("David", 2000,5);
        Cat participant2 = new Cat("Max",200,10);
        Robot participant3 = new Robot("Alfa1",3000,25);


        participant1.jump(wall);
        participant1.run(treadmill);
        participant2.jump(wall);
        participant2.run(treadmill);
        participant3.run(treadmill);
        participant3.jump(wall);
    }

}
