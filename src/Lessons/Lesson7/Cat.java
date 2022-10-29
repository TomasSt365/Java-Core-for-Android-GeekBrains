package Lessons.Lesson7;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        if(!satiety){
            plate.decreaseFood(appetite);
            satiety = true;
        }
    }

    public void printCatSatietyInfo(){
        if(satiety)
            System.out.println(name + " is full");
        else
            System.out.println(name + " is not full");
    }

    public int getAppetite() {
        return appetite;
    }
}
