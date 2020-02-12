package p74;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (matrix[mid / n][mid % n] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return matrix[left / n][left % n] == target;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1, 1}};
        System.out.println(solution.searchMatrix(matrix, 2));
    }
}
