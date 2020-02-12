package p63;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] paths = new int[n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] != 1) {
                paths[i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                paths[0] = 0;
            }
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    paths[j] += paths[j - 1];
                } else {
                    paths[j] = 0;
                }
            }
        }
        return paths[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}
