/*
Given numRows, generate the first numRows of Pascal's triangle.
For example, given numRows = 5,
Return
[     [1],    [1,1],   [1,2,1],  [1,3,3,1], [1,4,6,4,1]]
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (numRows <=0) return results;
       
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        results.add(result);
        for (int i = 1; i< numRows; i++) {
            ArrayList<Integer> prevResult = results.get(i-1);
            result = new ArrayList<Integer>();
            result.add(prevResult.get(0));
            for(int j=1; j<prevResult.size(); j++) {
                result.add(prevResult.get(j-1) + prevResult.get(j));
            }
            result.add(prevResult.get(prevResult.size() -1));
            results.add(result);
        }
        return results;
    }
}
