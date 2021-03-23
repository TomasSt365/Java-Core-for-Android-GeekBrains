package Lessons.Lesson1;

public class Lesson1 {
    //Метод 1
    public static float method1(float a, float b, float c, float d){
        return a * (b + (c / d));
    }

    //Метод 2
    public static boolean method2(int number1, int number2){
        return (number1 + number2) > 10 && (number1 + number2) <= 20;
    }

    //Метод 3
    public static void negativeOrPositiveConsole(int number){
        if(number>=0)
            System.out.println("The number is positive");
        else
            System.out.println("The number is negative");
    }

    //Метод 4
    public static boolean negativeOrPositive(int number){
        return number <= 0;
    }

    //Метод 5
    public static void sayHello(String name){
        System.out.println("Hello, " + name);
    }
    //Метод 6
    public static void leapYear(int year){
        if (year % 4 == 0) {
            if (year % 100 == 0 && year % 400 != 0)
                System.out.println("The year is a not leap year");
            else
                System.out.println("The year is a leap year");
        }
        else System.out.println("The year is a not leap year");
    }

    public static void main(String[] args) {

        //создание и инициализация переменных
        int intVar = 123;
        double doubleVar = 3.4;
        char charVar = 'd';
        String stringVar = "Hello";
        boolean boolVar = true;

        //Проверка методов на выполнение
        System.out.println(method1(12.3f,12.4f,3.5f,4.5f)); //Проверка метода 1
        System.out.println(method2(2,9)); //Проверка выполнения метода 2
        negativeOrPositiveConsole(34); //Проверка выполнения метода 3
        System.out.println(negativeOrPositive(-23)); //Проверка метода 4
        sayHello("User"); //Проверка метода 5
        leapYear(400); //Проверка метода 6
    }
}
