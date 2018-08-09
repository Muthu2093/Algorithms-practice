# Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
# Note: A leaf is a node with no children.
# Example:
# Given the below binary tree and sum = 22,
#       5
#      / \
#     4   8
#    /   / \
#   11  13  4
# /  \      \
# 7    2      1
# return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def hasPathSum(self, root, sums):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        curr = 0
        return self.pathSum(root, curr, sums)
    
    def pathSum(self, root, curr, sums):
        if (root == None):
            return False
        curr += root.val
        if (curr == sums and root.left == None and root.right == None):
            return True
        
        return self.pathSum(root.left, curr, sums) or self.pathSum(root.right, curr, sums)
        
