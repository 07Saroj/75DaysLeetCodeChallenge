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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ls= new ArrayList<>();
        if(root==null) return ls;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean flag=true;
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> in =new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode curr=q.poll();
                in.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(!flag) Collections.reverse(in);
            ls.add(in);
            flag=!flag;
        }

        return ls;

    }
}