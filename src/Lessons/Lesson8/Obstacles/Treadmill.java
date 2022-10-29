package Lessons.Lesson8.Obstacles;

public record Treadmill(int length) implements Obstacle {

    @Override
    public ObstacleType getObstacleType() {
        return ObstacleType.Treadmill;
    }
}
