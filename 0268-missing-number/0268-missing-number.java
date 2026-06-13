class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int idealSum=n*(n+1)/2;
        int realSum=0;
        for(int i=0 ;i<n; i++){
            realSum+=nums[i];
        }
        return idealSum-realSum;
        // Arrays.sort(nums);
        // int n=nums.length;
        // int pt=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]!=pt){
        //        return pt;
        //     }
        //     pt++;
        // }
        // return n;
    }
}