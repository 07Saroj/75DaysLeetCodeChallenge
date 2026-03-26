class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int n = nums.length;

        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        double maxAvg = (double) prefixSum[k - 1] / k;
        for (int i = k; i < n; i++) {
            
            double currentSum = prefixSum[i] - prefixSum[i - k];
            maxAvg = Math.max(maxAvg, currentSum / k);
        }

        // int l=0;
        // int r=k-1;
        // double maxAvg=Double.NEGATIVE_INFINITY;
        // while(r<nums.length){
        //     double sum=0;
        //     for(int i=l;i<=r;i++){
        //         sum+=nums[i];
        //     }
        //     double avg=sum/k;
        //     // System.out.println("Sum:"+sum +" Avg:"+ avg);
        //     maxAvg=Math.max(maxAvg,avg);
        //     l++;
        //     r++;
        // }
        return maxAvg;
    }
}