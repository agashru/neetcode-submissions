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
    int idx = 0;
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeString(root,sb);
        return sb.toString();
    }

    public void serializeString(TreeNode root, StringBuilder sb) {
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");
        serializeString(root.left, sb);
        serializeString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return deserializeString(arr);
    }

    public TreeNode deserializeString(String[] arr){
        if(idx >= arr.length || arr[idx].equals("null")){
            idx++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
        node.left = deserializeString(arr);
        node.right = deserializeString(arr);
        return node;
    }
}
