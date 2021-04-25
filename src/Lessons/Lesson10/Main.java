package Lessons.Lesson10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> ListArr = new ArrayList<>(Arrays.asList
                ("1","2","3","10","23","23","12","43","12","2"));
        /**
         * I used ArrayList because
         * I don't need to constantly change my list, but only get elements from it
         */

        PrintUniqueElements(ListArr);
        PrintElementsAndTheirNumber(ListArr);

    }

    public static void PrintUniqueElements(List<String> list){
        for (String element : list) {
            if(getNumberOfEqualsElementsOfList(element, list) == 1){
                System.out.println(element);
            }
        }
    }

    public static void PrintElementsAndTheirNumber(List<String> list){
        for (String element : list){
            System.out.println("(Element;Number): (" + element + ";" +
                    getNumberOfEqualsElementsOfList(element, list) + ")");
        }
    }

    public static int getNumberOfEqualsElementsOfList
            (String checkedElement, List<String> list) {

        int NumberOfEqualsElements = 0;

        for (String element : list){

            if(element.equals(checkedElement)){
                NumberOfEqualsElements++;
            }

        }
        return NumberOfEqualsElements;
    }
}


