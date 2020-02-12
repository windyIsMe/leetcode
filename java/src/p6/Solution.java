package p6;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String[] rows = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = "";
        }
        for (int i = 0; i < s.length(); i++) {
            int div = numRows*2-2;
            int index = Math.min(i%div, div-i%div);
            rows[index] += s.charAt(i);
        }
        String result = "";
        for (int i = 0; i < numRows; i++) {
            result += rows[i];
        }
        return result;
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 4));
    }
}
