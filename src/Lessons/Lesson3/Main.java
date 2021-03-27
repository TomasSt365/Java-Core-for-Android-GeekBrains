package Lessons.Lesson3;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static final String[][] GAMES = {{"0","Close Launcher"},
                                            {"1","Numbers"},
                                            {"2","Words"}};
    //since I don't know OOP when adding a new game, I have to add its call to LaunchingTheGame


    public static void main(String[] args) {

        Launcher();

    }

    public static void Launcher(){

        System.out.print("Welcome to the Game Launcher!\n\n" +
                        "Select the game you want to run:\n");

        for (String[] strings : GAMES) {
            for (int j = 0; j < 2/*Two-dimensional array*/; j++) {
                System.out.print(strings[j]);
                System.out.print(")");
            }
            System.out.println();
        }

        System.out.print("Enter the game number:");
        int selectGame = scanner.nextInt();
        while (selectGame > GAMES.length || selectGame < 0){
            System.out.print("\nError! The game doesn't exist!\n" +
                            "Try again:");
            selectGame = scanner.nextInt();
        }

        LaunchingTheGame(selectGame);


    }

    public static void LaunchingTheGame(int game){
        switch (game){
           case (0):
               break;
            case (1):
                GameNumbers.Play();
                break;
            case (2):
                GameWords.Play();
                break;
        }
    }

    public static void ClearScreen(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
