/**
 * Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.
 * Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.
 * A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)
 * For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
 * Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 * Example 1:
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(15, 25); // returns false
 * MyCalendar.book(20, 30); // returns true
 * Explanation: 
 * The first event can be booked.  The second can't because time 15 is already booked by another event.
 * The third event can be booked, as the first event takes every time less than 20, but not including 20.
 * Note:
 * The number of calls to MyCalendar.book per test case will be at most 1000.
 * In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].
 */
 
class MyCalendar {
    TreeMap<Integer, Integer> from;
    TreeMap<Integer, Integer> to;
    int min, max;
        
    public MyCalendar() {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        from = new TreeMap<>();
        to = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        if (to.containsKey(end) || from.containsKey(start)){
            return false;
        }
        List<Integer> arr = new ArrayList<>(from.keySet());
        int i = binarySearch(arr, start, true);
        if (i != -1 && end > arr.get(i) && end <= to.get(arr.get(i))){
            return false;
        }
        arr = new ArrayList<>(to.keySet());
        i = binarySearch(arr, start, false);
        if (i != -1 && start >= arr.get(i) && start < from.get(arr.get(i))){
            return false;
        }
        from.put(start, end);
        to.put(end,start);
        return true;
        
        
    }
    
    public int binarySearch(List<Integer> arr, int target, boolean flag){
        int l=0, r=arr.size()-1, m = 0;
        if (flag){
           while (l<=r){
                m = (r-l)/2 + l;
                if (m == 0 || m == arr.size()-1 || arr.get(m) >= target && arr.get(m-1) < target){
                    return m;
                }
                else if (arr.get(m) < target){
                    l = m+1;
                }
                else{
                    r = m-1;
                }
            } 
        }
        else{
            while (l<=r){
                m = (r-l)/2 + l;
                if (m == 0 || m == arr.size()-1 || arr.get(m) <= target && arr.get(m+1) > target){
                    return m;
                }
                else if (arr.get(m) < target){
                    l = m+1;
                }
                else{
                    r = m-1;
                }
            } 
        }
        
        return -1;
        
    }   
}

// ["MyCalendar","book","book","book","book","book","book","book","book","book","book"]
// [[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
