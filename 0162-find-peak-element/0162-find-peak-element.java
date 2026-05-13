class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the element to the right is greater, 
            // we are on an upward slope. The peak is to the right.
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } 
            // Otherwise, we are on a downward slope. 
            // The peak is to the left (including mid).
            else {
                right = mid;
            }
        }

        // When left == right, we've converged on a peak element index.
        return left;
    }
}
// class Solution {
//     public int findPeakElement(int[] nums) {
//         int n=nums.length;
//         int peakIdx=-1;
//         for(int i=2;i<n;i++){
//             if(nums[i-1]>nums[i] && nums[i-1]> nums[i-2]){
//                 peakIdx=i-1;
//             }
//         }

//         return peakIdx;

//     }
// }