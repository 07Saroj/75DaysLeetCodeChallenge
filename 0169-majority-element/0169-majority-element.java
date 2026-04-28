class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int ele=nums[0];
        int count=1;
        for(int i=1;i<n;i++){
            if(nums[i]==ele){
                count++;
            }
            else if(count==0){
                ele=nums[i];
            }else{
                count--;
            }
        }
        return ele;
        // Arrays.sort(nums);
        // // Hashtable<Integer, Integer> ht= new Hashtable<>();
        // return nums[n/2];
        
    }
}