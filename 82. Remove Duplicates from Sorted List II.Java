 /**
  * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
  * Example 1:
  * Input: 1->2->3->3->4->4->5
  * Output: 1->2->5
  * Example 2:
  * Input: 1->1->1->2->3
  * Output: 2->3
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
        if (head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        boolean flag = false;
        while (curr != null){
            if (curr.next == null){
                break;
            }
            while (curr.val == curr.next.val){
                flag = true;
                curr = curr.next;
                if (curr.next == null){
                    break;
                }
            }
            if (flag == true){
                if (curr.next == null){
                    curr = null;
                }
                else{
                    curr = curr.next;
                }
                if (prev != null){
                    prev.next = curr;
                }
                else{
                    head = curr;
                }
            }
            if(flag == false){
                prev = curr;
                curr = curr.next;
            }
            flag = false;
        }
        if (head == null){
            return head;
        }
        if (head.next == null){
            return head;
        }
        if (head.val == head.next.val){
            return head.next.next;
        }
        return head;
    }
}
