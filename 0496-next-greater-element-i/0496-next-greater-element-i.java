class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> nextGreaterNum=new HashMap<>();
        Deque<Integer> st= new ArrayDeque<>();

        for(int i=0;i<nums2.length;i++){
            while(!st.isEmpty() && st.peek()<nums2[i]){
                nextGreaterNum.put(st.pop(),nums2[i]);
            }
            st.push(nums2[i]);
        }

        int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i]= nextGreaterNum.getOrDefault(nums1[i],-1);
        }

        return ans;

        // int[] ans=new int[nums1.length];
        // Arrays.fill(ans,-1);
        // for(int i=0;i<nums1.length;i++){

        //     for(int j=0;j<nums2.length;j++){
        //         if(nums1[i]==nums2[j]){
        //             for(int k=j+1;k<nums2.length;k++){
        //                 if(nums2[j]<nums2[k]){
        //                     ans[i]=nums2[k];
        //                     break;
        //                 }
        //             }

        //         }
        //     }
        // }

        // return ans;
    }
}