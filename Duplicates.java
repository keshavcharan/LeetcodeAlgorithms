// Given an integer array nums, return true if any value appears at least twice in the array,
// and return false if every element is distinct.

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> dup = new HashSet<Integer>();
        for(int i : nums) {
            if(dup.contains(i)) return true;
            dup.add(i);
        }
        return false;
    }
}