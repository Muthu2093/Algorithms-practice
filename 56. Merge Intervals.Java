/**
 * Given a collection of intervals, merge all overlapping intervals.
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
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
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare (Interval a, Interval b){
                if (a.start != b.start){
                    return Integer.valueOf(a.start).compareTo(Integer.valueOf(b.start));
                }
                return Integer.valueOf(a.end).compareTo(Integer.valueOf(b.end));
            }
        });
        
        int r=1;
        
        while (r < intervals.size()){
            if (intervals.get(r).start <= intervals.get(r-1).end){
                intervals.get(r-1).end = Math.max(intervals.get(r-1).end, intervals.get(r).end);
                intervals.remove(r);
            }
            else{
                r++;
            }
        }
        
        return intervals;
    }
}
