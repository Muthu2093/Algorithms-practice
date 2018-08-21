/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * Example:
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = findListLength(l1);
        int len2 = findListLength(l2);
        ListNode result = addTwoNumbersRec(l1, l2, len1, len2);
        return result.val == 0 ? result.next : result;
    }
    public int findListLength(ListNode head){
        ListNode fast = head;
        int count = 0;
        while (fast != null && fast.next != null){
            head = head.next;
            fast = fast.next.next;
            count++;
        }
        count = count*2;
        if(fast != null){
            count += 1;
        }
        return count;
    }
    public ListNode addTwoNumbersRec (ListNode l1, ListNode l2, int len1, int len2) {
        ListNode res = new ListNode(0);
        if (l1 == null && l2 == null){
            return res;
        }
        int a = l1.val, b = l2.val;
        if (len1 > len2){
            res.next = addTwoNumbersRec (l1.next, l2, --len1, len2);
            res.next.val += l1.val;
            if (res.next.val > 9){
                res.next.val %= 10;
                res.val += 1;
            }
        }
        else if (len1 < len2){
            res.next = addTwoNumbersRec (l1, l2.next, len1 , --len2);
            res.next.val += l2.val;
            if (res.next.val > 9){
                res.next.val %= 10;
                res.val += 1;
            }
        }
        else{
            res.next = addTwoNumbersRec (l1.next, l2.next, --len1, --len2);
            res.next.val += l1.val + l2.val;
            if (res.next.val > 9){
                res.next.val %= 10;
                res.val += 1;
            }
        }
        return res;
    }
}
