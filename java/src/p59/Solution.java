package p59;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        for (int layer = 0; layer < n / 2; layer++) {
            for (int i = layer; i < n - layer; i++) {
                matrix[layer][i] = num;
                num++;
            }
            for (int i = layer + 1; i < n - 1 - layer; i++) {
                matrix[i][n - 1 - layer] = num;
                num++;
            }
            for (int i = n - 1 - layer; i >= layer; i--) {
                matrix[n - 1 - layer][i] = num;
                num++;
            }
            for (int i = n - 2 - layer; i >= layer + 1; i--) {
                matrix[i][layer] = num;
                num++;
            }
        }
        if (num == n * n) {
            matrix[n / 2][n / 2] = num;
        }
        return matrix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = solution.generateMatrix(2);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
