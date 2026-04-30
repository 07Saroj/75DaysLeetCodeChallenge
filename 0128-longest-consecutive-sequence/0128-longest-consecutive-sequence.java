class Solution {
    public int longestConsecutive(int[] nums) {

        int n = nums.length;
        if(n == 0) return 0;
        int len=1;
        
        Set<Integer> numSet = new HashSet<>();
        for(int ele :nums){
            numSet.add(ele);
        }
        
        
        for(int ele: numSet){
            if(!numSet.contains(ele-1)){
                int currNum=ele;
                int currLen =1;
                while(numSet.contains(currNum+1)){
                    currNum ++;
                    currLen++;
                }

                len=Math.max(len,currLen);
            }
        }
        
        return len;
    }
}