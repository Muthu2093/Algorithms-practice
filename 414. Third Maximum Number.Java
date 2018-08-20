/**
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 * Example 1:
 * Input: [3, 2, 1]
 * Output: 1
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 * Output: 2
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 * Output: 1
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */

class Solution {
    public int thirdMax(int[] nums) {
        int len = nums.length;
        if (len < 3){
            int res = (len == 1 || (nums[0] > nums[1])) ? nums[0]: nums[1];
            return res;
        }
        ListNode res = new ListNode(-123);
        ListNode ptr = res;
        
        for (int i=0; i<len; i++){
            ListNode curr = ptr;
            int itr = 3;
            while (itr > 0){
                if (curr.next == null){
                    curr.next = new ListNode(nums[i]);
                    break;
                }   
                if (curr.next.val == nums[i]){
                    break;
                }             
                if (nums[i] > curr.next.val){
                    ListNode temp = new ListNode(nums[i]);
                    temp.next = curr.next;
                    curr.next = temp;
                    break;
                }
                curr = curr.next;
                itr--;
            }
        }
        if (ptr.next.next == null || ptr.next.next.next == null){
            return ptr.next.val;
        }
        return ptr.next.next.next.val;
    } 
}
