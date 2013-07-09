/*
Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
Input: numbers={2, 7, 11, 15}, target=9

Output: index1=1, index2=2
*/

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Map<Integer, Integer> valueMap = new HashMap<Integer, Integer>();       
        int[] idx = new int[2];
        int len = numbers.length;
       
        for (int i=0; i<len; i++) {
            Integer index = valueMap.get(target - numbers[i]);
            if (index == null) {
                valueMap.put(numbers[i], i);
            } else {
                idx[0] = index + 1;
                idx[1] = i + 1;
                return idx;
            }
        }
        return idx;
    }
}
