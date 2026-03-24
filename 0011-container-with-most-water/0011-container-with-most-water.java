class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int l=0;
        int r=n-1;
        int mArea=0;
        while(l<r){
            int currArea=Math.min(height[l],height[r])*(r -l);
            mArea=Math.max(mArea,currArea);
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        
        
        return mArea;

    }
}