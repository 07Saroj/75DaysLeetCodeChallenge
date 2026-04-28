class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        // Hashtable<Integer, Integer> ht= new Hashtable<>();
        return nums[n/2];
        
    }
}