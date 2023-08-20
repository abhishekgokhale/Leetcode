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
    public List<Integer> dfs(TreeNode node, List<Integer> leaves){
        if(node == null)
            return leaves;
        if(node.left == null && node.right == null)
            leaves.add(node.val);
        List<Integer> left = dfs(node.left, leaves);
        List<Integer> right = dfs(node.right, leaves);
        return leaves;
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = dfs(root1, new ArrayList<Integer>());
        List<Integer> leaves2 = dfs(root2, new ArrayList<Integer>());
        
        if(leaves1.size() != leaves2.size())
            return false;
        
        for(int i = 0; i < leaves1.size(); i++)
            if(leaves1.get(i) != leaves2.get(i))
                return false;
        return true;
    }
}