class Solution {
    private int findDistance(String word1, String word2, int m, int n,int[][] dp){
        if(m==0) return n;
        if(n==0) return m;
        if(dp[m][n]!=-1) return dp[m][n];
        if(word1.charAt(m-1)==word2.charAt(n-1)) return dp[m][n]=findDistance(word1,word2,m-1,n-1,dp);
        else{
            int delete=findDistance(word1,word2,m-1,n, dp);
            int insert=findDistance(word1,word2,m,n-1, dp);
            int replace=findDistance(word1,word2,m-1,n-1,dp);
            return dp[m][n]=1+ Math.min(delete,Math.min(insert,replace));
        }
    }
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return findDistance(word1,word2,m,n,dp);
    }
}