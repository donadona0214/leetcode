/*
Divide two integers without using multiplication, division and mod operator.
*/

public class Solution {
    // test case: (0,0), (2,0), (0,2), (1, 2), (2, 2), (3, 2)
    public int divide(int dividend2, int divisor2) {
        // Start typing your Java solution below
        // DO NOT write main() function
         long dividend = (long)dividend2;
          long divisor = (long)divisor2;
        if (divisor == 0) {
            throw new IllegalArgumentException();
        }
     
        long flag = 1;
        if (dividend < 0) {
            flag *= -1;
            dividend *= -1;
        }
     
        if (divisor < 0) {
            flag *= -1;
            divisor *= -1;
        }
      
        if (divisor == 1) return (int) (dividend*flag);
       
        int size = 32;
        long[] pows = new long[size];
        long[] vals = new long[size];
       
        for (int i= 0; i< size; i++) {
            if (i == 0) {
                pows[i] = divisor;
                vals[i] = 1;
            } else {
                pows[i] = pows[i-1] + pows[i-1];
                vals[i] = vals[i-1] + vals[i-1];
            }
        }
       
        long result = 0;
        long remaining = dividend;
        for (int i=size-1; i>=0; i--) {
            if (remaining >= pows[i]) {
                result += vals[i];
                remaining -= pows[i];
            }
            if (remaining < divisor) break;
        }
     
        return (int) (result*flag);
    }
}
