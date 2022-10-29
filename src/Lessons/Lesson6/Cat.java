package Lessons.Lesson6;

public  class Cat extends Animal {
    private static int catNumber = 0;
    public Cat(String name) {
        super(name);
        setLimitRunMeters(200);
        catNumber++;
    }

    public static void printCatNumber() {
        System.out.println("number of cats: " + catNumber);
    }

    @Override
    public void swim(int meters) {
        System.out.println(getName() + " cannot swim");
    }

}
