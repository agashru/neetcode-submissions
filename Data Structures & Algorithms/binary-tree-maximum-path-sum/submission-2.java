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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }

    public int solve(TreeNode root){
        if(root == null){
            return 0;
        }

        int lp = solve(root.left);
        int rp = solve(root.right);
        int case1 = lp + rp + root.val;
        int case2 = Math.max(lp, rp) + root.val;
        int case3 = root.val;
        maxSum = Math.max(maxSum, Math.max(case1, Math.max(case2, case3)));
        return Math.max(case2, case3);
    }
}
