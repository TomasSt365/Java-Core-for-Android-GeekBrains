package Lessons.Lesson6;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("Jake");
        Animal cat = new Cat("Felix");
        Dog dogSecond = new Dog("Max");
        Cat catSecond = new Cat("Teressa");
        Animal dogThird = new Dog("King");

        dog.run(100);
        dogSecond.run(1000);
        dogThird.swim(5);
        dog.swim(20);

        cat.run(150);
        catSecond.run(500);
        cat.swim(30);


        Cat.printCatNumber();
        Dog.printDogNumber();
        Animal.printAnimalNumber();
    }
}
