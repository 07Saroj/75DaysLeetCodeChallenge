class Solution {
    public List <Integer>  findDisappearedNumbers(int[] nums) {
        
        HashSet<Integer> set1= new HashSet<>();
        HashSet<Integer> set2= new HashSet<>();
        
        int n=nums.length;
        for(int i=0;i<n;i++){
            set1.add(i+1);
            set2.add(nums[i]);
            
        }
        HashSet<Integer> diff=new HashSet<>(set1);
        diff.removeAll(set2);
        
        List <Integer> result = new ArrayList<>(diff);
        return result;

        
    }
}