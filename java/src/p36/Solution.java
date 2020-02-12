package p36;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            boolean[] hasNum = new boolean[10];
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else if (!hasNum[Character.getNumericValue(board[i][j])]) {
                    hasNum[Character.getNumericValue(board[i][j])] = true;
                } else {
                    return false;
                }
            }
        }
        for (int j = 0; j < col; j++) {
            boolean[] hasNum = new boolean[10];
            for (int i = 0; i < row; i++) {
                if (board[i][j] == '.') {
                    continue;
                } else if (!hasNum[Character.getNumericValue(board[i][j])]) {
                    hasNum[Character.getNumericValue(board[i][j])] = true;
                } else {
                    return false;
                }
            }
        }
        for (int rowStart = 0; rowStart < 3; rowStart++) {
            for (int colStart = 0; colStart < 3; colStart++) {
                boolean[] hasNum = new boolean[10];
                for (int i = rowStart * 3; i < rowStart * 3 + 3; i++) {
                    for (int j = colStart * 3; j < colStart * 3 + 3; j++) {
                        if (board[i][j] == '.') {
                            continue;
                        } else if (!hasNum[Character.getNumericValue(board[i][j])]) {
                            hasNum[Character.getNumericValue(board[i][j])] = true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        char[][] board = {
          {'5','3','.','.','7','.','.','.','.'},
          {'6','.','.','1','9','5','.','.','.'},
          {'.','5','8','.','.','.','.','6','.'},
          {'8','.','.','5','6','.','.','.','3'},
          {'4','.','.','7','.','3','.','.','1'},
          {'7','.','.','.','2','.','.','.','6'},
          {'.','6','5','.','.','.','2','8','.'},
          {'.','.','.','4','1','9','.','.','5'},
          {'.','.','.','.','8','.','.','7','9'}
        };
        boolean result = solution.isValidSudoku(board);
        System.out.println(result);
    }
}
