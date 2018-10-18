/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * Example:
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4 
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
 * Note:
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
 
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 1){
            return 0;
        }
        int[] endElems = new int[nums.length];
        int len=1;
        endElems[0] = Integer.MAX_VALUE;
        
        for (Integer elem:nums){
            if (elem <= endElems[0]){
                endElems[0] = elem;
            }
            else if (elem > endElems[len-1]){
                endElems[len] = elem;
                len++;
            }
            else{
                int index = binarySearch(endElems, 0, len-1, elem);
                endElems[index] = elem;
            }
        }
        return len;
    }
    
    public int binarySearch(int[] arr, int l , int r, int target){
        
        while(l<r){
            int m = ((r+l)/2)+1;
            if (arr[m] == target || arr[m] > target && arr[m-1] < target){
                return m;
            }
            else if (arr[m] < target){
                l = m;
            }
            else{
                r = m-1;
            }
        }
        return -1;
    }
}
