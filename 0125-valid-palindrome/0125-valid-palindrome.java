class Solution {
    public boolean isPalindrome(String s) {
        String result=s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        // System.out.print(result);
        int l=0;
        int r=result.length()-1;
        while(l<r){
            char a=result.charAt(l);
            char b=result.charAt(r);
            if(a!=b){
                return false;
            }
            l++;
            r--;
        }
        
        return true;
    }
}