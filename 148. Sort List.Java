/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
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

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode middle = splitList(head);
        return merge(sortList(head), sortList(middle));
    }
    
    public ListNode splitList(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        return fast;
    }
    
    public ListNode merge(ListNode a, ListNode b){
        ListNode sorted = new ListNode(0);
        ListNode ptr = sorted;
        while (a != null && b != null){
            if (a.val <= b.val){
                sorted.next = new ListNode(a.val);
                a = a.next;
            }
            else{
                sorted.next = new ListNode(b.val);
                b = b.next;
            }
            sorted = sorted.next;
        }
        if (a != null){
            sorted.next = a;
        }
        else if (b != null){
            sorted.next = b;
        }
        return ptr.next;
    }
        
}
