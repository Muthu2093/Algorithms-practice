/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Note: Do not modify the linked list.
 * Follow up:
 * Can you solve it without using extra space?
 */
 
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
 // Using three pointers - fastest algorithm //
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow = head, fast = head, begin = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                while(begin != slow){
                    slow = slow.next;
                    begin = begin.next;
                }
                return begin;
            }
        }
        return null;
    }
}

// Using HashMap - comparitively slower //

public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> map = new HashSet<>();
        while (head != null){
            if (map.contains(head)){
                return head;
            }
            map.add(head);
            head = head.next;
        }
        return null;
    }
}
