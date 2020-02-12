package p3;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int start = 0;
        int current = 1;
        int sum = 1;
        boolean hasRepeat = false;

        while (current < len) {
            hasRepeat = false;
            for (int i = current-1; i >= start; i--) {
                if (s.charAt(current) == s.charAt(i)) {
                    sum = Math.max(sum, current-start);
                    start = i+1;
                    hasRepeat = true;
                    break;
                }
            }
            current++;
        }
        if (!hasRepeat) {
            sum = Math.max(sum, current-start);
        }
        return sum;
    }
}