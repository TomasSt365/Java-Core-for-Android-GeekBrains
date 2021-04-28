package Lessons.Lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneralizedArray<T > {
    private T[] array;

    @SafeVarargs
    public GeneralizedArray(T... array){
        this.array = array;
    }

    public void swapElements(int index1, int index2){
        T memoryCell = array[index1];
        array[index1]= array[index2];
        array[index2] = memoryCell;
    }

    public T[] getArray() {
        return array;
    }


    public void ArrayToArrayList(){
       List<T> arrayList = Arrays.asList(array);
       //this.array = arrayList;
        // так делать нельзя, а по условию требуют чтобы массив стал ArrayList
        // Можно только создать 2 поле с ArrayList, но это противоречит условию,
        //Если я его правильно понял
    }
}
