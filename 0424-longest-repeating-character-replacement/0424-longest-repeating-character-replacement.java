class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        if(n==0) return 0;
        int[] freq= new int[26];
        int Max=0;
        int maxFreq=0;
        int l=0;

        
        for(int r=0;r<n;r++){
            freq[s.charAt(r)-'A']++;
            maxFreq=Math.max(maxFreq,freq[s.charAt(r)-'A']);
            if((r-l+1)-maxFreq > k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            Max=Math.max(Max,r-l+1);
            
        }
        return Max;
    }
}