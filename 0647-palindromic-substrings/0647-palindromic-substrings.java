class Solution {
    public int countSubstrings(String s) {
        int m=s.length();
        // if(m==1) return 1;
        int[][] dp= new int[m][m];
        int count=0;
        for(int k=0;k<m;k++){
            int i=0,j=k;
            while(j<m){
                if(i==j){
                    count++;
                    dp[i][j]=1;
                    
                }else if(j==i+1){
                    if(s.charAt(i)==s.charAt(j)){
                        count++;
                        dp[i][j]=1;
                    }
                }else{
                    if(s.charAt(i)==s.charAt(j)){
                        if(dp[i+1][j-1]==1){
                            count++;
                            dp[i][j]=1;

                        }    
                    }
                }
                i++;
                j++;
            }
            
        }    
                
        return count;


    }
}