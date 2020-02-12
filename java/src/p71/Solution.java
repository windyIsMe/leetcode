package p71;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        int i = 0, j = 1;
        while (i < path.length() - 1) {
            while (j < path.length() && path.charAt(j) != '/') {
                j++;
            }
            if (path.substring(i + 1, j).equals("..")) {
                if (!st.empty()) {
                    st.pop();
                }
            } else if (j != i + 1 && !path.substring(i + 1, j).equals(".")) {
                st.push(path.substring(i, j));
            }
            i = j;
            j++;
        }
        if (st.empty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!st.empty()) {
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/a//b////c/d//././/.."));
    }
}
