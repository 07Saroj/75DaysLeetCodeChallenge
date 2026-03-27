class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0; 
        
        int maxLength = 0;
        int l = 0;
        boolean[] used = new boolean[128]; 

        for (int r = 0; r < n; r++) {
            
            while (used[s.charAt(r)]) {
                used[s.charAt(l)] = false;
                l++;
            }
            
            
            used[s.charAt(r)] = true;
            maxLength = Math.max(maxLength, r - l + 1);
        }
        
        return maxLength;
    }
}