class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;        
        Arrays.sort(nums);
        int sum=nums[0]+nums[1]+nums[2];
        for(int i=0;i<n-2;i++){
            int l=i+1;
            int r=n-1;
            while(l<r){
                int currSum=nums[i]+nums[l]+nums[r];
                if(Math.abs(currSum-target)<Math.abs(sum-target)){
                    sum=currSum;
                }
                if(currSum<target){
                    l++;
                }else if(currSum> target){
                    r--;
                }else{
                    return currSum;
                }
            
            }
        }
        

        return sum;

    }
}