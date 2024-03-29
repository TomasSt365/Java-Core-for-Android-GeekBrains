package Lessons.Lesson2;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] == 0)
                arr1[i] = 1;
            else
                arr1[i] = 0;
        }

        int[] arr2 = new int[8];
        int arrNumber = 0;
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arrNumber;
            arrNumber += 3;
        }

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++)
           if(arr3[i] < 6)
               arr3[i] *= 2;

        int[][] arr4 = new int[6][6];
        int arrayСolumnIndexStart = 0, arrayСolumnIndexEnd = 5;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(j == arrayСolumnIndexStart || j == arrayСolumnIndexEnd)
                    arr4[i][j] = 1;
                System.out.print(arr4[i][j]+" ");
            }
            arrayСolumnIndexStart++;
            arrayСolumnIndexEnd--;
            System.out.println();
        }

        int [] arr5 = {23,443,45,12,234,43,458,45,23};
        int max = arr5[0], min = arr5[0];
        for (int i = 0; i < arr5.length; i++) {
            if(arr5[i] > max)
                max = arr5[i];
            if(arr5[i] < min)
                min = arr5[i];
        }

        int[] arr6 = {1,2,3};
        System.out.println(checkBalance(arr6));

        int[] arr7 = {3, 1, 6, 5};
        shiftArrayElementsByN(arr7,2);
        printArr(arr7);
    }
   public static boolean checkBalance(int [] arr){
        if(arr.length == 1)
            return true;
        else {
            int arrIndexStart = 0, arrIndexEnd = arr.length-1, sumLeft = arr[arrIndexStart], sumRigth = arr[arrIndexEnd], unUsedArrayElements = arr.length-2;
            while (unUsedArrayElements != 0) {
                if(sumLeft > sumRigth) {
                    arrIndexEnd--;
                    sumRigth += arr[arrIndexEnd];
                    unUsedArrayElements--;
                }
                else{
                    arrIndexStart++;
                    sumLeft += arr[arrIndexStart];
                    unUsedArrayElements--;
                }
            }
            if(sumLeft == sumRigth)
                return true;
            else
                return false;
        }
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

}

