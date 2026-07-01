class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int[] res={-1};
        Map<Integer, Integer> mp= new HashMap<>();
        for(int i=0;i<n;i++){
            if(mp.containsKey(target-nums[i])){
                res=new int[]{mp.get(target-nums[i]),i};
            }
            mp.put(nums[i],i);
        }

        return res;

    }
}