class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            currentSum += nums[right];

            // While the current window sum meets the target, 
            // try to shrink it from the left to find a smaller length
            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }

        // If minLength was never updated, return 0
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}