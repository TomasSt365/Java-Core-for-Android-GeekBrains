package Lessons.Lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static char[][] map;
    public static final int SIZE_HORIZONTAL = 7;
    public static final int SIZE_VERTICAL = 7;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X, DOTS_TO_WIN)) {
               System.out.println("Human Victory!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw");
                break;
            }
            computerTurn();
            printMap();
            if (checkWin(DOT_O, DOTS_TO_WIN)) {
               System.out.println("Computer Victory!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw");
                break;
            }
        }
        System.out.println("Game Over");

    }

    public static void initMap() {
        map = new char[SIZE_VERTICAL][SIZE_HORIZONTAL];
        for (int i = 0; i < SIZE_VERTICAL; i++) {
            for (int j = 0; j < SIZE_HORIZONTAL; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE_HORIZONTAL; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE_VERTICAL; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE_HORIZONTAL; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isCellNotValid(int x, int y) {
        if (x < 0 || x >= SIZE_HORIZONTAL || y < 0 || y >= SIZE_VERTICAL) return true;
        return map[y][x] != DOT_EMPTY;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Enter the coordinates in (X(Horizontal) ; Y(Vertical)) format");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
            if(isCellNotValid(x, y))
                System.out.println("Error! The coordinates is not valid!");
        } while (isCellNotValid(x, y));
        map[y][x] = DOT_X;
    }

    public static void computerTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE_HORIZONTAL);
            y = rand.nextInt(SIZE_VERTICAL);
        } while (isCellNotValid(x, y));
        System.out.println("The computer put its mark at point (" + (x + 1) + ";" + (y + 1) + ")");
        map[y][x] = DOT_O;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE_VERTICAL; i++) {
            for (int j = 0; j < SIZE_HORIZONTAL; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean checkWin(char symbol, int DOTS_TO_WIN) {

        /*horizontal check*/
        for (int i = 0; i < SIZE_VERTICAL; i++) {
            int symbolsStandingNearby = 0;
            for (int j = 0; j < SIZE_HORIZONTAL; j++) {
                if(map[i][j] == symbol)
                    symbolsStandingNearby++;
                if (symbolsStandingNearby == DOTS_TO_WIN)
                    return true;
            }
        }

        /*vertical check*/
        for (int i = 0; i < SIZE_HORIZONTAL; i++) {
            int symbolsStandingNearby = 0;
            for (int j = 0; j < SIZE_VERTICAL; j++) {
                if(map[j][i]== symbol)
                    symbolsStandingNearby++;
                if (symbolsStandingNearby == DOTS_TO_WIN)
                    return true;
            }
        }

        /*diagonal check(\)*/
        for (int i = 0; i <= SIZE_VERTICAL-DOTS_TO_WIN; i++) {
            for (int j = 0; j <= SIZE_HORIZONTAL-DOTS_TO_WIN; j++) {
                int symbolsStandingNearby = 0;
                for (int x = j, y = i;;x++,y++) {
                    if(y == SIZE_VERTICAL || x == SIZE_HORIZONTAL)
                        break;
                    if(map[x][y] == symbol)
                        symbolsStandingNearby++;
                    if (symbolsStandingNearby == DOTS_TO_WIN)
                        return true;
                }
            }
        }

        /*diagonal check(/)*/
        for (int i = SIZE_HORIZONTAL-1; i >= DOTS_TO_WIN-1 ; i--) {
            for (int j = 0; j <= SIZE_VERTICAL-DOTS_TO_WIN; j++) {
                int symbolsStandingNearby = 0;
                for (int x = j, y = i;; x--,y++) {
                    if(y == SIZE_VERTICAL || x < 0)
                        break;
                    if(map[x][y] == symbol)
                        symbolsStandingNearby++;
                    if (symbolsStandingNearby == DOTS_TO_WIN)
                        return true;
                }
            }
        }

        return false;
    }

}
