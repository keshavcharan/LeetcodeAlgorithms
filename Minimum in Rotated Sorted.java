class Solution {
    public int findMin(int[] nums) {
        int index = binarySearch(nums, 0, nums.length-1);
        return index == -1 ? nums[0] : nums[index];
    }
    
    public int binarySearch(int[] nums, int st, int en) {        
        if(en < st) return -1;
        int mid = (en - st + 1) / 2;
        mid += st;
        if(mid > 0) {
          if(nums[mid] < nums[mid-1]) {
              return mid;
          } else if(en == st) {
              return -1;
          } else if(nums[st] < nums[mid]) {
              return binarySearch(nums, mid, en);
          } else {
              return binarySearch(nums, st, mid);              
          }
        } 
        return -1;
    }
}