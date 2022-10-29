package Lessons.Lesson9;

public class Main {
    public static void main(String[] args) {
        String[][] Arr = {{"5", "6", "12","10"}, {"7", "8", "5","6"}, {"7", "10", "5","4"}, {"11", "12", "5","7"}};

        try {
            System.out.println(SumArrayElements(Arr));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int SumArrayElements(String[][] elements) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        if (elements.length == 4) {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i].length != 4) {
                    throw new MyArraySizeException("Wrong size! Element[" + i + "] don't have 4 elements");
                }
            }
        } else {
            throw new MyArraySizeException("Wrong size! Array length don't have 4 elements");
        }

        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[0].length; j++) {
                try {
                    sum += Integer.parseInt(elements[i][j]);
                } catch (NumberFormatException e1) {
                    throw new MyArrayDataException("element[" + i + "][" + j + "] is not number");
                }
            }
        }
        return sum;
    }

}
