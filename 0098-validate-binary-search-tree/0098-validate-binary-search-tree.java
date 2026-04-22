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
    public boolean isValidBST(TreeNode root) {
        return valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    //recursion
    boolean valid(TreeNode root, long min,long max){
        if(root==null) return true;
        if(root.val <=min || root.val>=max) return false;
        return valid(root.left,min,root.val) && valid(root.right,root.val,max);

    }

    // public boolean isValidBST(TreeNode root) {
    //     List<Integer> ls=new ArrayList<>();
    //     if(root==null) return true;  
    //     inorder(root,ls);

    //     for(int i=1;i<ls.size();i++){
    //         if(ls.get(i)<=ls.get(i-1)) return false;
    //     }
    //     return true;
    // }
    
    // void inorder(TreeNode root,List<Integer> ls){
    //     if(root==null) return;

    //     inorder(root.left,ls);
    //     ls.add(root.val);
    //     inorder(root.right,ls); 
    // }
}