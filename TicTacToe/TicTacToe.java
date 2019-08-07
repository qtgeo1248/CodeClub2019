import java.util.*;

public class TicTacToe {
    public static void printBoard(int[][] board) {
        String ans = "  A  B  C\n";
        for (int i = 0; i < board.length; i++) {
            String line = (i + 1) + " ";
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    line += "  |";
                } else if (board[i][j] == 1) {
                    line += "XX|";
                } else {
                    line += "OO|";
                }
            }
            line = line.substring(0, line.length() - 1) + "\n";
            line += "  --|--|--\n";
            ans += line;
        }
        /* prints out
          A  B  C
        1 XX|XX|XX
          --|--|--
        2 XX|XX|XX
          --|--|--
        3 XX|XX|XX
        */
        System.out.println(ans.substring(0, ans.lastIndexOf("| ") + 1));
    }

    public static boolean add(int[][] board, int i, int j, int id) {
        if (board[i][j] == 0) {
            board[i][j] = id;
            return true;
        } else {
            return false;
        }
    }

    public static int winner(int[][] board) {
        //looking at 3inrows that go through center
        if (board[1][1] != 0 &&
                ((board[1][1] == board[0][0] && board[1][1] == board[2][2]) ||
                (board[1][1] == board[0][1] && board[1][1] == board[2][1]) ||
                (board[1][1] == board[0][2] && board[1][1] == board[2][0]) ||
                (board[1][1] == board[1][2] && board[1][1] == board[1][0]))) {
            return board[1][1];
        }
        //checks 3inrows that go through corners but not the centers
        if (board[0][0] != 0 &&
                ((board[0][0] == board[0][1] && board[0][0] == board[0][2]) ||
                (board[0][0] == board[1][0] && board[0][0] == board[2][0]))) {
            return board[0][0];
        }
        if (board[2][2] != 0 &&
                ((board[2][2] == board[1][2] && board[2][2] == board[0][2]) ||
                (board[2][2] == board[2][1] && board[2][2] == board[2][0]))) {
            return board[2][2];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] board = new int[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
            }
        }
        printBoard(board);
        int player = 1;
        Scanner input = new Scanner(System.in);
        while (winner(board) == 0) {
            System.out.println("Welcome to Tic Tac Toe.\nPress any key to continue");
            String key = input.nextLine();
            System.out.println("Player 1 (X) goes first.\nPick a square:");
            String square = input.nextLine();
            int i = 0; //1, 2, or 3
            int j = 0; //A, B, or C
            boolean isValid = true;
            if (square.contains("A")) {
                j = 0;
            } else if (square.contains("B")) {
                j = 1;
            } else if (square.contains("C")) {
                j = 2;
            } else {
                isValid = false;
                System.out.println("Invalid input. Please try again");
            }
            if (square.contains("1") && isValid) {
                i = 0;
            } else if (square.contains("2") && isValid) {
                i = 1;
            } else if (square.contains("3") && isValid) {
                i = 2;
            } else {
                isValid = false;
                System.out.println("Invalid input. Please try again");
            }
        }
        System.out.println("Congradulations Player " + winner(board) + "!\nYou win!");
    }
}
