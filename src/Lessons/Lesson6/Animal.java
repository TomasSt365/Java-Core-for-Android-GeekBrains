package Lessons.Lesson6;

public class Animal {
    private static int animalNumber = 0;
    private final String name;
    private int limitSwimMeters;
    private int limitRunMeters;

    public Animal(String name) {
        this.name = name;
        animalNumber++;
    }

    public void run(int meters) {
        if (limitRunMeters == 0)
            System.out.println(name + " cannot run");
        else if (meters > limitRunMeters) {
            System.out.println(name + " run " + limitRunMeters + " meters");
        } else
            System.out.println(name + " run " + meters + " meters");
    }

    public void swim(int meters) {
        if (meters > limitSwimMeters)
            System.out.println(name + " swim " + limitSwimMeters + " meters");
        else
            System.out.println(name + " swim " + meters + " meters");
    }

    public static void printAnimalNumber() {
        System.out.println("Number of animals: " + animalNumber);
    }

    public void setLimitSwimMeters(int limitSwimMeters) {
        this.limitSwimMeters = limitSwimMeters;
    }

    public void setLimitRunMeters(int limitRunMeters) {
        this.limitRunMeters = limitRunMeters;
    }

    public String getName() {
        return name;
    }
}

