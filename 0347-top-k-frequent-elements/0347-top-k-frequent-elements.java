class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        Map<Integer, Integer> freqEle= new HashMap<>();
        for(int i=0;i<n;i++){
            int key=nums[i];
            Integer v=freqEle.get(key);
            if(v==null){
                freqEle.put(key,1);
            }else{
                freqEle.put(key,v+1);
            }       
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b)-> freqEle.get(b)-freqEle.get(a)
        );
        pq.addAll(freqEle.keySet());
    
        int[] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=pq.poll(); //to get the top element per iteration
        }
        
        
        // Arrays.sort(nums);
        // int[] arr=new int[10];
        // int[] result=new int[k];
        // if(nums.length<=1){
        //     result[0] =nums[0];
        //     return result;
        // }
        
        // for(int i=0;i<n;i++){
        //     int idx=nums[i];
        //     arr[idx]+=1;         
        // }
        // int j=0;
        // for(int i=0;i<=k;i++){
        //     if(arr[i]>=k ){
        //         result[j]=i;
        //         j++;
        //     }         
        // }
        

       
        return result;
    }
}