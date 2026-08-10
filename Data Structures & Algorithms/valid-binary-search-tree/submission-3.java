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
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;

        while(!st.isEmpty() || curr != null){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();

            if(prev != null && prev.val >= curr.val){
                return false;
            }
            prev = curr;
            curr = curr.right;
        }
        return true;
    }
}
