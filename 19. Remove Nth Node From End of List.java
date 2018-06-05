/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// Two passes through list //
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 1;
        ListNode current = head;
        
        // Counts the number of nodes in the list //
        while(current.next != null){
            count = count + 1;
            current = current.next;
        }
        
        n = count-n;
        current = head;
        ListNode previous = current;
        
        while (n!=0 ){
            n=n-1;
            previous = current;
            current = current.next;
        }
        
        if(current==head){
            head = head.next;
            return head;
        }
        
        if(previous.next.next == null){
            previous.next = null;
            return head;
        }
        
        previous.next = previous.next.next;
        return head;   
    }
}
