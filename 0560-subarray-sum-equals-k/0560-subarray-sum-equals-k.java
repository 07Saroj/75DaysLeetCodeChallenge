class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap <Integer, Integer> map = new HashMap<>();        
        map.put(0,1);
        int count=0;
        int currSum=0;
        for(int ele: nums){
            currSum+=ele;
            if(map.containsKey(currSum-k)){
                count +=map.get(currSum-k);
            }

            map.put(currSum, map.getOrDefault(currSum,0)+1);


        }

       

        return count;

    }
}