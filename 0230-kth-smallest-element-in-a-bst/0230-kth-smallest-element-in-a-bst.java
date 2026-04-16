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
    int kthele=0,count=0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return kthele;
    }
     void inorder(TreeNode root,int k){
        if(root==null) return;

        inorder(root.left,k);
        count++;
        if(count==k){
            kthele=root.val;
        }
        
        inorder(root.right,k); 
    }

    // public int kthSmallest(TreeNode root, int k) {
    //     List<Integer> ls=new ArrayList<>();
    //     inorder(root,ls);
    //     return ls.get(k-1);
    // }
    // void inorder(TreeNode root,List<Integer> ls){
    //     if(root==null) return;

    //     inorder(root.left,ls);
    //     ls.add(root.val);
    //     inorder(root.right,ls); 
    // }
}