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
    List<Integer> nodes = new ArrayList<>();
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        preorder(root);
        root.left = null;
        TreeNode curr = root;
        for(int i = 1; i < nodes.size(); i++){
            curr.right = new TreeNode(nodes.get(i), null, null);
            curr = curr.right;
        }
    }
    
    private void preorder(TreeNode root){
        if(root == null)
            return;
        nodes.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}