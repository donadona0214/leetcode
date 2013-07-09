/*
Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

  1. Only one letter can be changed at a time
  2. Each intermediate word must exist in the dictionary

For example,
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

Return

  [    ["hit","hot","dot","dog","cog"],    ["hit","hot","lot","log","cog"]  ]

Note:

   * All words have the same length.
   * All words contain only lowercase alphabetic characters.
*/

public class Solution {
    public void addPath (Node node, ArrayList<ArrayList<String>> results) {
        ArrayList<String> result = new ArrayList<String>();
        Node p = node;
        while (p != null) {
            result.add(0, p.val);
            p = p.parent;
        }
        results.add(result);
    }
   
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {        
        // Start typing your Java solution below
        // DO NOT write main() function
        // Depth first search w one letter difference as neighbers
        dict.add(start);
        dict.add(end);
   
        Map<String, Set<String>> neighborMap = calcNeighborMap(dict);
       
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
       
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(new Node(null, start, 1));
       
        Map<String, Integer> visited = new HashMap<String, Integer>();

        int prevLevel = 0;
       
        while (!queue.isEmpty()) {
            Node n = queue.pollFirst();
            if (end.equals(n.val)) {
                if (prevLevel == 0 || n.level == prevLevel) {
                    prevLevel = n.level;
                    addPath(n, results);
                } else {
                    break;
                }
            } else {
                //if (prevLevel != 0 && n.level > prevLevel) break;
               
                Set<String> neighbors = neighborMap.get(n.val);
               
                if (neighbors == null || neighbors.isEmpty()) continue;
               
                ArrayList<String> toRemove = new ArrayList<String>();
                for (String s : neighbors) {
                    if (visited.containsKey(s)) {
                        Integer level = visited.get(s);
                        if (level < n.level + 1) {
                            neighborMap.get(s).remove(n.val);
                            toRemove.add(s);
                            continue;
                        }
                    }
                   
                    visited.put(s, n.level+1);
                    queue.add(new Node(n, s, n.level+1));
                   
                    if(neighborMap.containsKey(s))
                        neighborMap.get(s).remove(n.val);
                }
               
                for (String tr : toRemove) {
                    neighbors.remove(tr);
                }
            }
        }
        return results;
    }   
   
    Map<String, Set<String>> calcNeighborMap(HashSet<String> dict) {
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        for (String word : dict) {
            int len = word.length();
            char [] chars = word.toCharArray();
            for ( int i = 0; i < len; i++) {
                char old = chars[i];
                for (char c = 'a'; c<='z'; c++) {
                    if (c==old) continue;
                    chars[i] = c;
                    String newWord = new String(chars);
                    if(dict.contains(newWord)) {
                        Set<String> neighbors = map.get(word);
                        if (neighbors == null) {
                            neighbors = new HashSet<String>();
                            neighbors.add(newWord);
                            map.put(word, neighbors);
                        } else {
                            neighbors.add(newWord);
                        } 
                    }
                }
                chars[i] = old;
            }
        }

        return map;
    }
 
    boolean isNeighbor(String word, String neighbor) {
        if(word.length() != neighbor.length()) return false;
        int unMatches = 0;
        for (int i=0; i< word.length(); i++) {
            if (word.charAt(i) != neighbor.charAt(i)) unMatches ++;
            if (unMatches > 1) return false;
        }
        return true;
   }
  
   public class Node {
       int level;
       Node parent;
       String val;
       public Node (Node parent, String val, int level) {
           this.parent = parent;
           this.val = val;
           this.level = level;
       }
   }
}
