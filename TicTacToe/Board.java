public class Board {
    private int[][] board;

    public Board() {
        board = new int[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 0;
            }
        }
    }

    public boolean add(int i, int j, int id) {
        if (board[i][j] == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
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
        return ans.substring(0, ans.lastIndexOf("| ") + 1);
    }
}
