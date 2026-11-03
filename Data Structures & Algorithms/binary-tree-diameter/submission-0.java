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
    int maxDepth = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        solve(root);
        return maxDepth;
    }

    private int solve(TreeNode root) {
        if (root == null) return 0;
        int ld = solve(root.left);
        int rd = solve(root.right);
        maxDepth = Math.max(maxDepth, ld + rd);
        return 1 + Math.max(ld, rd);
    }
}
