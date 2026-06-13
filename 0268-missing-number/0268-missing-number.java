class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int pt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=pt){
               return pt;
            }
            pt++;
        }
        return n;
    }
}