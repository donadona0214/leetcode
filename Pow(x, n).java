/*
Implement pow(x, n).
*/

public class Solution {
    public double pow(double x, int n) {
        if (n==0) return 1;
       
        boolean negative = false;
        if (n<0) {
            n *= -1;
            negative = true;
        }
       
        double sqrtVal = pow(x, n/2);
        double val = sqrtVal * sqrtVal;
       
        if (n%2 == 1) val *= x;
       
        if (negative) val = 1/val;
        return val;
    }
}
