package p11;

public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                int tall = Math.min(height[i], height[j]);
                if (tall*(j-i) > max) {
                    max = tall*(j-i);
                }
            }
        }
        return max;
    }

    public int maxArea1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int front = 0;
        int back = height.length-1;
        int maxArea = (back-front)*Math.min(height[front], height[back]);
        while (front < back) {
            if (height[front] < height[back]) {
                int i = front+1;
                for (; i < back; i++) {
                    if (height[i] > height[front]) {
                        int newArea = (back-i)*Math.min(height[i], height[back]);
                        maxArea = newArea > maxArea ? newArea : maxArea;
                        
                        break;
                    }
                }
                front = i;
            } else {
                int j = back-1;
                for (; j > front; j--) {
                    if (height[j] > height[back]) {
                        int newArea = (j-front)*Math.min(height[j], height[front]);
                        maxArea = newArea > maxArea ? newArea : maxArea;
                        break;
                    }
                }
                back = j;
            }
        }
        return maxArea;
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea1(height));
    }
}
