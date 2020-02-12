package p62;

public class Solution {
    public int uniquePaths(int m, int n) {
        return count(m - 1, n - 1);
    }

    public int uniquePaths2(int m, int n) {
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            nums[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            nums[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
            }
        }
        return nums[m - 1][n - 1];
    }

    public int uniquePaths3(int m, int n) {
        int[] cur = new int[n];
        for (int i = 0; i < n; i++) {
            cur[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }

    public int count(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        } else {
            return count(m - 1, n) + count(m, n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths3(7, 3));
    }
}
