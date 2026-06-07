class Solution {
    private long  minCoins(int idx,long[][]dp,int[]coins,int amount){
        if(idx==coins.length ){
            if(amount==0) return 0;//no more coins needed;
            else return Integer.MAX_VALUE;// not avalid combination
        }

        if(dp[idx][amount]!=-1) return dp[idx][amount];
        long skip=minCoins(idx+1,dp,coins,amount);
        if(amount-coins[idx]<0)return dp[idx][amount]=skip;
        long take=1+minCoins(idx,dp,coins,amount-coins[idx]);

        return dp[idx][amount]=Math.min(skip,take);
    }
    public int coinChange(int[] coins, int amount) {
        // if(amount==0) return 0;
        long[][] dp=new long[coins.length][amount+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        int ans=(int)minCoins(0,dp,coins,amount);
        return (ans==Integer.MAX_VALUE)? -1 : ans;
    }
}