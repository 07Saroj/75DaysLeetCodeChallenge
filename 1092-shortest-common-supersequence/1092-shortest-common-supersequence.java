class Solution {
    private String printlcs(String s1, String s2){
        int m=s1.length(),n=s2.length();
        int[][] dp=new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        String ans="";
        int i=m, j=n;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                ans+=s1.charAt(i-1);
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }else{
                j--;
            }
            
        }
        return new StringBuilder(ans).reverse().toString();
    }
    public String shortestCommonSupersequence(String s1, String s2) {
        String res="";
        String Lcs=printlcs(s1,s2);
        int i=0, j=0, k=0;
        
        while(i<s1.length() && j<s2.length() && k<Lcs.length()){
            while(s1.charAt(i)!=Lcs.charAt(k)){
                res+=s1.charAt(i);
                i++;
            }
            while(s2.charAt(j)!=Lcs.charAt(k)){
                res+=s2.charAt(j);
                j++;
            }
            
            res+=Lcs.charAt(k);
            k++;
            i++;
            j++;
           
                   
        }
        
        while(i<s1.length()){
            res+=s1.charAt(i);
            i++;
        }
        while(j<s2.length()){
            res+=s2.charAt(j);
            j++;
        }
        
        


        return res;

    }
}