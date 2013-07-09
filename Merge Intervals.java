/*
Given a collection of intervals, merge all overlapping intervals.
For example,
Given [1,3],[2,6],[8,10],[15,18],

return [1,6],[8,10],[15,18].
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Comparator<Interval> comp = new Comparator<Interval>() {
            @Override
            public int compare(Interval ia, Interval ib) {
                if (ia.start > ib.start) {
                    return 1;
                } else if (ia.start < ib.start) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
       
        Collections.sort(intervals, comp);
        ArrayList<Interval> results = new ArrayList<Interval>();
        for (int i=0; i<intervals.size(); i++) {
            Interval iv = intervals.get(i);
            if (results.isEmpty()) {
                results.add(iv);
            }
            else {
                Interval r = results.get(results.size() -1);
                if (iv.start > r.end) {
                    results.add(iv);
                } else {
                    r.end = Math.max(r.end, iv.end);
                }
            }
        }
        return results;
    }
}
