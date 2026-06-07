class Solution {
    static int sum;
    private int countWays(int idx,int[][]dp,int[] nums,int res,int target){
        if(idx==nums.length){
            if(target==res) return 1;
            else return 0 ;
        }
        if(dp[idx][res+sum]!=-1) return dp[idx][res+sum];

        int sub=countWays(idx+1,dp,nums,res-nums[idx],target);

        int add=countWays(idx+1,dp,nums,res+nums[idx],target);
        
        return dp[idx][res+sum]=sub+add;
    }
    public int findTargetSumWays(int[] nums, int target) {
        sum=0;
        for(int ele: nums){
            sum+=ele;
        }
        if(target>sum) return 0;

        int[][] dp=new int[nums.length][(2*sum)+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }

        return countWays(0,dp,nums,0,target);
    }
}