class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int  n=numbers.length;
        if(n==2){
            return new int[]{1,2};
        }
        int l=0;
        int r=n-1;
        while(l<r){
            if((numbers[l]+numbers[r])==target){
                return new int[] {l+1,r+1};
            }
            else if((numbers[l]+numbers[r])>target){
                r--;
            }
            else{
                l++;
            }
        }

        // for(int i=1;i<n;i++){
        //     if((numbers[idx1]+numbers[i])==target){
        //         return new int[] {idx1+1,i+1};
        //     }else if((numbers[idx1]+numbers[i])<target){
        //         idx1++;
        //     }
        // }
        return new int[2];
    }
}