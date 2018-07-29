
/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * Example:
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null){
            return head;
        }
        if (head.next == null || m==n){
            return head;
        }
        ListNode left = new ListNode(0);
        left.next = head;
        ListNode lpointer = left;
        ListNode right = null;
        ListNode rpointer = null;
        int temp = 1;
        while (temp < m){
            head = head.next;
            left = left.next;
            temp ++;
        }
        while(head != null && temp <=n){
            temp++;
            if (right == null){
                right = new ListNode(head.val);
                head = head.next;
            }
            else{
                if (rpointer == null){
                    rpointer = right;
                }
                left.next = new ListNode(head.val);
                left.next.next = right;
                right = left.next;
                head = head.next;
            }
        }
        if (head != null && rpointer != null){
            rpointer.next = head;
        }
        return lpointer.next;
    }
}
