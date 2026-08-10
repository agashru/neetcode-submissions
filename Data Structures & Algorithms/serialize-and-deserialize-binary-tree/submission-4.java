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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        solve(root, sb);
        return sb.toString();
    }

    public void solve(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");
        solve(root.left, sb);
        solve(root.right, sb);
    }

    // Decodes your encoded data to tree.
    int i = 0;
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return decode(arr);
    }

    public TreeNode decode(String[] arr){
        if (i >= arr.length || arr[i].equals("null")){
            i++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[i++]));
        node.left = decode(arr);
        node.right = decode(arr);
        return node;
    }
}
