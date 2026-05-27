class Solution {
    public int findJudge(int n, int[][] trust) {
        // Use an array to keep track of the net trust score
        int[] trustScores = new int[n + 1];
        
        for (int[] relationship : trust) {
            int a = relationship[0];
            int b = relationship[1];
            
            // a trusts someone, so decrease their score
            trustScores[a]--;
            // b is trusted, so increase their score
            trustScores[b]++;
        }
        
        // Check for the judge
        for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }
        
        return -1;
    }
}