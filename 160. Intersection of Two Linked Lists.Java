 /**
  * Write a program to find the node at which the intersection of two singly linked lists begins.
  * For example, the following two linked lists:
  * A:          a1 → a2
  *                    ↘
  *                      c1 → c2 → c3
  *                    ↗            
  * B:     b1 → b2 → b3
  * begin to intersect at node c1.
  * Notes:
  * If the two linked lists have no intersection at all, return null.
  * The linked lists must retain their original structure after the function returns.
  * You may assume there are no cycles anywhere in the entire linked structure.
  * Your code should preferably run in O(n) time and use only O(1) memory.
  * Credits:
  * Special thanks to @stellari for adding this problem and creating all test cases.
  */
  
  public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        boolean flag1=false, flag2=false;
        ListNode pointer1 = headA;
        ListNode pointer2 = headB;
        while(pointer1 != null && pointer2 != null){
            if (pointer1 == pointer2){
                return pointer1;
            }
            if (pointer1.next != null || flag1){
                pointer1 = pointer1.next;
            }
            else{
                pointer1 = headB;
                flag1 = true;
            }
            if (pointer2.next != null || flag2){
                pointer2 = pointer2.next;
            }
            else{
                pointer2 = headA;
                flag2=true;
            }
        }
        return null; 
    }
}
