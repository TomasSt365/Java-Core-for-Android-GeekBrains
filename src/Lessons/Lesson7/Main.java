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

        feedCatsFromOnePlate(catsArr, plate);
        printCatsSatietyInfo(catsArr);
        plate.printInfo();

        plate.addFood(25);
        plate.printInfo();
        feedCatsFromOnePlate(catsArr, plate);
        printCatsSatietyInfo(catsArr);
        plate.printInfo();
    }

    public static void feedCatsFromOnePlate (Cat[] cats, Plate plate){
        for (Cat cat : cats) {
            if(cat.getAppetite() > plate.getFood()){
                cat.eat(plate);
                break;
            }else {
                cat.eat(plate);
            }
        }
    }

    public static void printCatsSatietyInfo(Cat[] cats){
        for (Cat cat : cats) {
            cat.printCatSatietyInfo();
        }
    }
}
