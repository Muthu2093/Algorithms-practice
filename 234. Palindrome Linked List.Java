/**
 * Given a singly linked list, determine if it is a palindrome.
 * Example 1:
 * Input: 1->2
 * Output: false
 * Example 2:
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        
        ListNode ptr = head, prev = head;
        int len = 0;
        while(ptr != null){
            len++;
            ptr = ptr.next;
        }     
        
        ptr = prev.next;
        for (int i=1; i<len/2;i++){
            ListNode temp = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = temp;
        }
        
        head.next = ptr;
        ptr = head;
        head = prev;
        ptr = ptr.next;
        if (len %2 != 0){
            ptr = ptr.next;
        }
        
        while (ptr != null){
            if (head.val != ptr.val){
                return false;
            }
            ptr = ptr.next;
            head = head.next;
        }
        return true;
    }
}
