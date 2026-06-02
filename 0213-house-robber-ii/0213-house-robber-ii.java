class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2)return Math.max(nums[1],nums[0]);

        return Math.max(robLinear(nums,1,n-1),robLinear(nums,0,n-2));
    }

    int robLinear(int[] nums,int start,int end){
        int prev=0;
        int curr=0;

        for(int i=start;i<=end;i++){
            int temp=Math.max(curr,prev+nums[i]);
            prev=curr;
            curr=temp;
            
        }
        return curr;
    }
}