package p55;

import java.net.Socket;

public class Solution {
    public boolean canJump(int[] nums) {
        //return canJumpAtPos(0, nums);
        int target = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= target) {
                target = i;
            }
        }
        if (target == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean canJumpAtPos(int pos, int[] nums) {
        if (pos == nums.length - 1) {
            return true;
        }
        int maxPos = pos + nums[pos];
        for (int i = pos + 1; i <= maxPos && i < nums.length; i++) {
            if (canJumpAtPos(i, nums)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{1,0,7}));
    }
}
