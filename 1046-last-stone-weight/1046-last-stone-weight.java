class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap= new PriorityQueue<>(Collections.reverseOrder());

        for(int s : stones){
            maxHeap.add(s);
        }

        while(maxHeap.size()>1){
            int s1=maxHeap.poll();
            int s2=maxHeap.poll();

            if(s1!=s2){
                maxHeap.add(s1-s2);
            }
        }

        if(maxHeap.size()==1){
            return maxHeap.peek();
        }
        return 0;
        
    //    int n=stones.length;
    //    if(n==1){
    //     return stones[0];
    //    }
    //     Arrays.sort(stones);

    //     for(int i=n-1;i>=0;i--){
    //         int j=i-1;
    //         if(j>=0){
    //             if(stones[i]==stones[j] && stones[i]>0 && stones[j]>0){
    //             stones[i]=stones[j]=-1;
    //             }    
    //             else if(stones[i]!=stones[j] && stones[j]>0){
    //                 stones[i]-=stones[j];
    //                 stones[j]=-1;
    //             } 
    //         }
               

    //     }

    //     for(int stone: stones){
    //         if(stone>0){
    //             return stone;
    //         }
                
            
    //     }
    //     return 0;
        
    }
}