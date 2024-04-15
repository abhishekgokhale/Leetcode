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
    int answer = 0;
    public void calcRootToLeafSum(TreeNode root, int number) {
        if(root != null){
            number = number*10 + root.val;
            if(root.left == null && root.right == null)
                answer += number;
            calcRootToLeafSum(root.left, number);
            calcRootToLeafSum(root.right, number);
        }
    }
    public int sumNumbers(TreeNode root) {
        calcRootToLeafSum(root, 0);
        return answer;
    }
}