package p29;

public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isNeg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        long dvd = Math.abs((long)dividend), dvs = Math.abs((long)divisor), result = 0;
        while (dvd >= dvs) {
            long temp = dvs, m = 1;
            while (temp << 1 <= dvd) {
                temp <<= 1;
                m <<= 1;
            }
            dvd -= temp;
            result += m;
        }
        if (isNeg) {
            result = -result;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
