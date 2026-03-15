class Solution {
    public List <Integer>  findDisappearedNumbers(int[] nums) {
        
        HashSet<Integer> set1= new HashSet<>();
        HashSet<Integer> set2= new HashSet<>();
        // Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){
            set1.add(i+1);
            set2.add(nums[i]);
            
        }
        HashSet<Integer> diff=new HashSet<>(set1);
        diff.removeAll(set2);
        
        List <Integer> result = new ArrayList<>(diff);
        return result;

        // Arrays.sort(nums);
        
        // for(int i=0;i<n;i++){
        //     if(nums[i]!=(i+1)){
                
        //         result.add(i+1);
        //     }
            
        // }
        
        // for(int j=0;j<result.size();j++){
        //     int ele=result.get(j);
        //     for(int i=0;i<n;i++){
        //         if(nums[i]==ele){
        //             result.remove(j);
        //         }
        //     }
        // }

        // return result;
    }
}