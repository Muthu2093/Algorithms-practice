/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
 
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }
        int l=0, r=nums.length-1;
    
        if (nums[l] > nums[r]){
            l=1;
            while (l<=r){
                int m = (r-l)/2 + l;
                if (nums[m] < nums[m-1]){
                    if (nums[m] == target){
                        return m;
                    }
                    else if (nums[nums.length-1] >= target){
                        l=m;
                        r = nums.length-1;
                    }
                    else{
                        l = 0;
                        r=m-1;
                    }
                    break;
                }
                else if (nums[m] > nums[0]){
                    l = m+1;
                }
                else{
                    r = m-1;
                }
            }
        }
        
        // System.out.println(l + " : " + r);
        return binarySearch(nums, l, r, target);
    }
    
    public int binarySearch(int[] nums, int l, int r, int target){
        while (l<=r){
            int m = (r-l)/2 + l;
            if (nums[m] == target){
                return m;
            }
            else if (nums[m] < target){
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        
        return -1;
    }
}
