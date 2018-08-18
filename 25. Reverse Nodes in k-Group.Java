/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * Example:
 * Given this linked list: 1->2->3->4->5 
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * Note:
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2 || head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        int len = 1;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            len++;
        }
        len = (2*len) - (fast.next == null ? 1 : 0);
        int noOfGroups = len/k;
        if (noOfGroups != 0){
            return Recurse(head, noOfGroups, k);
        }
        return head;
    }
    public ListNode Recurse(ListNode head, int n, int k){
        n--;
        ListNode[] index = new ListNode[2];
        index = reverse(head, k);
        if (n > 0){
            index[1].next = Recurse(index[1].next, n, k);
        }
        return index[0];
    }
    
    public ListNode[] reverse(ListNode head, int k){
        ListNode left = new ListNode(0);
        ListNode right = null;
        ListNode rightPtr = left;; 
        while (k > 0){
            if (right == null){
                right = new ListNode(head.val);
                rightPtr = right;
                head = head.next;
                k--;
            }
            left.next = new ListNode(head.val);
            left.next.next = right;
            right = left.next;
            head = head.next;
            k--;
        }
        rightPtr.next = head;
        ListNode[] index = {left.next, rightPtr};
        return index;
    }
}
