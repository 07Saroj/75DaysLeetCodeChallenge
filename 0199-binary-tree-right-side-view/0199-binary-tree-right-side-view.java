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
    List<Integer> l=new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        rightView(root,0);
        return l;
    }
    void rightView(TreeNode root,int level){
        if(root==null) return;
        if(l.size()==level){
            l.add(root.val);
        }
        rightView(root.right,level+1);
        rightView(root.left,level+1);
    }
}