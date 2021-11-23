// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//Notice that the solution set must not contain duplicate triplets

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> out = new ArrayList<>();
        for(int i = 0; i < nums.length-2; i++) {
            int j = i+1;
            int k = nums.length-1;
            if(i == 0 || nums[i-1] != nums[i])
            out.addAll(twoSum(nums, i, j, k));
        }
        return out;
    }
    
    public List<List<Integer>> twoSum(int[] nums, int i, int j, int k) {
        List<List<Integer>> out = new ArrayList<>();
        while(k > j) {
            int other = 0 -nums[i];
            int kjsum = nums[k] + nums[j];           
            if(kjsum == other) {
                List<Integer> sum = new ArrayList<>();
                sum.add(nums[i]);
                sum.add(nums[j]);
                sum.add(nums[k]);
                out.add(sum);
                ++j;
                while (j < k && nums[j] == nums[j - 1])
                ++j;
            } else if(kjsum > other) {
                --k;
            } else if(kjsum < other) {
                ++j;
            }
        }
        return out;
    }
}