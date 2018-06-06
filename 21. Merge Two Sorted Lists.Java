/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode(0);
        int i=1;
        while(l1 != null && l2 != null){
            //System.out.println(l1.val + ":" + l2.val);
            if (l1.val <= l2.val){
                //System.out.println("l1: " + l1.val);
                merged.val = l1.val;
                merged = merged.next;
                me
                l1 = l1.next;
                //System.out.println("l1: " + l1.val);
            }
            //System.out.println(l1.val + ":" + l2.val);
            if (l1.val >= l2.val){
                System.out.println("1:l2: " + l2.val + " l1: " + l1.val);
                merged.val = l2.val;
                System.out.println("2:l2: " + l2.val + " l1: " + l1.val);
                merged = merged.next;
                System.out.println("3:l2: " + l2.val + " l1: " + l1.val);
                l2 = l2.next;
                System.out.println("4:l2: " + l2.val + " l1: " + l1.val);
            }
            //System.out.println(l1.val + ":" + l2.val);
        }
        return merged;
    }
}

 //if (l2.next == null){
                //    break;
                //}
