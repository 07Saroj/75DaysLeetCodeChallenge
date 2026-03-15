class Solution {
    public List <Integer>  findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        
        return result;

        
        // HashSet<Integer> set1= new HashSet<>();
        // HashSet<Integer> set2= new HashSet<>();
        
        // int n=nums.length;
        // for(int i=0;i<n;i++){
        //     set1.add(i+1);
        //     set2.add(nums[i]);
            
        // }
        // HashSet<Integer> diff=new HashSet<>(set1);
        // diff.removeAll(set2);
        
        // List <Integer> result = new ArrayList<>(diff);
        // return result;

        
    }
}