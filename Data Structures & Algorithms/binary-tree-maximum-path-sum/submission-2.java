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
    int ans = 0;
    public int maxPathSum(TreeNode root) {
        ans = root.val;
        solve(root);
        return ans;
    }

    private int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, solve(root.left));
        int right = Math.max(0, solve(root.right));
        ans = Math.max(ans, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
