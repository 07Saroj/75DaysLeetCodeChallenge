class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;    
        for(int i =1;i<n;i++){
            if (nums[i]==nums[i-1]){ 
                //returns true
                return true;
            }
            
        }
        return false;
    }
}