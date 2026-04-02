class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        // Stack<Integer> st=new Stack<>();
        Deque<Integer> st=new ArrayDeque<>();
       
        int[] ans=new int[n];

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                int prevIdx=st.pop();
                ans[prevIdx]=i-prevIdx;
            }
            st.push(i);
        }
        return ans;
    }
}