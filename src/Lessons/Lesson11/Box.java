package Lessons.Lesson11;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit>{
    private ArrayList<T> fruitsList;

    public Box(List<T> fruitsList){
        this.fruitsList = (ArrayList<T>) fruitsList;
    }

    public Box(){
        this.fruitsList = new ArrayList<>();
    }

    public float getWeight(){
        float weight = 0.0f;
        for (T fruit : fruitsList) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<? extends Fruit> comparedBox){
        return Math.abs(this.getWeight() - comparedBox.getWeight()) < 0.0001f;
    }

    public void PutFruitsInAnotherBox(Box<T> anotherBox){
        anotherBox.fruitsList.addAll(this.fruitsList);
        this.fruitsList.removeAll(fruitsList.subList(0, this.fruitsList.size()));
    }

    public void AddFruit(T fruit){
        this.fruitsList.add(fruit);
    }

}
