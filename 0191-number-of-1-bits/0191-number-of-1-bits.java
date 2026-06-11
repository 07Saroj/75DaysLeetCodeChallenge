class Solution {
    public int hammingWeight(int n) {
        int count=0;
        while(n>0){
            int res=n%2;
            if(res!=0)count+=1;
            n=n/2;
        }
        return count;
        
    }
}