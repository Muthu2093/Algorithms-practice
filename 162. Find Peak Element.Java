/** 
 * A peak element is an element that is greater than its neighbors.
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that nums[-1] = nums[n] = -∞.
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5 
 * Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 * Note:
 * Your solution should be in logarithmic complexity.
 */
 
class Solution {
    public int findPeakElement(int[] nums) {
        int r=nums.length-1;
        if (r==0 || nums[0]>nums[1]){
            return 0;
        }
        if (nums[r]>nums[r-1]){
            return r;
        }
        return findPeakRecurse(nums,0,r);
    }
    public int findPeakRecurse(int[] nums, int l, int r){
        int index = -1;
        int m = l+ (r-l)/2;
        if(l<=r){
            if (m>0 && m<nums.length-1 && nums[m]>nums[m-1] && nums[m]>nums[m+1]){
                return m;
            }
            index = findPeakRecurse(nums,l,m-1);
            if (index == -1){
                index = findPeakRecurse(nums,m+1,r);
            }
        }
        return index;
    }
}
