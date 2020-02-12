package p77;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        combineNext(result, combination, 1, n, k);
        return result;
    }

    public void combineNext(List<List<Integer>> result, List<Integer> combination, int next, int n, int k) {
        if (combination.size() == k) {
            result.add(new ArrayList<>(combination));
        } else {
            for (int i = next; i <= n; i++) {
                combination.add(i);
                combineNext(result, combination, i + 1, n, k);
                combination.remove(combination.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(5, 3));
    }
}
