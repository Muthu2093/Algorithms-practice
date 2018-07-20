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
        if (head == null){
            return head;
        }
        ListNode curr = head;
        ListNode prev = head;
        while(curr.next != null){
            while (curr.val == curr.next.val){
                curr = curr.next;
                if (curr.next == null){
                    break;
                }
            }
            if (curr.next == null){
                curr = null;
            }
            else{
                curr = curr.next;
            }
            prev.next = curr;
            prev = prev.next;
            if (curr == null){
                break;
            }
        }
        return head;
    }
}
