class Solution {
    private long Score(int idx,int lastParity,Integer x,long[][]dp,int[] nums){
        if(idx==nums.length) return 0;
        if(dp[idx][lastParity]!=-1) return dp[idx][lastParity];
        
        long skip=Score(idx+1,lastParity,x,dp,nums);
        int currentParity=nums[idx]%2;
        long panelty=(currentParity!=lastParity)?x:0;
        long pick= nums[idx]-panelty+Score(idx+1,currentParity,x,dp,nums);
        
        return dp[idx][lastParity]=Math.max(skip,pick);
    }
    public long maxScore(int[] nums, int x) {
        
        int n=nums.length;
        if(n==1) return nums[0];
        long[][] dp=new long[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
       
        return nums[0]+Score(1,nums[0]%2,x,dp,nums);
    }
}