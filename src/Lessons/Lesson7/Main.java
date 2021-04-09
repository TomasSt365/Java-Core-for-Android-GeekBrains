package Lessons.Lesson7;

public class Main {

    public static void main(String[] args) {

        Cat[] catsArr = {new Cat("Barsik",6),
                    new Cat("Maks",15),
                    new Cat("Graph",12),
                    new Cat("Myrchik",16),
                    new Cat("Myrlyka",11),
                    new Cat("Kisa",15)};

        Plate plate = new Plate(50);

        Cat.feedCatsFromOnePlate(catsArr, plate);
        Cat.printCatsSatietyInfo(catsArr);
        plate.printInfo();

        plate.addFood(25);
        Cat.feedCatsFromOnePlate(catsArr, plate);
        Cat.printCatsSatietyInfo(catsArr);
        plate.printInfo();
    }

}
