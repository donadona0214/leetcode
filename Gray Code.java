/*
The gray code is a binary numeral system where two successive values differ in only one bit.
Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
00 - 001 - 111 - 310 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
*/

public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (n == 0) {
            result.add(0);
            return result;
        }
       
        ArrayList<Integer> prevResult = grayCode(n-1);
        for (int i=0; i<prevResult.size(); i++) {
            int prev = prevResult.get(i);
            result.add(prev*2 + i%2);
            result.add(prev*2 + (i+1)%2);
        }
        return result;
    }
}
