/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
The replacement must be in-place, do not allocate extra memory.
Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3

1,1,5 → 1,5,1
*/

public class Solution {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = num.length;
        int i = len - 2;
        for (; i >=0; i--) {
            if (num[i+1] > num[i]) break;
        }
      
        if (i >= 0) {
            int min = Integer.MAX_VALUE;
            int minIdx = i;
            for (int j=i+1; j<len; j++) {
                if (num[j] > num[i] && num[j] < min){
                    minIdx = j;
                    min = num[j];
                }
            }
            swap(num, i, minIdx);
            for (int j=i+1; j<len; j++) {
                min = Integer.MAX_VALUE;
                minIdx = j;
                for (int k = j; k<len; k++) {
                    if (num[k] < min){
                        minIdx = k;
                        min = num[k];
                    }
                }
                swap(num, j, minIdx);
            }
        } else {
            for (int j = 0; j < len/2; j++) {
                swap(num, j, len-1-j);
            }
        }
    }
  
    public void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
