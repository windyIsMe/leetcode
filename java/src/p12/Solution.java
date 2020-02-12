package p12;

public class Solution {
    public String intToRoman(int num) {
        String result = "";
        int thousand = num / 1000;
        for (int i = 0; i < thousand; i++) {
            result += "M";
        }
        int hundred = num % 1000 / 100;
        if (hundred == 4) {
            result += "CD";
        } else if (hundred == 9) {
            result += "CM";
        } else if (hundred < 4) {
            for (int i = 0; i < hundred; i++) {
                result += "C";
            }
        } else {
            result += "D";
            for (int i = 5; i < hundred; i++) {
                result += "C";
            }
        }
        int ten = num % 100 / 10;
        if (ten == 4) {
            result += "XL";
        } else if (ten == 9) {
            result += "XC";
        } else if (ten < 4) {
            for (int i = 0; i < ten; i++) {
                result += "X";
            }
        } else {
            result += "L";
            for (int i = 5; i < ten; i++) {
                result += "X";
            }
        }
        int single = num % 10;
        if (single == 4) {
            result += "IV";
        } else if (single == 9) {
            result += "IX";
        } else if (single < 4) {
            for (int i = 0; i < single; i++) {
                result += "I";
            }
        } else {
            result += "V";
            for (int i = 5; i < single; i++) {
                result += "I";
            }
        }
        return result;
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(58));
    }
}
