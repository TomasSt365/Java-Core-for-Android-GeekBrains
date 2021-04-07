package Lessons.Lesson6;

public  class Cat extends Animal {
    private static int catNumber = 0;
    public Cat(String name, int age, String color) {
        super(name, age, color);
        limitRunMeters = 200;
        limitSwimMeters = 0;
        catNumber++;
    }
    public Cat(String name, String color) {
        super(name, color);
        limitRunMeters = 200;
        limitSwimMeters = 0;
        catNumber++;
    }
    public Cat(String color) {
        super(color);
        limitRunMeters = 200;
        limitSwimMeters = 0;
        catNumber++;
    }

    public static void printCatNumber() {
        System.out.println("number of cats: " + catNumber);
    }

    public static void setCatNumber(int catNumber) {
        Cat.catNumber = catNumber;
    }

    public static int getCatNumber() {
        return catNumber;
    }
}
