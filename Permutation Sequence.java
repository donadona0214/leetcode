/*
The set [1,2,3,…,n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

  1. "123"
  2. "132"
  3. "213"
  4. "231"
  5. "312"
  6. "321"
  
Given n and k, return the kth permutation sequence.
Note: Given n will be between 1 and 9 inclusive.
*/

public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] nCounts = new int[n];
        nCounts[0] = 1;
        for (int i = 1; i < n; i++) {
            nCounts[i] = nCounts[i-1] * i;
        }
       
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> elements = new ArrayList<Integer>();
        for (int i=1; i<=n; i++) elements.add(i);
        k = k -1;
        for (int i=0; i<n; i++) {
            int idx = k / nCounts[n-i-1];
            k = k % nCounts[n-i-1];
            Integer ele = elements.get(idx);
            sb.append(ele);
            elements.remove(ele);
        }
        return sb.toString();
    }
}

