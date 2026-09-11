class Solution {
    static void helper(int[] nums,List<Integer> ls,boolean[]isVisited,List<List<Integer>> ans){
        if(ls.size()==nums.length){
            ans.add(new ArrayList(ls));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(!isVisited[i]){
                ls.add(nums[i]);
                isVisited[i]=true;
                helper(nums,ls,isVisited,ans);
                isVisited[i]=false;
                ls.remove(ls.size()-1);
            }
        }

    }
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ls= new ArrayList<>();
        boolean[]isVisited=new boolean[nums.length];
        helper(nums,ls,isVisited,ans);
        return ans;
    }
}