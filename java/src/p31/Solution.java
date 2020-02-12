package p31;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            for (int j = len - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    break;
                }
            }
        }
        reverse(nums, i + 1, len - 1);
    }

    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int nums[], int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] nums = {1,1,5};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}



















