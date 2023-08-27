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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int direction = 0;
        while(!queue.isEmpty()){
            ans.add(new ArrayList<Integer>());
            int levelLen = queue.size();
            for(int level = 0; level < levelLen; level++){
                TreeNode node = queue.remove();
                ans.get(ans.size() - 1).add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            if (direction == 0)
                direction = 1;
            else {
                direction = 0;
                Collections.reverse(ans.get(ans.size() - 1));
            }
        }
        return ans;
    }
}