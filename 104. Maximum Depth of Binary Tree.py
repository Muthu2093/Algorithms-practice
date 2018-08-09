# Given a binary tree, find its maximum depth.
# The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
# Note: A leaf is a node with no children.
# Example:
# Given binary tree [3,9,20,null,null,15,7],
#     3
#    / \
#   9  20
#     /  \
#    15   7
# return its depth = 3.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        lheight = 0
        rheight = 0
        return self.maxDepthRec(root, lheight, rheight)
    
    def maxDepthRec(self, root, lheight, rheight):
        if (root == None):
            return 0
        if (root.right == None and root.left == None):
            return 1
        
        lheight = self.maxDepthRec(root.left, lheight, rheight) + 1
        rheight = self.maxDepthRec(root.right, lheight, rheight) + 1
        
        return lheight if (lheight >= rheight) else rheight
