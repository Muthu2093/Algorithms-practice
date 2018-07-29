/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Note:
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode curr = new ListNode(0);
        ListNode temp = new ListNode(0);
        curr.next = head;
        head = curr;
        while(curr.next != null && curr.next.next != null){
            temp = curr.next.next.next;
            curr.next.next.next = curr.next;
            curr.next = curr.next.next;
            curr.next.next.next = temp;
            curr = curr.next.next;
        }
        return head.next;
        
    }
}
