package p46;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        backtrack(result, numList, nums, isUsed);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> numList, int[] nums, boolean[] isUsed) {
        if (numList.size() == nums.length) {
            result.add(new ArrayList<>(numList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!isUsed[i]) {
                    numList.add(nums[i]);
                    isUsed[i] = true;
                    backtrack(result, numList, nums, isUsed);
                    isUsed[i] = false;
                    numList.remove(numList.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(solution.permute(nums));
    }
}
