package p5;

public class Solution {
    public String longestPalindrome(String s) {
        int count = 0;
        if (s.length() == 0) {
            return "";
        }
        String longestStr = s.substring(0,1);
        for (int start = 0; start < s.length()-1; start++) {
            for (int end = start+1; end < s.length(); end++) {
                boolean isPalindromic = true;
                int i = start;
                int j = end;
                while (i < j) {
                    count++;
                    if (s.charAt(i) != s.charAt(j)) {
                        isPalindromic = false;
                        break;
                    }
                    i++;
                    j--;
                }
                if (isPalindromic && s.substring(start,end+1).length() > longestStr.length()) {
                    longestStr = s.substring(start,end+1);
                }
            }
        }
        System.out.println(count);
        return longestStr;
    }

    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int begin = 0;
        int end = 0;
        for (int i = 1; i < s.length()-1; i++) {
            int left = i-1;
            int right = i+1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (right-left-1 > end-begin+1) {
                begin = left+1;
                end = right-1;
            }
        }
        for (int i = 0; i < s.length()-1; i++) {
            int left = i;
            int right = i+1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (right-left-1 > end-begin+1) {
                begin = left+1;
                end = right-1;
            }
        }
        return s.substring(begin, end+1);
    }

    int maxLen = 1;
    int start = 0;
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        for (int i = 0; i < s.length()-1; i++) {
            expandPalindrome(s, i, i);
            expandPalindrome(s, i, i+1);
        }
        return s.substring(start, start+maxLen);
    }

    public void expandPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (right-left-1 > maxLen) {
            start = left+1;
            maxLen = right-left-1;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        String str = solution.longestPalindrome2(null);
        System.out.println(str);
    }
}















