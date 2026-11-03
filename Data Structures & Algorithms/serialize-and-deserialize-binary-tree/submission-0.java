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
        if (root == null) {
            return "N";
        }
        final StringBuilder sb = new StringBuilder();
        final Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("N,");
            } else {
                sb.append(node.val).append(",");
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        if ("N".equals(vals[0])) return null;
        int idx = 0;
        TreeNode root = new TreeNode(Integer.parseInt(vals[idx++]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (!vals[idx].equals("N")) {
                curr.left = new TreeNode(Integer.parseInt(vals[idx]));
                q.add(curr.left);
            }
            idx++;
            if (!vals[idx].equals("N")) {
                curr.right = new TreeNode(Integer.parseInt(vals[idx]));
                q.add(curr.right);
            }
            idx++;
        }
        return root;
    }
}
