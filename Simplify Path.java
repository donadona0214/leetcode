/*
Given an absolute path for a file (Unix-style), simplify it.
For example,
path = "/home/", => "/home"

path = "/a/./b/../../c/", => "/c"
*/

public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> results = new ArrayList<String>();
       
        String result = "";
        if (path == null) return "";
        int len = path.length();
        if (len == 0) return "";
       
        int s = 0, e = 0;
        int pos = 0;
        while (s < len) {
            e = s+1;
            while (e < len && path.charAt(e) != '/') {
                e++;
            }
           
            if (e - s == 1) {
                s = e;
                continue;
            }
           
            if (e - s == 2 && path.charAt(s+1) == '.') {
                s = e;
                continue;
            }
           
            if (e - s == 3 && path.charAt(s+1) == '.' && path.charAt(s+2) == '.') {
                s = e;
                pos --;
                continue;
            }
           
            if (pos < 0) pos = 0;
            results.add(pos, path.substring(s,e));
            s = e;
            pos ++;
        }
       
        if (pos <= 0) return "/";
       
        for (int i=0; i<pos; i++) result += results.get(i);
       
        return result;
    }
}
