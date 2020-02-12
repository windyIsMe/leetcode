package p33;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] < nums[right]) {
                break;
            }
            int mid = (left + right) / 2;
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int min = left;
        if (min == 0) {
            left = 0;
            right = nums.length - 1;
        } else if (target >= nums[0]) {
            left = 0;
            right = min - 1;
        } else {
            left = min;
            right = nums.length - 1;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] nums = {3,0};
        int result = solution.search(nums, 3);
        System.out.println(result);
    }
}
