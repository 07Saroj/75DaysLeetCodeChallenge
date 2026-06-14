public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            // 1. Shift result to the left to make room for the next bit
            result <<= 1;
            
            // 2. Isolate the last bit of n using bitwise AND (& 1) 
            //    and add it to result using bitwise OR (|)
            result |= (n & 1);
            
            // 3. Unsigned right shift n by 1 to bring the next bit into view
            //    We use >>> instead of >> to handle negative numbers properly
            n >>>= 1;
        }
        
        return result;
    }
}