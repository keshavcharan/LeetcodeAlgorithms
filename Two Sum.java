// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] out = new int[2];
        Map<Integer, Integer> numsmap = new HashMap<Integer, Integer>(); 
        for(int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if(numsmap.containsKey(other)) {               
                out[0] = i;
                out[1] = numsmap.get(other);
                return out;
            }
            numsmap.put(nums[i], i);            
        }
        return out;
    }
}