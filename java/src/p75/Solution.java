package p75;

import java.util.Arrays;

public class Solution {
    public void sortColors(int[] nums) {
        int nextRed = 0;
        int nextBlue = nums.length - 1;
        int i = 0;
        while (i <= nextBlue) {
            if (nums[i] == 0) {
                nums[i] = 1;
                nums[nextRed] = 0;
                i++;
                nextRed++;
            } else if (nums[i] == 2) {
                nums[i] = nums[nextBlue];
                nums[nextBlue] = 2;
                nextBlue--;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        Solution solution = new Solution();
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
