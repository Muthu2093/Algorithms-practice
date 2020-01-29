/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * Example 1:
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode leftPtr = head, rightPtr = head;
        
        while (rightPtr != null && rightPtr.next != null){
            while (rightPtr != null && leftPtr.val == rightPtr.val){
                rightPtr = rightPtr.next;
            }
            leftPtr.next = rightPtr;
            leftPtr = rightPtr;
        }
        
        return head;
    }
}
