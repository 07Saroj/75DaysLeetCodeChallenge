class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length; 
        if(n==0) return 0;
        // if(n==1) return 1;
        int max=-1;
        int[] dp=new int[n];

        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && (dp[i]<dp[j]+1)){
                    dp[i]=dp[j]+1;
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;

    }
}