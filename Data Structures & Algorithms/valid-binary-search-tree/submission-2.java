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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean isValidBST(TreeNode cur, int max, int min) {
        if (cur == null) {
            return true;
        }
        if (cur.val >= max || cur.val <= min) {
            return false;
        }
        return isValidBST(cur.left, cur.val, min) &&
         isValidBST(cur.right, max, cur.val);
    }
}
