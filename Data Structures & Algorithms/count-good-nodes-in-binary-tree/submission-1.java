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
    class Pair{
        TreeNode node;
        int maxValue;
        public Pair(TreeNode node, int maxValue){
            this.node = node;
            this.maxValue = maxValue;
        }
    }
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        int count = 0;
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, Integer.MIN_VALUE));
        while(!st.isEmpty()){
            Pair curr = st.pop();
            if(curr.node.val >= curr.maxValue){
                count++;
            }

            if(curr.node.left != null){
                st.push(new Pair(curr.node.left, Math.max(curr.maxValue, curr.node.val)));
            }

            if(curr.node.right != null){
                st.push(new Pair(curr.node.right, Math.max(curr.maxValue, curr.node.val)));
            }
        }
        return count;
    }
}
