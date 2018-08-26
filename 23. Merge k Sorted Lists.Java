/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0){
            return null;
        }
        if (len == 1){
            return lists[0];
        }
        ListNode curr = new ListNode(0);
        curr.next = mergeLists(lists[0], lists[1]);
        for (int i=2; i<len; i++){
            curr.next = mergeLists(curr.next, lists[i]);
        }
        return curr.next;
    }
    public ListNode mergeLists(ListNode l1, ListNode l2){
        ListNode curr = new ListNode(0);
        ListNode ptr = curr;
        while(l1 != null && l2 != null){
            if (l1.val < l2.val){
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else{
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curr = curr.next;
        }
        while (l1 != null){
            curr.next = new ListNode(l1.val);
            curr = curr.next;
            l1 = l1.next;
        }
        while (l2 != null){
            curr.next = new ListNode(l2.val);
            curr = curr.next;
            l2 = l2.next;
        }
        return ptr.next;
    }
}
