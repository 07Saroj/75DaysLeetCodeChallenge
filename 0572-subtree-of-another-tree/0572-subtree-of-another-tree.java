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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // If root is null, subRoot cannot be within it
        if (root == null) return false;
        
        // 1. Check if the trees starting at these nodes are identical
        if (isSameTree(root, subRoot)) return true;
        
        // 2. If not, check the left and right children of the main tree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        // Both are null -> identical
        if (p == null && q == null) return true;
        
        // One is null or values differ -> not identical
        if (p == null || q == null || p.val != q.val) return false;
        
        // Recursively check left and right children
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}