/**
* Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
* You should preserve the original relative order of the nodes in each of the two partitions.
* Example:
* Input: head = 1->4->3->2->5->2, x = 3
* Output: 1->2->2->4->3->5
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * } check for 1st larger node
 */
 
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode small = new ListNode(0);
        ListNode spointer = small;
        ListNode large = new ListNode(0);
        ListNode lpointer = large;
        while (head != null){
            if (head.val < x){
                small.next = new ListNode(head.val);
                small = small.next;
                head = head.next;
            }
            else{
                large.next = new ListNode(head.val);
                large = large.next;
                head = head.next;
            }
        }
        small.next = lpointer.next;
        return spointer.next;
    }
}
