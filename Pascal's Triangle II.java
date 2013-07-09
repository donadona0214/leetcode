/*
Given an index k, return the kth row of the Pascal's triangle.
For example, given k = 3,
Return [1,3,3,1].
Note:

Could you optimize your algorithm to use only O(k) extra space?
*/

public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> results = new ArrayList<Integer>(rowIndex+1);
       
        if (rowIndex < 0) return results;
        int size = 2*rowIndex+1;
       
        ArrayList<Integer> curr = new ArrayList<Integer>(size);
         ArrayList<Integer> next = new ArrayList<Integer>(size);
        for (int i=0; i<size; i++) {
                 curr.add(0);
               next.add(0);
          }
        curr.set(size/2, 1);
        for(int i=1; i<=rowIndex; i++) {
               for (int j=0; j<size; j++) next.set(j,0);

            for (int j=0; j<size; j++) {
                if (j-1>=0) {
                    next.set(j, next.get(j) + curr.get(j-1));
                }
                if (j+1<size) {
                    next.set(j, next.get(j) + curr.get(j+1));
                }
            }
                    ArrayList<Integer> tmp = curr;
            curr = next;
                  next = tmp;
        }

        for (int i=0; i<size; i+=2) {
            results.add(curr.get(i));
        }
        return results;
    }
}
