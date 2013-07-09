/*
Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string int Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        Map<String, String> phoneMap = new HashMap<String, String>();
         phoneMap.put("0", "_");
         phoneMap.put("1", " ");
         phoneMap.put("2", "abc");
         phoneMap.put("3", "def");
         phoneMap.put("4", "ghi");
         phoneMap.put("5", "jkl");
         phoneMap.put("6", "mno");
         phoneMap.put("7", "pqrs");
         phoneMap.put("8", "tuv");
         phoneMap.put("9", "wxzy");
     
       ArrayList<String> result = new ArrayList<String>();
       if (digits == null || digits.isEmpty()) {
         result.add("");
         return result;
       }
    
       for (int i=0; i<digits.length(); i++) {
         String values = phoneMap.get(digits.substring(i,i+1));
         ArrayList<String> newResult = new ArrayList<String>();
         for(int j=0; j<values.length(); j++) {
            String c = values.substring(j,j+1);
            if (result.isEmpty()) {
               newResult.add(c);
            } else {
               for(int k=0; k<result.size(); k++) {
                  StringBuilder sb = new StringBuilder();
                  sb.append(result.get(k));
                  sb.append(c);
                  newResult.add(sb.toString());
               }
            }
        }
         result = newResult;
       }
       return result;
    }
}
