/**
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
 * Example 1:
 * Input: ["23:59","00:00"]
 * Output: 1
 * Note:
 * The number of time points in the given list is at least 2 and won't exceed 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 */
 
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int min = 1440, len = timePoints.size();
        int[] res = new int[len];
        for (int i=0; i<len; i++){
            String str = timePoints.get(i);
            res[i] = (Integer.parseInt(str.substring(0,2)) * 60 + Integer.parseInt(str.substring(3,5)));
            System.out.println(res[i]);
        }
        Arrays.sort(res);
        int i, temp;
        for (i=1; i<len; i++){
            temp = res[i]-res[i-1];
            System.out.println(temp);
            if (temp > 720){
                temp = 1440 - temp;
            }
            min = Math.min(min, temp);
        }
        temp = res[i-1]-res[0];
        if (temp > 720){
                temp = 1440 - temp;
        }
        min = Math.min(min, temp);
        return min;
    }
}
