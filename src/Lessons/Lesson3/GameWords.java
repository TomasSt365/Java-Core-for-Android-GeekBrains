package Lessons.Lesson3;

import java.util.Random;
import java.util.Scanner;

public class GameWords {
    public static Random rand = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static final int CHARACTERS_OUTPUT_IF_WRONG_ANSWER = 15;

    public static final String[] WORDS = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                                    "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi",
                                    "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
                                    "pineapple", "pumpkin", "potato"};

    public static final String[] WONG_ANSWER_MESSAGES = {"Wrong Answer!","You answer is wrong!"};

    public static final String[] CORRECT_ANSWER_MESSAGES = {"You Win!", "Correct Answer!", "Well Done!"};

    public static void Play(){
        Main.ClearScreen();
        System.out.println("Welcome to the Words\n\nRules: The computer generates a word (fruit)\n" +
                            "       You need to guess this word.\n" +
                            "       The game lasts until the word is guessed\n");

        int continueTheGame;
        do {
            String computerWord = WORDS[rand.nextInt(WORDS.length)];
            char[] computerWordCharArray = computerWord.toCharArray();

            System.out.print("Enter the word:");
            String userWord = scanner.nextLine();
            while (!computerWord.equals(userWord)){
                int guessedSymbolsNumber = 0;
                char[] userWordCharArray = userWord.toCharArray();
                System.out.println(WONG_ANSWER_MESSAGES[rand.nextInt(WONG_ANSWER_MESSAGES.length)]);
                System.out.print("Guessed symbols:");

                if(userWordCharArray.length < computerWordCharArray.length)
                    for (int i = 0; i < userWordCharArray.length; i++) {
                        if (userWordCharArray[i] == computerWordCharArray[i]){
                            System.out.print(userWordCharArray[i]);
                            guessedSymbolsNumber++;
                        }
                    }
                else
                    for (int i = 0; i < computerWordCharArray.length; i++) {
                        if (userWordCharArray[i] == computerWordCharArray[i])
                            System.out.println(userWordCharArray[i]);
                            guessedSymbolsNumber++;
                    }
                for (int i = 0; i < CHARACTERS_OUTPUT_IF_WRONG_ANSWER - guessedSymbolsNumber; i++) {
                    System.out.print("#");
                }

                System.out.print("\nEnter the word:");
                userWord = scanner.nextLine();
            }

            System.out.println(CORRECT_ANSWER_MESSAGES[rand.nextInt(CORRECT_ANSWER_MESSAGES.length)]);

            System.out.print("\nPlay again or return to the launcher?\n" +
                    "(1-Play again,0-Return to the launcher):");
            continueTheGame = scanner.nextInt();
        }while (continueTheGame != 0);

        Main.ClearScreen();
        Main.Launcher();

    }

}
