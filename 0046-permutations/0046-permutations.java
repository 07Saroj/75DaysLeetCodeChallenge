class Solution {
    static void helper(int[] nums,int idx,List<List<Integer>> ans){
        if(idx==nums.length-1){//base case
            List<Integer> ls = new ArrayList<>();
            for(int num : nums){
                ls.add(num);
            }
            ans.add(ls);
            return;
        }
        
        for(int i=idx;i<nums.length;i++){
            swap(i,idx,nums);
            helper(nums,idx+1,ans);
            swap(i,idx,nums);
        }

    }
    private static void swap(int idx1,int idx2,int[]nums){
        int temp=nums[idx1];
        nums[idx1]=nums[idx2];
        nums[idx2]=temp;
    }
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans= new ArrayList<>();
        helper(nums,0,ans);
        return ans;
    }
}