class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        List<List<Integer>> result=new ArrayList<>();
       
        
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }else{
                int j=i+1;
                int k=n-1;
                while(j<k){
                    if((nums[j]+nums[k])==(-nums[i])){
                        result.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                        j++;
                        k--;
                        // NEW: Skip all duplicate values for j
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        
                        // NEW: Skip all duplicate values for k
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                        
                    }else if((nums[j]+nums[k]+nums[i])<0){
                        j++;
                    }else{
                        k--;
                    }
                }

            }
            
        }

        return result;
    }
}