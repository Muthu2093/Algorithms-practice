/**
  * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
  * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
  * You may not modify the values in the list's nodes, only nodes itself may be changed.
  * Example 1:
  * Given 1->2->3->4, reorder it to 1->4->2->3.
  * Example 2:
  * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null){
            return;
        }
        Stack<ListNode> stack= new Stack<ListNode>();
        ListNode curr = head;
        int len = 1;
        boolean flag = false;
        while(curr != null){
            len++;
            stack.push(curr);
            curr = curr.next;
        }
        if (len%2 == 0){
            flag = true;
        }
        curr = head;
        for(len=len/2; len>1; len--){
            ListNode temp = curr.next;
            curr.next = new ListNode(stack.pop().val);
            curr.next.next = temp;
            //System.out.println(curr.val);
            curr = curr.next;
            //System.out.println(curr.val + "\n");
            curr=curr.next;
        }
        ListNode temp = curr.next;
        curr.next = new ListNode(stack.pop().val);
        curr.next.next = temp;
        if (flag){
            curr.next = null;
        }
        else{
            curr.next.next = null;
        }
    }
}
