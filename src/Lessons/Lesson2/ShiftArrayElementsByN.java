package Lessons.Lesson2;

public class ShiftArrayElementsByN {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        shiftArrayElementsByN(arr, 2);
        printArr(arr);
    }

    public static void printArr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.print("]");
    }

    public static void shiftArrayElementsByOneRight(int[] arr) {
        int memoryCell = arr[arr.length - 1];
        //записываем последний элемент в память, т. к. он перезапишеться, а его значение ещё понадобится

        int currentCell = arr[0];
        //Сдвиг влево, поэтому первый текущий элемент это нулевой в массиве(идём по нему слева направо)
        for (int i = 0; i < arr.length - 1; i++) {
            int nextCell = arr[i + 1];//сохраняем следущую ящейку справа в память
            arr[i + 1] = currentCell;//перезаписываем эту яцейку значением текущей
            currentCell = nextCell;//переходим к следущей ячейке
        }

        arr[0] = memoryCell;
        //Т. к. у нас цикл, то мы должны последний элемент записать в нулевой(достаём из памяти)
    }

    public static void shiftArrayElementsByOneLeft(int[] arr) {
        int memoryCell = arr[0];
        //записываем нулевой элемент в память, т. к. он перезапишеться, а его значение ещё понадобится

        int currentCell = arr[arr.length - 1];
        //Сдвиг влево, поэтому первый текущий элемент это последний в массиве(идём по нему справа налево)
        for (int i = arr.length - 1; i > 0; i--) {
            int nextCell = arr[i - 1];//сохраняем следущую ящейку слева в память
            arr[i - 1] = currentCell;//перезаписываем эту яцейку значением текущей
            currentCell = nextCell;//переходим к следущей ячейке
        }

        arr[arr.length - 1] = memoryCell;
        //Т. к. у нас цикл, то мы должны нулевой элемент записать в полледний(достаём из памяти)
    }

    public static void shiftArrayElementsByN(int[] arr, int n) {
        for (int i = 0; i < Math.abs(n); i++) {//повторяем сдвиг на 1 указанное количество раз
            if (n > 0) {//по условию если n отрицательное, то сдвигаем влево
                shiftArrayElementsByOneRight(arr);
            } else {
                shiftArrayElementsByOneLeft(arr);
            }
        }
    }
}
