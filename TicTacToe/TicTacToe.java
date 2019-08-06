public class TicTacToe {
    public static void printBoard(int[][] board) {
        String ans = "";
        for (int i = 0; i < board.length; i++) {
            String line = "";
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
            line += "--|--|--\n";
            ans += line;
        }
        /* prints out
        XX|XX|XX
        --|--|--
        XX|XX|XX
        --|--|--
        XX|XX|XX
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
        int winner = 0;
        return winner;
    }

    public static void main(String[] args) {
        int[][] board = new int[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
            }
        }
    }
}
