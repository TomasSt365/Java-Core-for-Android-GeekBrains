package Lessons.Lesson6;

public class Dog extends Animal{
    private static int dogNumber = 0;
    public Dog(String name) {
        super(name);
        setLimitRunMeters(500);
        setLimitSwimMeters(10);
        dogNumber++;
    }

    public static void printDogNumber() {
        System.out.println("Number of dogs: " + dogNumber);
    }

}
