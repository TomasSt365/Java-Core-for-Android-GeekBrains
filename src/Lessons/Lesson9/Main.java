package Lessons.Lesson9;

public class Main {
    public static void main(String[] args) {
        String[][] Arr = {{"5","6","12","11"},{"7","8","5","11"},{"7","10","5","11"},{"11","12","5","11"}};

        try {
            System.out.println(SumArrayElements(Arr));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

    }

    public static int SumArrayElements(String[][] elements) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        if(elements.length !=  4){
            throw new MyArraySizeException("Wrong field size!");
        }

        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                try{
                    sum += Integer.parseInt(elements[i][j]);
                }catch (NumberFormatException e1){
                    throw new MyArrayDataException("element[" + i + "][" + j + "] is not number");
                }
            }
        }
        return sum;
    }

}
