/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len=mountainArr.length();
        
        int l=0;
        int r=len-1;
        // for(int i=1;i<len;i++){
        //     if(mountainArr.get(i)>mountainArr.get(i-1)){
        //         idx=i;
        //     }
        // }

        while(l<r){
            int mid=l+(r-l)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1)){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        int idx=l;
        System.out.println(idx);
        int findIdx=binarySearch(target,mountainArr,0, idx);

        if(findIdx==-1){
            findIdx=binarySearchDesc(target,mountainArr, idx+1,len-1);
        }
        return findIdx;
        
    }
    int binarySearch(int target, MountainArray mountainArr,int l,int r){
        

        while(l<=r){
            int mid=l+(r-l)/2;
            
            if(mountainArr.get(mid)==target){
                return mid;
            }
            else if(mountainArr.get(mid)<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }

        return -1;
    }
    int binarySearchDesc(int target,MountainArray mountainArr, int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int val = mountainArr.get(mid);
            if (val == target) return mid;
            if (val > target) l = mid + 1; // Reverse logic: target is to the right
            else r = mid - 1;
        }
        return -1;
    }
}