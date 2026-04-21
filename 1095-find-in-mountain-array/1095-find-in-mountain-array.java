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
        while(l<r){
            int mid=l+(r-l)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1)){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        int idx=r;
        System.out.println(idx);
        int findIdx=binarySearch(target,mountainArr,0, idx,true);

        if(findIdx==-1){
            findIdx=binarySearch(target,mountainArr, idx+1,len-1,false);
        }
        return findIdx;
        
    }
    int binarySearch(int target, MountainArray mountainArr,int l,int r,boolean ascen){
        

        while(l<=r){
            int mid=l+(r-l)/2;
            int val=mountainArr.get(mid);
            if(val==target){
                return mid;
            }
            if(ascen){
                if(val<target){
                l=mid+1;
                }else{
                    r=mid-1;
                }
            }else{
                if (val > target) l = mid + 1; 
                else r = mid - 1;
            }
            
        }

        return -1;
    }
    // int binarySearchDesc(int target,MountainArray mountainArr, int l, int r) {
    //     while (l <= r) {
    //         int mid = l + (r - l) / 2;
    //         int val = mountainArr.get(mid);
    //         if (val == target) return mid;
    //         if (val > target) l = mid + 1; // Reverse logic: target is to the right
    //         else r = mid - 1;
    //     }
    //     return -1;
    // }
}