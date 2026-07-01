class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mp1 = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            if(mp1.containsKey(ch1)){
                if(mp1.get(ch1)!=ch2) return false;
            }else if(mp1.containsValue(ch2)){
                return false;
            }
            else{
                mp1.put(ch1,ch2);
            }
        }

        return true;
    }
}