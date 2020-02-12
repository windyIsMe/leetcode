package p64;

import model.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minPathSum1(int[][] grid) {
        return minSum(grid.length - 1, grid[0].length - 1, grid);
    }

    public int minSum(int m, int n, int[][] grid) {
        int sum = grid[0][0];
        if (m == 0) {
            for (int i = 1; i <= n; i++) {
                sum += grid[0][i];
            }
            return sum;
        }
        if (n == 0) {
            for (int i = 1; i <= m; i++) {
                sum += grid[i][0];
            }
            return sum;
        }
        return Math.min(minSum(m, n - 1, grid) + grid[m][n], minSum(m - 1, n, grid) + grid[m][n]);
    }

    public int minPathSum(int[][] grid)
    {
        int row = grid.length;
        int col = grid[0].length;
        List<List<Integer>> min_sum = new ArrayList<List<Integer>>();
        List<Integer> first_line = new ArrayList<Integer>();
        first_line.add(grid[0][0]);

        for (int i = 1; i < col; i++)
        {
            int temp = first_line.get(i - 1) + grid[0][i];
            first_line.add(temp);
        }
        min_sum.add(first_line);

        for (int i = 1; i < row; i++)
        {
            List<Integer> new_line = new ArrayList<>();
            new_line.add(min_sum.get(i - 1).get(0) + grid[i][0]);
            for (int j = 1; j < col; j++)
            {
                int temp = Math.min(new_line.get(j - 1), min_sum.get(i - 1).get(j)) + grid[i][j];
                new_line.add(temp);
            }
            min_sum.add(new_line);
        }

        return min_sum.get(row - 1).get(col - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
