class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        boolean isNeg=(dividend<0)^(divisor<0);
        int a=(dividend<0)? dividend: (-dividend);
        int b=(divisor<0)? divisor: (-divisor);
        int quotient=0;

        // 4. Exponential subtraction using bit shifting
        // Since both numbers are negative, a <= b means 'a' has a larger absolute value than 'b'
        while (a <= b) {
            int value = b;
            int multiple = 1;
            
            // Double 'value' and 'multiple' as long as it doesn't overflow 
            // and stays within the range of 'a'
            while (value >= (Integer.MIN_VALUE >> 1) && a <= (value << 1)) {
                value <<= 1;
                multiple <<= 1;
            }
            
            // Subtract the largest accumulated chunk from dividend
            a -= value;
            quotient += multiple;
        }

        return isNeg? -quotient: quotient;
    }
}