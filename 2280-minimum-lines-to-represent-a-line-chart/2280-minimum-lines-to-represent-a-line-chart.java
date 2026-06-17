class Solution {
    public int minimumLines(int[][] stockPrices) {
        int n=stockPrices.length;
        if(n<2)  return 0;
        Arrays.sort(stockPrices,(a,b) -> Integer.compare(a[0],b[0])); //⭐
        int minLines=1;
        
        for(int i=2;i<stockPrices.length;i++){
            long x1=stockPrices[i-2][0], y1=stockPrices[i-2][1];
            long x2=stockPrices[i-1][0], y2=stockPrices[i-1][1];
            long x3=stockPrices[i][0], y3=stockPrices[i][1];
            // (y2 - y1) / (x2 - x1) != (y3 - y2) / (x3 - x2) slope of three consicutive points
            if((y2-y1)*(x3-x2)!=(y3-y2)*(x2-x1)){
                minLines+=1;
            }

        }
        return minLines;
    }
}