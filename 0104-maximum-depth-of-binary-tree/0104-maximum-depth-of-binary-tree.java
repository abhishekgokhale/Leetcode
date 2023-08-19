/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int recurse(TreeNode node, int depth){
        if(node == null)
            return depth - 1;
        int left = recurse(node.left, depth + 1);
        int right = recurse(node.right, depth + 1);
        return Math.max(left, right);
    }
    public int maxDepth(TreeNode root) {
        return recurse(root, 1);
    }
}