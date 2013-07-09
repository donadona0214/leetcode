/*
Given an array of strings, return all groups of strings that are anagrams.
Note: All inputs will be in lower-case.
*/

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> results = new ArrayList<String>();
        if (strs == null || strs.length == 0) return results;
       
        Map<String, Integer> anagramMap = new HashMap<String, Integer>();
        Map<String, String> signatureMap = new HashMap<String, String>();
        for (String s: strs) {
            char[] sorted = s.toCharArray();
            Arrays.sort(sorted);
            String signature = String.valueOf(sorted);
           
            signatureMap.put(s, signature);
           
            Integer count = anagramMap.get(signature);
            if (count == null) {
                anagramMap.put(signature, 1);
            } else {
                anagramMap.put(signature, count + 1);
            }
        }
       
        for (String s: strs) {
            Integer count = anagramMap.get(signatureMap.get(s));
            if (count > 1) {
                results.add(s);
            }
           
        }
        return results;
    }
}
