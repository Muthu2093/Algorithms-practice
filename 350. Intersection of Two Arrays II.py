# Given two arrays, write a function to compute their intersection.

# Example:
# Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

# Note:
# Each element in the result should appear as many times as it shows in both arrays.
# The result can be in any order.
# Follow up:
# What if the given array is already sorted? How would you optimize your algorithm?
# What if nums1's size is small compared to nums2's size? Which algorithm is better?
# What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        if (nums1 == None or nums2 == None):
            return []
        if (len(nums1) > len(nums2)):
            x = nums2
            y = nums1
        else:
            y = nums2
            x = nums1
                
        res = []
        for c in x:
            if (c in y):
                res.append(c)
                y.remove(c)
                
        return res
