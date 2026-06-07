class Solution {
    private long longestSubsequence(int idx,long[][] dp,List<Integer> nums,int target){
        if(target==0) return 0;// base case 1 target ==0
        if(idx==nums.size()){ // base case 2: we reach at the end and we do not get the target
            return Integer.MIN_VALUE;
        }
        long peak=Integer.MIN_VALUE;
        if(dp[idx][target]!=-1) return dp[idx][target];
        long skip=longestSubsequence(idx+1,dp,nums,target);
        if(target-nums.get(idx)<0) return dp[idx][target]=skip;
        // *******//
        else{
            
            long res=longestSubsequence(idx+1,dp,nums,target-nums.get(idx));
            if(res!=Integer.MIN_VALUE){
                peak=1+res;
            }
        }
        
        
        return dp[idx][target]=Math.max(skip,peak);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        long[][] dp=new long[nums.size()][target+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        int ans=(int)longestSubsequence(0,dp,nums,target);
        return (ans==Integer.MIN_VALUE)? -1 : ans;

        // return (int)longestSubsequence(0,dp,nums,target);
    }
}