package Lessons.Lesson3;

import java.util.Random;
import java.util.Scanner;

public class GameNumbers {
    public static Scanner scanner = new Scanner(System.in);
    public static Random rand = new Random();

    public static final int RANGE_LENGTH = 10;
    public static final String[] WIN_MESSAGES = {"You Win!","Well Done!","Good!"};

    public static final String[] USER_NUMBER_IS_BIGGER_MESSAGES = {"Your number is bigger!",
                                                            "The computer generated a number lower..."};

    public static final String[] USER_NUMBER_IS_LOWER_MESSAGES = {"Your number is lower!",
                                                            "The computer generated a number bigger..."};

    public static final String[] GAME_OVER_MESSAGES = {"Game Over!","You lose!"};

    public static void Play() {
        boolean win = false;
        int continueTheGame;
        int userNumber;
        do {
            int userAttempts = 3;
            Main.ClearScreen();
            System.out.println("Welcome to the Numbers\n\n" +
                    "Rules: The computer generates a number between 0 and " + (RANGE_LENGTH-1) + " (inclusive)\n" +
                    "       You have " + userAttempts +" attempts to guess.\n");

            int computerNumber = rand.nextInt(RANGE_LENGTH);

            while (userAttempts > 0){
                System.out.print("Enter the number:");
                userNumber = scanner.nextInt();
                userAttempts--;

                if(userNumber == computerNumber){
                    System.out.print("\n" + WIN_MESSAGES[rand.nextInt(WIN_MESSAGES.length)]);
                    win = true;
                    break;
                }else if (userNumber > computerNumber){
                    System.out.print("\n" + USER_NUMBER_IS_BIGGER_MESSAGES[rand.nextInt(USER_NUMBER_IS_BIGGER_MESSAGES.length)]);
                }else
                    System.out.print("\n"+USER_NUMBER_IS_LOWER_MESSAGES[rand.nextInt(USER_NUMBER_IS_LOWER_MESSAGES.length)]);

                System.out.println("(" +userAttempts + " attempts left)");
            }

            if(!win){
                System.out.println("\n" + GAME_OVER_MESSAGES[rand.nextInt(GAME_OVER_MESSAGES.length)]);
                System.out.println("Computer generated number: " + computerNumber);
            }


            System.out.print("\nPlay again or return to the launcher?\n" +
                            "(1-Play again,0-Return to the launcher):");
            continueTheGame = scanner.nextInt();
        }while (continueTheGame != 0);

        Main.ClearScreen();
        Main.Launcher();
        scanner.close();
    }

}
