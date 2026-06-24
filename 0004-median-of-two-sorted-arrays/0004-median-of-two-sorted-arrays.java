class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int l=m+n;
        int merged[]=new int[l];
        
        int i=0;
        int j=0;
        int k=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                merged[k++]=nums1[i++];
            }
            else{
                merged[k++]=nums2[j++];
            }           
        }
        while(i<m){
            merged[k++]=nums1[i++];
        }
        while(j<n){
            merged[k++]=nums2[j++];
        }
          
        
        if(l%2==0){int mid=l/2;
            return (merged[mid]+merged[mid-1])/2.0;
        }else{
            return merged[l/2];
        }
    }
}