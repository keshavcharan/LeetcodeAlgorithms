class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {            
            if(sum + nums[i] < 0) {
                max = Math.max(nums[i], max);
                sum = 0;
            } else {
                sum += nums[i];            
                max = Math.max(sum, max);                    
            }                                                                             
        }
        return max;
    }
}