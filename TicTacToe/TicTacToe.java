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
        //looking at 3inrows that go through center
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (j != 1 && i != 1 && board[i][j] == board[2 - i][2 - j] && board[i][j] == board[1][1]) {
                    return board[1][1];
                }
            }
        }
        //checks 3inrows that go through corners but no the centers
        if ((board[0][0] == board[0][1] && board[0][0] == board[0][2]) ||
            (board[0][0] == board[1][0] && board[0][0] == board[2][0])) {
            return board[0][0];
        }
        if ((board[2][2] == board[1][2] && board[2][2] == board[0][2]) ||
            (board[2][2] == board[2][1] && board[2][2] == board[2][0])) {
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
        
    }
}
