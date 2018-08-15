/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 *  * Output: [3,4]
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
 
 class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ind = new int[2];
        ind[0] = -1;
        ind[1] = -1;
        int l=0, r=nums.length-1, m = 0;
        while (l<=r){
            m = (r+l)/2;
            if (nums[m] == target && (m == 0 || nums[m-1] != target)){
                ind[0] = m;
                break;
            }
            else if (nums[m] < target){
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        l = m;
        r = nums.length-1;
        while (l<=r){
            m = (r+l)/2;
            if (nums[m] == target && (m+1 == nums.length || nums[m+1] != target)){
                ind[1] = m;
                break;
            }
            else if (nums[m] > target){
                r = m-1;
            }
            else {
                l = m+1;
            }
        }
        return ind;
    }
}
