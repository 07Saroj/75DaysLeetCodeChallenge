class Solution {
    private int bits(int n){
        if(n==0)return 0;
       int res=0;
        while(n>0){
            
            if((n%2)==1){
                res++;
            }
            n/=2;
        }
        return res;
    }
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i]=bits(i);
        }
        return ans;
    }
}