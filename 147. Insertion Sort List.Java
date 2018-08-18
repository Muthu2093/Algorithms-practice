/**
 * Sort a linked list using insertion sort.
 * The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 * Algorithm of Insertion Sort:
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        head.next = insertionSortList(head.next);
        ListNode temp = head.next;
        if (head.val <= temp.val){
            return head;
        }
        else if (temp.next == null){
            head.next = null;
            temp.next = head;
            return temp;
        }
        while (temp.next != null && temp.next.val < head.val){
            temp = temp.next;
        }
        ListNode pointer = head.next;
        head.next = temp.next;
        temp.next = head;
        return pointer;
    }
}
