/*
Implement int sqrt(int x).
Compute and return the square root of x.
*/

//edge cases, negative, 0, 1, >1, <1;
public class Solution {
    public int sqrt(int x) {
        if (x<0) return -1;
        if (x==0 || x==1) return x;
        double start, end;
        if (x<1) {
            start = x;
            end = 1;
        } else {
            start = 1;
            end = x;
        }
       
        double eps = 1e-6;
        while (end - start > eps) {
            double val = (end + start) / 2;
            if (val*val > x) {
                end = val;
            } else {
                start = val;
            }
        }
        return (int) ((start+end)/2);
    }
}
