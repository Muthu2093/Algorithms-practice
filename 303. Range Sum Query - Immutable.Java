/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
 
class NumArray {
    public int[] sum_up_to, sum_from;
    public NumArray(int[] nums) {
        sum_up_to = new int[nums.length];
        sum_from = new int[nums.length];
        if (nums.length == 0){
            return;
        }
        sum_up_to[0] = nums[0];
        for (int i=1 ; i<nums.length; i++){
            sum_up_to[i] = sum_up_to[i-1] + nums[i];
        }
        for (int i=1 ; i<nums.length; i++){
            sum_from[i] = sum_from[i-1] + nums[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        //System.out.println(sum_up_to[j] + " - " + sum_from[i]);
        return sum_up_to[j]-sum_from[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
