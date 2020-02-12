package p17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    String digits = "";
    int len = 0;
    List<String> result = new ArrayList<>();
    String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        len = digits.length();
        if (len == 0) {
            return result;
        }
        this.digits = digits;
        backtrack("", 0);
        return result;
    }

    public void backtrack(String combination, int index) {
        if (index >= len) {
            result.add(combination);
        } else {
            String letter = letters[Character.getNumericValue(digits.charAt(index)) - 2];
            for (int i = 0; i < letter.length(); i++) {
                backtrack(combination + letter.charAt(i), index + 1);
            }
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations(""));
    }
}
