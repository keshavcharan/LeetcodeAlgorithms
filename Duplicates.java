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