/**
 * Reverse a singly linked list.
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
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
    public ListNode reverseList(ListNode head){
        ListNode rev = reverse(head, null);
        return rev;
    }
    public ListNode reverse(ListNode head, ListNode tail){
        if (head == null){
            return tail;
        }
        if (tail != null){
            System.out.println(tail.val);
        }
        ListNode next = head.next;
        head.next = tail;
        ListNode temp = reverse(next,head);
        return temp;
    }
}
