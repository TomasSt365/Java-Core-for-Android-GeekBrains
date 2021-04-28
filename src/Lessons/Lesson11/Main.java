package Lessons.Lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int numberOfApplesInBox1 = 6;
        int numberOfOrangesInBox2 = 4;
        GeneralizedArray<Integer> array = new GeneralizedArray<>(7,2,3,1,4);
        System.out.println(Arrays.toString(array.getArray()));
        array.swapElements(3,1);
        System.out.println(Arrays.toString(array.getArray()));

        List<Apple> appleList1 = new ArrayList<>();
        for (int i = 0; i < numberOfApplesInBox1; i++) {
            appleList1.add(new Apple());
        }
        Box<Apple> box1 = new Box<>(appleList1);

        List<Orange> orangeList1 = new ArrayList<>();
        for (int i = 0; i < numberOfOrangesInBox2; i++) {
            orangeList1.add(new Orange());
        }
        Box<Orange> box2 = new Box<>(orangeList1);

        System.out.println("Weight of Box1: " + box1.getWeight());
        System.out.println("Weight of Box2: " + box2.getWeight());

        System.out.println(box1.compare(box2));

        Box<Apple> box3 = new Box<>();
        box1.PutFruitsInAnotherBox(box3);
        System.out.println("Weight of Box1: " + box1.getWeight());
        System.out.println("Weight of Box3: " + box3.getWeight());
        box1.AddFruit(new Apple(3.0f));
        System.out.println("Weight of Box1: " + box1.getWeight());
    }



}
