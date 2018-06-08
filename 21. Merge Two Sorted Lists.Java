/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4 
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode(0);
        boolean flag = false;
        ListNode a = merged;
        
        // Checking for null list //
        if (l1 == null){
            return l2;
        }
        if (l2 ==null){
            return l1;
        }
        
        while(l1 != null && l2 != null){
            if (flag == true){
                System.out.println("here");
                merged.next = new ListNode(0);
                merged = merged.next;
            }
            flag = true;
            
            if(l1.val <= l2.val){
                merged.val = l1.val;
                l1 = l1.next;
            }
            
            else{
                merged.val = l2.val;
                l2 = l2.next;
            }
        }   
        
        // Copy remaining nodes //
        while(l1 != null){
            System.out.println(l1.val);
            merged.next = new ListNode(0);
            merged = merged.next;
            merged.val = l1.val;
            l1 = l1.next;
        }
        
        while(l2 != null){
            System.out.println(l2.val);
            merged.next = new ListNode(0);
            merged = merged.next;
            merged.val = l2.val;
            l2 = l2.next;
        }
        return a;
    }
}
