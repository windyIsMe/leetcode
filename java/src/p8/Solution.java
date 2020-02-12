package p8;

public class Solution {
    public int myAtoi(String str) {
        long number = 0;
        boolean isPositive = true;
        int i = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                continue;
            } else if (str.charAt(i) == '+') {
                break;
            } else if (str.charAt(i) == '-') {
                isPositive = false;
                break;
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                number = str.charAt(i) - '0';
                break;
            } else {
                return 0;
            }
        }
        while (i < str.length() && number <= Integer.MAX_VALUE){

        }
        return 0;
    }

    public static void main(String args[]) {
        long a = 2147483647;
        String s = "4293587";
        System.out.println(s.charAt(6));
    }
}
