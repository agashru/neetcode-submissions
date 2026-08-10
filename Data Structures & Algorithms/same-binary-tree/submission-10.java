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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(p);
        q2.add(q);

        while(!q1.isEmpty() && !q2.isEmpty()){
            TreeNode currP = q1.poll();
            TreeNode currQ = q2.poll();

            if(currP == null && currQ == null){
                continue;
            }

            if(currP == null || currQ == null || currP.val != currQ.val){
                return false;
            }
           
            q1.add(currP.left);           
            q1.add(currP.right);
            q2.add(currQ.left);           
            q2.add(currQ.right);
        }
        return true;
    }
}
