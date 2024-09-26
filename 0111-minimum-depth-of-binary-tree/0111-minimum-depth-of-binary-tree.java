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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);
        if (leftMinDepth == 0 && rightMinDepth == 0) {
            return 1;
        }
        int min = Math.min(leftMinDepth, rightMinDepth);
        if (min == 0) {
            return Math.max(leftMinDepth, rightMinDepth) + 1;
        } else {
            return min + 1;
        }
    }
}