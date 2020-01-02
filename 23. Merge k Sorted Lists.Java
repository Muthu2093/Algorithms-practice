/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length-1);
    }
    
    public ListNode mergeKLists(ListNode[] lists, int l, int r){
        if (l == r){
            return lists[l];
        }
        
        if (l < r){
            int m = (r-l)/2 + l;
            ListNode leftList = mergeKLists(lists, l, m);
            ListNode rightList = mergeKLists(lists, m+1, r);
            return mergeTwoLists(leftList, rightList);
        } 
        
        return null;
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode root = new ListNode(0), ptr = root;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                root.next = l1;
                l1 = l1.next;
            } else {
                root.next = l2;
                l2 = l2.next;
            }
            root = root.next;
        }
        if (l1 != null){
            root.next = l1;
        } else if (l2 != null){
            root.next = l2;
        }
        
        return ptr.next;
    }
}
