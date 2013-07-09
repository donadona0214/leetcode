/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.
Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> results = new ArrayList<Interval>();
        boolean bInserted = false;
        for (Interval ir : intervals) {
            if (ir.start < newInterval.start) {
                results.add(ir);
            } else {
                if (!bInserted) {
                    insertHelper(results, newInterval);
                }
                Interval r = results.get(results.size() -1);
               
                if (ir.start > r.end) {
                    results.add(ir);
                } else {
                    r.end = Math.max(r.end, ir.end);
                }
            }
        }
        if (!bInserted) {
            insertHelper(results, newInterval);
        }
        return results;
    }
   
    public void insertHelper(ArrayList<Interval> results, Interval newInterval) {
        if (results.isEmpty()) {
            results.add(newInterval);
        } else {
            Interval r = results.get(results.size() -1);
            if (newInterval.start <= r.end) {
                r.end = Math.max(newInterval.end, r.end);
            } else {
                results.add(newInterval);
            }
        }
    }
}
