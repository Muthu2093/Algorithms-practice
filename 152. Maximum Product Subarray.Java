/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * Example 1:
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
 
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        
        int[] minSoFar = new int[nums.length];
        int[] maxSoFar = new int[nums.length];
        int maxProd = nums[0];
        maxSoFar[0] = nums[0];
        minSoFar[0] = nums[0];

        for (int i=1; i<nums.length; i++){
            
            minSoFar[i] = Math.min(nums[i], nums[i]*minSoFar[i-1]);
            maxSoFar[i] = Math.max(nums[i], nums[i]*maxSoFar[i-1]);
            maxSoFar[i] = Math.max(maxSoFar[i], nums[i]*minSoFar[i-1]);
            minSoFar[i] = Math.min(minSoFar[i], nums[i]*maxSoFar[i-1]);
            
            maxProd = Math.max(maxProd, maxSoFar[i]);
        }
        
        
        return maxProd;
    }
}
