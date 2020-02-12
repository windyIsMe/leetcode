package p34;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums.length == 0) {
            return result;
        }
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            result[0] = left;
        }
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left > 0 && nums[left-1] == target) {
            result[1] = left - 1;
        }
        if (nums[left] == target) {
            result[1] = left;
        }
        return result;
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] nums = {5,7,7,8,8,10};
        int[] result = solution.searchRange(nums, 6);
        System.out.println(Arrays.toString(result));
    }
}
