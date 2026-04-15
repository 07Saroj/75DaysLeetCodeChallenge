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
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        traverse(root);
        return maxSum;
    }
    int traverse(TreeNode root){
        if(root==null) return 0;
        
        int left=Math.max(traverse(root.left),0);
        int right=Math.max(traverse(root.right),0);
        int sum=left+root.val+right;

        maxSum=Math.max(maxSum,sum);
        return root.val + Math.max(left,right);
        
    }
}