class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] out = new int[nums.length];
        left[0] = 1;
        
        for(int i = 1; i < nums.length; ++i) {
            left[i] = left[i-1] * nums[i-1];            
        }
        
        System.out.println(Arrays.toString(left));
        
        int mul = 1;
        for(int i = nums.length-2; i >= 0; --i) {
            mul *= nums[i+1];
            out[i] = mul * left[i];
        }
        out[nums.length-1] = left[nums.length-1];
        
        return out;
    }
}