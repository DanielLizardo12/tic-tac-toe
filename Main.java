package coffe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        char[][] arrayList = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arrayList[i][j] = ' ';
            }
        }

        printGryd(arrayList);
        boolean xTurn = true;

        while (true) {
            System.out.print("Enter the coordinates: ");
            String coordinates = scanner.nextLine();

            if (!containsNumbersOnly(coordinates)) {
                System.out.println("You should enter numbers!");
            } else {
                int coordinateX = Character.getNumericValue(coordinates.charAt(0));
                int coordinateY = Character.getNumericValue(coordinates.charAt(2));

                if (coordinateY > 3 || coordinateY < 1 || coordinateX > 3 || coordinateX < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    if (arrayList[coordinateX - 1][coordinateY - 1] != 'X' && arrayList[coordinateX - 1][coordinateY - 1] != 'O') {
                        if (xTurn) {
                            arrayList[coordinateX - 1][coordinateY - 1] = 'X';
                        } else {
                            arrayList[coordinateX - 1][coordinateY - 1] = 'O';
                        }
                        printGryd(arrayList);
                        String result = result(arrayList, gameFinished(arrayList));
                        if (!result.equals("")) {
                            System.out.println(result);
                            break;
                        }
                        xTurn = !xTurn;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                }
            }
        }
    }

    public static boolean gameFinished(char[][] arrayList) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arrayList[i][j] == ' ') count++;
            }
        }
        return count == 0;
    }

    public static boolean containsNumbersOnly(String coordinates) {
        char[] chars = coordinates.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : chars){
            if(Character.isDigit(c)){
                sb.append(c);
            }
        }
        return sb.length() == 2 && coordinates.length() == 3;

    }

    public static void printGryd(char[][] arrayList) {
        System.out.println("---------");
        System.out.println("| " + arrayList[0][0] + " " + arrayList[0][1] + " " + arrayList[0][2] + " |");
        System.out.println("| " + arrayList[1][0] + " " + arrayList[1][1] + " " + arrayList[1][2] + " |");
        System.out.println("| " + arrayList[2][0] + " " + arrayList[2][1] + " " + arrayList[2][2] + " |");
        System.out.println("---------");
    }

    public static String result(char[][] arrayList, boolean gameFinished) {
        boolean xWins = false;
        boolean oWins = false;

        if (arrayList[0][0] == 'X' && arrayList[0][1] == 'X' && arrayList[0][2] == 'X') xWins = true;
        if (arrayList[1][0] == 'X' && arrayList[1][1] == 'X' && arrayList[1][2] == 'X') xWins = true;
        if (arrayList[2][0] == 'X' && arrayList[2][1] == 'X' && arrayList[2][2] == 'X') xWins = true;
        if (arrayList[0][0] == 'X' && arrayList[1][0] == 'X' && arrayList[2][0] == 'X') xWins = true;
        if (arrayList[0][1] == 'X' && arrayList[1][1] == 'X' && arrayList[2][1] == 'X') xWins = true;
        if (arrayList[0][2] == 'X' && arrayList[1][2] == 'X' && arrayList[2][2] == 'X') xWins = true;
        if (arrayList[0][0] == 'X' && arrayList[1][1] == 'X' && arrayList[2][2] == 'X') xWins = true;
        if (arrayList[0][2] == 'X' && arrayList[1][1] == 'X' && arrayList[2][0] == 'X') xWins = true;

        if (arrayList[0][0] == 'O' && arrayList[0][1] == 'O' && arrayList[0][2] == 'O') oWins = true;
        if (arrayList[1][0] == 'O' && arrayList[1][1] == 'O' && arrayList[1][2] == 'O') oWins = true;
        if (arrayList[2][0] == 'O' && arrayList[2][1] == 'O' && arrayList[2][2] == 'O') oWins = true;
        if (arrayList[0][0] == 'O' && arrayList[1][0] == 'O' && arrayList[2][0] == 'O') oWins = true;
        if (arrayList[0][1] == 'O' && arrayList[1][1] == 'O' && arrayList[2][1] == 'O') oWins = true;
        if (arrayList[0][2] == 'O' && arrayList[1][2] == 'O' && arrayList[2][2] == 'O') oWins = true;
        if (arrayList[0][0] == 'O' && arrayList[1][1] == 'O' && arrayList[2][2] == 'O') oWins = true;
        if (arrayList[0][2] == 'O' && arrayList[1][1] == 'O' && arrayList[2][0] == 'O') oWins = true;

        return whoWon(xWins, oWins, gameFinished);
    }

    public static String whoWon(boolean xWin, boolean oWin, boolean gameFinished) {
        if (xWin) return "X wins";
        if (oWin) return "O wins";
        if (gameFinished) return "Draw";
        return "";
    }
}