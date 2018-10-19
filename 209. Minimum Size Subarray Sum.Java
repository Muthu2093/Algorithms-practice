/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * Example: 
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
 */
 
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0;
        int currSum = 0, count = Integer.MAX_VALUE;
        
        while(left < nums.length && left <= right){
            while (currSum < s){
                if (right < nums.length){
                    currSum += nums[right++];
                }
                else{
                    break;
                }
            }
            if (currSum >= s){
                count = Math.min(count, right-left);
            }
            currSum -= nums[left];
            left++;
                
        }
        
        return count == Integer.MAX_VALUE? 0 : count;
    }
}
