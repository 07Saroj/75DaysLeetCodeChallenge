class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int temp=grid[i][j];
                if(i==0 && j==0) grid[i][j]=temp;
                else if(i==0) grid[i][j]=grid[i][j-1]+temp;
                else if(j==0) grid[i][j]=grid[i-1][j]+temp;
                else grid[i][j]=temp + Math.min(grid[i-1][j],grid[i][j-1]);
               
            }
        }

        return grid[m-1][n-1];




        // int m=grid.length;
        // int n=grid[0].length;

        // int[][] dp=new int[m][n];
        
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(i==0 && j==0){// dp[0][0]
        //             dp[i][j]=grid[i][j];
        //         }else if(i==0){//filling first row
        //             dp[i][j]=dp[i][j-1]+grid[i][j];
        //         }else if(j==0){// filling first col
        //             dp[i][j]=dp[i-1][j]+grid[i][j];
        //         }else{
        //             dp[i][j]=grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
        //         }
               
        //     }
        // }

        // return dp[m-1][n-1];
    }
}