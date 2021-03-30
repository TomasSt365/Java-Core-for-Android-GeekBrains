package Lessons.Lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static char[][] map;
    public static final int SIZE_HORIZONTAL = 3;
    public static final int SIZE_VERTICAL = 3;
    public static final int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
               System.out.println("Human Victory!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw");
                break;
            }
            computerTurn();
            printMap();
            if (checkWin(DOT_O)) {
               System.out.println("Computer Victory!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw");
                break;
            }
        }
        System.out.println("Игра закончена");

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

    public static boolean checkWin(char symbol) {
        if(map[0][0] == symbol && map[0][1] == symbol && map[0][2] == symbol) return true;
        if(map[1][0] == symbol && map[1][1] == symbol && map[1][2] == symbol) return true;
        if(map[2][0] == symbol && map[2][1] == symbol && map[2][2] == symbol) return true;
        if(map[0][0] == symbol && map[1][0] == symbol && map[2][0] == symbol) return true;
        if(map[0][1] == symbol && map[1][1] == symbol && map[2][1] == symbol) return true;
        if(map[0][2] == symbol && map[1][2] == symbol && map[2][2] == symbol) return true;
        if(map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol) return true;
        return map[2][0] == symbol && map[1][1] == symbol && map[0][2] == symbol;
    }
}
