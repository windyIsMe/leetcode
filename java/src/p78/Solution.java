package p78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(result, subset, nums, 0);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> subset, int[] nums, int i) {
        if (i == nums.length) {
            result.add(new ArrayList<>(subset));
        } else {
            dfs(result, subset, nums, i + 1);
            subset.add(nums[i]);
            dfs(result, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }
}
