package Lessons.Lesson8.Obstacles;

public record Wall(int height) implements Obstacle {
    @Override
    public ObstacleType getObstacleType() {
        return ObstacleType.Wall;
    }
}
