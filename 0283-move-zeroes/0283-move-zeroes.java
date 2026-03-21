class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        if(n==1)return;
        int idx=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                int temp=nums[idx];
                nums[idx]=nums[i];
                nums[i]=temp;
                idx++;
            }
        }
        


        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(nums[i]==0 && nums[j]!=0){
        //             nums[i]=nums[j];
        //             nums[j]=0;
        //         }
        //     }
        // }

    }
}