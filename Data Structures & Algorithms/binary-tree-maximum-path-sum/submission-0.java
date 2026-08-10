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
    private int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        gainFromSubtree(root);
        return maxSum;
    }

    private int gainFromSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = gainFromSubtree(root.left);
        int r = gainFromSubtree(root.right);

        int case1 = l + r + root.val; //(when we get good sum from both root and right)
        int case2 = Math.max(l,r) + root.val; //(when we get good sum from either one)
        int case3 = root.val; //only root

        maxSum = Math.max(maxSum, Math.max(case1, Math.max(case2, case3)));
        return Math.max(case2, case3);
    }
}
