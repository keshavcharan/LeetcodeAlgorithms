// Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
// such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
// Given the array nums after the possible rotation and an integer target,
// return the index of target if it is in nums, or -1 if it is not in nums.
class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }
    
    public int binarySearch(int[] nums, int st, int en, int target) {
        if(en < st)    return -1;
        int mid = (en - st + 1) / 2;
        mid += st;
        
        if(mid >= 0 && nums[mid] == target) {
            return mid;
        } 
        
        if(nums[mid] >= nums[st]) {
            if(target < nums[mid] && target >= nums[st]) {
                return binarySearch(nums, st, mid-1, target);
            } else {
                return binarySearch(nums, mid+1, en, target);                
            }
        } else {
            if(target > nums[mid] && target <= nums[en]) {
                return binarySearch(nums, mid+1, en, target);                
            } else {
                return binarySearch(nums, st, mid-1, target);                
            }            
        }        
    }
}