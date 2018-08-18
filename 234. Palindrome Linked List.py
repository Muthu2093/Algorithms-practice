# Given a singly linked list, determine if it is a palindrome.
# Example 1:
# Input: 1->2
# Output: false
# Example 2:
# Input: 1->2->2->1
# Output: true
# Follow up:
# Could you do it in O(n) time and O(1) space?

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Solution using Recrusion in python
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if (head == None):
            return True
        
        ptr = head
        [flag,ptr] = self.checkPalindromeRec (ptr,head)
        return flag
    
    def checkPalindromeRec(self, ptr, head):
        if (head.next == None):
            return [head.val == ptr.val, ptr]
        
        [flag, ptr] = self.checkPalindromeRec(ptr, head.next)
        return [flag and (ptr.next.val == head.val), ptr.next]
        
        
        
# Solution using recursion in Java
'''
class Solution {
    static boolean flag;
    
    public boolean isPalindrome(ListNode head) {
        flag = true;
        if (head != null){
            ListNode ptr =  checkPalindromeRec(head,head);
        }
        return flag;
    }
    public ListNode checkPalindromeRec(ListNode ptr, ListNode head){
        if (head.next == null){
            flag = flag && (ptr.val == head.val);
            return ptr.next;
        }
        ptr = checkPalindromeRec(ptr,head.next);
        flag = flag && ptr.val == head.val;
        return ptr.next;
    }
}
'''
