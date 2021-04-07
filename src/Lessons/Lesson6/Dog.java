package Lessons.Lesson6;

public class Dog extends Animal{
    private static int dogNumber = 0;
    public Dog(String name, int age, String color) {
        super(name, age, color);
        limitRunMeters = 500;
        limitSwimMeters = 10;
        dogNumber++;
    }
    public Dog(String name, String color) {
        super(name, color);
        limitRunMeters = 500;
        limitSwimMeters = 10;
        dogNumber++;
    }
    public Dog(String color) {
        super(color);
        limitRunMeters = 500;
        limitSwimMeters = 10;
        dogNumber++;
    }

    public static void printDogNumber() {
        System.out.println("Number of dogs: " + dogNumber);
    }

}
