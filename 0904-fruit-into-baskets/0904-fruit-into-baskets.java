class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> mp= new HashMap<>();
        int l=0;
        int maxCount=0;
        for(int r=0;r<fruits.length; r++){
            int currFruit=fruits[r];
            mp.put(currFruit,mp.getOrDefault(currFruit,0)+1);
            while(mp.size() > 2){
                int leftFruit=fruits[l];
                mp.put(leftFruit, mp.get(leftFruit)-1);

                if(mp.get(leftFruit)==0){
                    mp.remove(leftFruit);
                }

                l++;

            }
            maxCount=Math.max(maxCount,r-l+1);
        }
            

        
        return maxCount;
    }
}