package p54;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int row = matrix.length, col = matrix[0].length;
        int up = 0, down = row - 1;
        int left = 0, right = col - 1;
        while (result.size() < row * col) {
            for (int i = left; i <= right && result.size() < row * col; i++) {
                result.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down - 1 && result.size() < row * col; i++) {
                result.add(matrix[i][right]);
            }
            for (int i = right; i >= left && result.size() < row * col; i--) {
                result.add(matrix[down][i]);
            }
            for (int i = down - 1; i >= up + 1 && result.size() < row * col; i--) {
                result.add(matrix[i][left]);
            }
            left++;
            right--;
            up++;
            down--;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(solution.spiralOrder(matrix1));
    }
}
