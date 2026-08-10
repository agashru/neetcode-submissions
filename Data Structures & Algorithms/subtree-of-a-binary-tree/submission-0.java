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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }

        if(isIdentical(root, subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isIdentical(TreeNode node1, TreeNode node2) {
        Queue<TreeNode> q2 = new LinkedList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(node1);
        q2.add(node2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            for (int i = q1.size(); i > 0; i--) {
                TreeNode nodeP = q1.poll();
                TreeNode nodeQ = q2.poll();

                if (nodeP == null && nodeQ == null) {
                    continue;
                }
                if (nodeP == null || nodeQ == null || nodeP.val != nodeQ.val) {
                    return false;
                }

                q1.add(nodeP.left);
                q1.add(nodeP.right);
                q2.add(nodeQ.left);
                q2.add(nodeQ.right);
            }
        }
        return true;

    }
}
