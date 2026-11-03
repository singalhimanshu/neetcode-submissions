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
    public int kthSmallest(TreeNode root, int k) {
        assert root != null;
        TreeNode cur = root;
        final Stack<TreeNode> stk = new Stack<>();
        while (!stk.isEmpty() || cur != null) {
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            cur = stk.pop();
            k--;
            if (k == 0) {
                return cur.val;
            }
            cur = cur.right;
        }
        assert false;
        return -1;
    }
}
