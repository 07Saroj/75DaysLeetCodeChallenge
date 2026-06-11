class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //Space optimized
        int m=text1.length();
        int n=text2.length();
        
        int[][] dp=new int[2][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[1][j]=1+dp[0][j-1];
                }    
                else{
                    dp[1][j]=Math.max(dp[0][j],dp[1][j-1]);
                }
            }
            for(int j=0;j<=n;j++){
                dp[0][j]=dp[1][j];
            }
        }

        return dp[1][n];
        // int m=text1.length();
        // int n=text2.length();
        
        // int[][] dp=new int[m+1][n+1];
        // for(int i=1;i<=m;i++){
        //     for(int j=1;j<=n;j++){
        //         if(text1.charAt(i-1)==text2.charAt(j-1)){
        //             dp[i][j]=1+dp[i-1][j-1];
        //         }    
        //         else{
        //             dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
        //         }
        //     }
        // }

        // return dp[m][n];
    }
}