# Given two arrays, write a function to compute their intersection.
# Example 1:
# Input: nums1 = [1,2,2,1], nums2 = [2,2]
# Output: [2]
# Example 2:
# Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
# Output: [9,4]
# Note:
# Each element in the result must be unique.
# The result can be in any order.

class Solution(object):
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        if (nums1 == None or nums2 == None):
            return []
        
        nums1 = set(nums1)
        nums2 = list(set(nums2))
        res = []
        
        for c in nums2:
            if (c in nums1):
                res.append(c)
                
        return res
            
