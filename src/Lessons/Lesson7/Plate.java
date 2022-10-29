package Lessons.Lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int food) {
        if(this.food >= food){
            this.food -= food;
        }else {
            System.out.println("there is not enough food on the plate");
        }
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
