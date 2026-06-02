class Solution {
    public int tribonacci(int n) {

        if( n == 0 || n == 1) return n;

        if( n == 2 ) return 1;

        int prev1 = 1, prev2 = 1, prev3 = 0;

        for(int i = 3; i <= n; i++) {
            int curr = prev1 + prev2 + prev3;
            prev3 = prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;

        // if(n<=0) return 0;
        // if(n==1 || n==2) return 1;
        // int zero=0;
        // int first=1;
        // int sec= 1;
        // // int res=0;
        // for(int i=3;i<=n;i++){
        //     int res= zero+ first+ sec;
        //     zero=first;
        //     first=sec;
        //     sec=res;
        // }
        // return sec;


        // if(n<=0) return 0;
        // if(n==1 || n==2) return 1;
        // int[] dp= new int[n+1];
        // dp[0]=0;
        // dp[1]=1;
        // dp[2]=1;
        // for(int i=3;i<=n;i++){
        //     dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        // }

        // return dp[n];
    }
}