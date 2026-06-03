class Solution {
    public int uniquePaths(int m, int n) {
        if(m<1 || n<1) return 0;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return findPath(dp,0,0,m,n);
        // return dp[m][n];
    }

    int findPath(int[][] dp,int rs,int cs, int m,int n){
        if(rs>= m|| cs>=n) return 0 ;
        if(rs==m-1 || cs==n-1) return 1;
        if(dp[rs][cs]!=-1) return dp[rs][cs];
        return dp[rs][cs]=findPath(dp,rs+1,cs,m,n) + findPath(dp,rs,cs+1,m,n);
    }
}