class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            // Calculate mid to avoid potential integer overflow
            int mid = l + (r - l) / 2;

            // Target found, return index
            if (nums[mid] == target) {
                return mid;
            } 
            // Check if the RIGHT half is strictly sorted
            else if (nums[mid] <= nums[r]) {
                // If target lies within the sorted right half, search right
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } 
                // Otherwise, search in the left half
                else {
                    r = mid - 1;
                }
            } 
            // Otherwise, the LEFT half must be sorted
            else {
                // If target lies within the sorted left half, search left
                if (nums[l] <= target && nums[mid] > target) {
                    r = mid - 1;
                } 
                // Otherwise, search in the right half
                else {
                    l = mid + 1;
                }
            }
        }

        // Target was not found in the array
        return -1;
    }
}