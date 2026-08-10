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
    Map<Integer, Integer> mp;
    int i;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        mp = new HashMap<>();
        int n = preorder.length;
        i = 0;
        for(int i = 0; i < n ; i++){
            mp.put(inorder[i], i);
        }
        return solve(preorder, 0,  n - 1);
    }

    public TreeNode solve(int[] preorder, int si , int ei){
        if(si > ei){
            return null;
        }

        int currVal = preorder[i++];
        int inorderIndex = mp.get(currVal);

        TreeNode node = new TreeNode(currVal);
        node.left = solve(preorder, si, inorderIndex - 1);
        node.right = solve(preorder, inorderIndex + 1, ei);
        return node;
    }
}
