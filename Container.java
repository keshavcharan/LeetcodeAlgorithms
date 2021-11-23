// Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
// n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
// Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

class Container {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxarea = 0;
        while(j > i) {
            maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j-i));
            if(height[i] < height[j])   ++i;
            else        --j;                        
        }
        return maxarea;
    }
}