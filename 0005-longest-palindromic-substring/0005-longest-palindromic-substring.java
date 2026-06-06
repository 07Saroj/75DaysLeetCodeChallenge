class Solution {
    
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        int start=0;
        int end=0;
        int maxLength=1;
        
        for(int i=0;i<n;i++){
            dp[i][i]=true;
            for(int j=0;j<i;j++){
                if(s.charAt(j)==s.charAt(i)){
                    if(i-j<3  || dp[j+1][i-1]){
                        dp[j][i]=true;

                        if(i-j+1 > maxLength){
                            start=j;
                            maxLength=i-j+1;
                            end=i;
                            
                        }
                    }
                }
            }
            
        }
        return s.substring(start,end+1);
        
    }
}