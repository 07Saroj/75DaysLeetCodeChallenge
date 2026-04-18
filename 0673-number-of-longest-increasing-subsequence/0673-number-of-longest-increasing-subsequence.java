class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length; 
        if(n==0) return 0;
        int max=-1;
        int[] len=new int[n];
        int []count=new int[n];
        Arrays.fill(len,1);
        Arrays.fill(count,1);
        for(int i=0;i<n;i++){
           
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] ){
                    if(len[i]<len[j]+1){
                        len[i]=len[j]+1;
                        count[i]=count[j];
                    }else if(len[i]==len[j]+1){
                        count[i]+=count[j];
                    }
                    
                }
            }
            max=Math.max(max,len[i]);
        }

        int Totalcount=0;
        for(int i=0;i<n;i++){
            if(len[i]==max){
                Totalcount+=count[i];
            }
        }
        return Totalcount;
    }
}