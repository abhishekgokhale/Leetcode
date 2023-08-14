# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        def rec(node, depth):
            if not node:
                return depth - 1
            if not node.left and not node.right:
                return depth
            left, right = depth, depth
            if node.left:
                left = rec(node.left, depth + 1)
            if node.right:
                right = rec(node.right, depth + 1)
            return max(left, right)
        return rec(root, 1)