package Lessons.Lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        food -= n;
    }
    public void printInfo() {
        System.out.println("plate: " + food);
    }

    public int getFood() {
        return food;
    }

    public void addFood(int addingFood) {
        this.food += addingFood;
    }
}
