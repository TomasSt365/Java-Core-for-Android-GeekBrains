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
        printShiftArrayElementsByN(arr7,2);//Метод не реализовал(работает только с некоторыми значениями)
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

   public static void printShiftArrayElementsByN(int[] arr,int n){
        int memoryСell;
        if(n%2 == 1 && arr.length%2 == 1) {
            for (int i = 0; i < n; i++) {
                memoryСell = arr[i];
                arr[i] = arr[arr.length - n + i];
                arr[arr.length - n + i] = memoryСell;
            }
           memoryСell = arr[arr.length - 1];
           arr[arr.length - 1] = arr[arr.length - 2];
           arr[arr.length - 2] = memoryСell;
        }
        else
            for (int i = 0; i < n; i++) {
                memoryСell = arr[i];
                arr[i] = arr[arr.length - n + i];
                arr[arr.length - n + i] = memoryСell;
            }

       for (int i = 0; i < arr.length; i++) {
           System.out.println(arr[i]);
       }
   }
}

