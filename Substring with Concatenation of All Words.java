/*
You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]
You should return the indices: [0,9].

(order does not matter).
*/

public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> results = new ArrayList<Integer>();
        if (S == null || L == null) return results;
        int lenS = S.length();
        int lenL = L.length;
        if (lenL == 0) return results;
        int sizeW = L[0].length();
    
        Map<String, Integer> hitMap = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; i++) {
               Integer count = hitMap.get(L[i]);
               if (count == null) {
                   hitMap.put(L[i], 1);         
               } else {
                   hitMap.put(L[i], count + 1);
               }
        }
       
        for (int i=0; i<= lenS - sizeW*lenL; i++) {
            if (isSubstring(S.substring(i, i+sizeW*lenL), L, hitMap)) {
                results.add(i);
            }
        }
        return results;
    }
 
    public boolean isSubstring(String S, String[] L, Map<String, Integer> hitMap) {
        Map<String, Integer> tempHitMap = new HashMap<String, Integer>();
    
        int sizeW = L[0].length();
        for (int i = 0; i <= S.length() - sizeW; i += sizeW) {
            String sub = S.substring(i, i+sizeW);
            Integer hit = hitMap.get(sub);
            if (hit == null) {
                return false;
            }
           
            Integer tmpHit = tempHitMap.get(sub);
            if (tmpHit == null) {
                tempHitMap.put(sub, 1);
            } else {
                if (tmpHit >= hit) return false;
                tempHitMap.put(sub, tmpHit + 1);
            }
        }
    
        return true;
    }
}
