class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        if (n1 > n2) return false;

        int[] s1Counts = new int[26];
        int[] s2Counts = new int[26];

        // Fill initial frequencies for s1 and the first window of s2
        for (int i = 0; i < n1; i++) {
            s1Counts[s1.charAt(i) - 'a']++;
            s2Counts[s2.charAt(i) - 'a']++;
        }

        // Slide the window across s2
        for (int i = 0; i < n2 - n1; i++) {
            if (matches(s1Counts, s2Counts)) return true;
            
            // Move window: add next character, remove oldest character
            s2Counts[s2.charAt(i + n1) - 'a']++;
            s2Counts[s2.charAt(i) - 'a']--;
        }

        return matches(s1Counts, s2Counts);
    }

    private boolean matches(int[] s1Counts, int[] s2Counts) {
        for (int i = 0; i < 26; i++) {
            if (s1Counts[i] != s2Counts[i]) return false;
        }
        return true;
    }
}