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
    PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
    int k;
    
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        preorder(root);
        return heap.peek();
        
    }
    private void preorder(TreeNode node) {
        if(node == null)
            return;
        heap.add(node.val);
        if(heap.size() > k)
            heap.remove();
        if(node.left != null)
            preorder(node.left);
        if(node.right != null)
            preorder(node.right);
    }
}