/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * Example 1:
 * Input: [3,4,5,1,2] 
 * Output: 1
 * Example 2:
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */
 
class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length;
        if (r == 1 || nums[0]<nums[r-1]){
            return nums[0];
        }
        if (r == 2){
            if (nums[0]>nums[1]){
                return nums[1];
            }
            return -1;
        }
        return nums[recurse(l,r-1,nums)];
    }
    
    public int recurse(int l, int r, int[] nums){
        if (r>=l){
            int mid = ((r-l)/2) + l;
            if (mid != 0 && nums[mid-1] > nums[mid]){
                return mid;
            }
            int flag = recurse(mid+1, r, nums);
            if(flag == -1){
                return recurse(l, mid-1, nums);
            }
            return flag;
        }
        return -1;
    }
}
