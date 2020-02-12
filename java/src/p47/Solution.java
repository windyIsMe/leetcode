package p47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
                if (isUsed[i]) {
                    continue;
                }
                if (i > 0 && nums[i - 1] == nums[i] && !isUsed[i - 1]) {
                    continue;
                }
                isUsed[i] = true;
                numList.add(nums[i]);
                backtrack(result, numList, nums, isUsed);
                isUsed[i] = false;
                numList.remove(numList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 1};
        System.out.println(solution.permuteUnique(nums));
    }
}
