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
    boolean unbalanced = false;
    public boolean isBalanced(TreeNode root) {
        recur(root);
        return !unbalanced;
    }

    public int recur(TreeNode root){
        if(root == null) return 0;
        if(unbalanced == true) return 0;
        int left = recur(root.left) + 1;
        int right = recur(root.right) + 1;

        if(Math.abs(left - right) > 1){
            unbalanced = true;
        }
        return Math.max(left, right);
    }
}