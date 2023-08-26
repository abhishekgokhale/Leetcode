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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        int ans = pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
        // System.out.println(ans);
        return ans + findPathSum(root, 0, targetSum);
    }
    
    private int findPathSum(TreeNode node, long currSum, int targetSum){
        if(node == null)
            return 0;
        if(node.left == null && node.right == null){
            if(currSum + node.val == targetSum)
                return 1;
            else
                return 0;
        }
        if(currSum + node.val == targetSum)
            return 1 + findPathSum(node.left, currSum + node.val, targetSum) + findPathSum(node.right, currSum + node.val, targetSum);
        return findPathSum(node.left, currSum + node.val, targetSum) + findPathSum(node.right, currSum + node.val, targetSum);
        
    }
}