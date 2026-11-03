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
    int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length - 1, inorderMap);
    }

    private TreeNode dfs(int[] preorder, int l, int r, Map<Integer, Integer> map) {
        if (l > r) return null;
        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);
        int inorderIdx = map.get(rootVal);
        root.left = dfs(preorder, l, inorderIdx - 1, map);
        root.right = dfs(preorder, inorderIdx + 1, r, map);
        return root;
    }
}
