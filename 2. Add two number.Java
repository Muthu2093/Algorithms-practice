/ **
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

/ **
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int s1 = 0, s2 = 0;]
        int carry = 0, i=1;
        ListNode a = new ListNode(0);
        ListNode Sum = new ListNode(0);
        a = Sum;
        while (l1 != null && l2 != null){
            if (i == 2){
                Sum.next = new ListNode(0);
                Sum = Sum.next;
            }
            s1 = l1.val;
            l1 = l1.next;
            s2 = l2.val;
            l2 = l2.next;
            
            Sum.val = (s1 + s2 + carry) % 10;
            if (s1+s2+carry> 9){
                carry = 1;
            }
            else{
                carry = 0;
            }
            i = 2;
            
        } 
        while (l2 != null){
            s2 = l2.val;
            l2 = l2.next;
            
            if (i == 2){
                Sum.next = new ListNode(0);
                Sum = Sum.next;
            }
            
            Sum.val = (s2 + carry) % 10;
            if (s2+carry> 9){
                carry = 1;
            }
            else{
                carry = 0;
            }
            i = 2;
        }
        while (l1 != null){
            s1 = l1.val;
            l1 = l1.next;
            
            if (i == 2){
                Sum.next = new ListNode(0);
                Sum = Sum.next;
            }
            
            Sum.val = (s1 + carry) % 10;
            if (s1+carry> 9){
                carry = 1;
            }
            else{
                carry = 0;
            }
            i = 2;
        }
        if (carry == 1){
            Sum.next = new ListNode(0);
            Sum = Sum.next;
            Sum.val = carry;
        }
        return a;
    }
}
