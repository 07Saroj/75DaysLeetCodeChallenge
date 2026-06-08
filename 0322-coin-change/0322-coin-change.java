class Solution {
    
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        long[][] dp=new long[coins.length][amount+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                // long res=(j==0)? 0: Integer.MAX_VALUE;

                long skip=(i>0)? dp[i-1][j]:((j==0)? 0: Integer.MAX_VALUE);
                if(j-coins[i]<0) dp[i][j]=skip;
                else{
                    long pick=1+dp[i][j-coins[i]];
                    dp[i][j]=Math.min(pick,skip);
                }
            }
        }
        int ans=(int)dp[coins.length-1][amount];
        return (ans==Integer.MAX_VALUE)? -1 : ans;

        // if(amount==0) return 0;
        // long[][] dp=new long[coins.length][amount+1];
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // int ans=(int)minCoins(0,dp,coins,amount);
        // return (ans==Integer.MAX_VALUE)? -1 : ans;
    }

    // private long  minCoins(int idx,long[][]dp,int[]coins,int amount){
    //     if(idx==coins.length ){
    //         if(amount==0) return 0;//no more coins needed;
    //         else return Integer.MAX_VALUE;// not a valid combination
    //     }

    //     if(dp[idx][amount]!=-1) return dp[idx][amount];
    //     long skip=minCoins(idx+1,dp,coins,amount);
    //     if(amount-coins[idx]<0)return dp[idx][amount]=skip;
    //     long take=1+minCoins(idx,dp,coins,amount-coins[idx]);

    //     return dp[idx][amount]=Math.min(skip,take);
    // }
}