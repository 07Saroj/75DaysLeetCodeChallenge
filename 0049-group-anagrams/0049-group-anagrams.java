class Solution {
    static boolean isAnagram(String s1,String s2){
        if(s1.length()!=s2.length()) return false;
        char[] a1=s1.toCharArray();
        char[] a2=s2.toCharArray();

        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1,a2);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;
        List<List<String>> result=new ArrayList<>();
        if(n<=1){
            List<String> l=new ArrayList<>();
            l.add(strs[0]);
            result.add(l);
            return result;
        }
        
        for(int i=0;i<n;i++){
            List<String> l1=new ArrayList<>();
            if(strs[i]!="null"){
                
                l1.add(strs[i]);
            }
            
            for(int j=i+1;j<n;j++){
                if(isAnagram(strs[i],strs[j]) && strs[j]!="null" ){
                    l1.add(strs[j]);
                    
                    strs[j]="null";
                }
                
            }
            if(!l1.isEmpty()){
                result.add(l1);
            }
               
        }

        // int l=0;
        // int r=n-1;
        // while(l<r){
        //     if(isAnagram(strs[l],strs[r])){
        //         List<String> l1=new ArrayList<>();
        //         l1.add(strs[l]);
        //         l1.add(strs[r]);
        //         result.add(l1);
        //         l++;
        //         r--;
        //     }else{
        //         List<String> l1=new ArrayList<>();
        //         l1.add(strs[r]);
        //         result.add(l1);
        //         r--;
        //     }
        // }
        

        return result;
    }
}