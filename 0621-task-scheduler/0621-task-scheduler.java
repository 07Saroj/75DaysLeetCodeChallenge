class Solution {
    public int leastInterval(char[] tasks, int n) {
        //1.count the frequencies of the tasks
        Map<Character,Integer> mp= new HashMap<>();
        for(char ch: tasks){
            if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)+1);
            }else{
                mp.put(ch,1);
            }
        }
        //Add freqs in the pq
        PriorityQueue<Integer> pq= new PriorityQueue<>(Comparator.reverseOrder());

        for(char key: mp.keySet()){
            pq.add(mp.get(key));
        }
        int totalTime=0;
        while(!pq.isEmpty()){
            List<Integer> temp= new ArrayList<>();

            for(int i=0;i<=n;i++){
                if(!pq.isEmpty()){
                    int freq=pq.poll();

                    if(freq>1){
                        temp.add(freq-1);// add rest of the freq to temp
                    }
                }
                totalTime++;

                if(pq.isEmpty() && temp.isEmpty()){
                    break;//all tasks are done
                }
            }

            for(int freq: temp){
                pq.add(freq);
            }


        }

        return totalTime;
    }
}