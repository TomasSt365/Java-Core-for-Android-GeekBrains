package Lessons.Lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if(p.getFood() >= appetite && !satiety){
            p.decreaseFood(appetite);
            satiety = true;
        }
    }

    public static void printCatsSatietyInfo(Cat[] cats){
        for (Cat cat : cats) {
            cat.printCatSatietyInfo();
        }
    }

    public void printCatSatietyInfo(){
        if(satiety)
            System.out.println(name + " is full");
        else
            System.out.println(name + " is not full");
    }

    public static void feedCatsFromOnePlate (Cat[] cats, Plate plate){
        for (Cat cat : cats) {
            cat.eat(plate);
        }
    }

}
