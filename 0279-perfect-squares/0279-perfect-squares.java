class Solution {
    private boolean checkPerfectSquare(int n){
        if(n<0) return false;
        int sqrt=(int)Math.sqrt(n);
        return sqrt*sqrt==n;
    }
    public int numSquares(int n) {
        
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return countSquares(dp,n);
    }

    private int countSquares(int[] dp,int n){
        if(checkPerfectSquare(n)) return 1; 
        if(dp[n]!=-1) return dp[n];//**
        int min =n;
        for(int i=1;i*i<=n;i++){
            int res= countSquares(dp,i*i)+countSquares(dp,n-i*i);
            min=Math.min(res,min);
        }
        return dp[n]=min;
    }
}