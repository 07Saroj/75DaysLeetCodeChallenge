class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

        Map<Character, Integer> mp1=new HashMap<>();
        // Map<String, Integer> mp2=new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(mp1.containsKey(ch)){
                mp1.put(ch, mp1.get(ch)+1);
            }else{
                mp1.put(ch,1);
            }
        }   

        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(mp1.containsKey(ch)){
                mp1.put(ch, mp1.get(ch)-1);
            }else{
                mp1.put(ch,1);
            }
        } 

        for(var key: mp1.keySet()){
            if(mp1.get(key)!=0) return false;
        }

        return true;
    }
}