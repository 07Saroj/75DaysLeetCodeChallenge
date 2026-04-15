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
    
    public void flatten(TreeNode root) {
        if(root==null) return;
        List<TreeNode> ls=new ArrayList<>();
        preorder(root,ls);
        TreeNode curr=root;
        for(int i=1;i<ls.size();i++){
            curr.left=null;
            curr.right=ls.get(i);
            curr=curr.right;
        }
        
    }

    void preorder(TreeNode root,List<TreeNode> ls){
        if(root==null) return;
        ls.add(root);
        preorder(root.left,ls);
        preorder(root.right,ls);
    }
}