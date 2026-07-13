class Solution {
    public int longestConsecutive(int[] nums) {
        int n= nums.length;
        if(n==0) return 0;
        int maxLen=1;
        HashSet<Integer> st= new HashSet<>();
        for(int num: nums){
            st.add(num);
        }
        
        for(int ele: st){
            if(!st.contains(ele-1)){
                int currLen=1;
                int currNum=ele;
                while(st.contains(currNum+1)){
                    currLen++;
                    currNum++;
                }
                maxLen=Math.max(currLen,maxLen);
            }
        }

        return maxLen;
    }
}