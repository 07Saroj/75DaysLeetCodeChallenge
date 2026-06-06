class Solution {
    private boolean subsetSum(int idx,int[][] dp,int[] nums, int target){
        if(idx==nums.length){
            if(target==0) return true;
            else return false;
        }
        if(dp[idx][target]!=-1) return (dp[idx][target]==-1);
        boolean ans=false;
        boolean skip=subsetSum(idx+1,dp,nums,target);
        if(target-nums[idx]<0) ans=skip;
        else{
            boolean take=subsetSum(idx+1,dp,nums,target-nums[idx]);
            ans=skip || take;
        }
        dp[idx][target]=(ans)?1:0;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int ele: nums) sum+=ele;
        if(sum%2!=0) return false ;
        int target=sum/2;
        int[][] dp=new int[nums.length][target+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        
        
        return subsetSum(0,dp,nums,target);
        
    }
}