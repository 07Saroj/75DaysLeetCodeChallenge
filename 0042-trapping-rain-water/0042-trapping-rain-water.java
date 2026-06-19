class Solution {
    public int trap(int[] height) {
        int n=height.length;
        

        int[] maxLeft=new int[n];
        maxLeft[0]=0;
        for(int i=1;i<n;i++){
            maxLeft[i]=Math.max(height[i-1],maxLeft[i-1]);   
        }

        int[] maxRight=new int[n];
        maxRight[n-1]=0;
        for(int i=n-2;i>=0;i--){
            maxRight[i]=Math.max(height[i+1],maxRight[i+1]);
        }
        int res=0;
        for(int i=0;i<n;i++){
            int w=Math.min(maxLeft[i],maxRight[i])-height[i];
            res+=(w>0)?w:0;
        }
        return res;
    }
}