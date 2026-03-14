class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] Arr1=s.toCharArray();
        char[] Arr2=t.toCharArray();
        Arrays.sort(Arr1);
        Arrays.sort(Arr2);
        // returning result
        return Arrays.equals(Arr1,Arr2);
    }
}