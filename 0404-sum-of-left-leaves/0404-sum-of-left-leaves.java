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
    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        return dfsLeft(root);
    }
    
    private int dfsLeft(TreeNode root) {
        if(root==null) {
            return 0;
        }
        if(root.left!=null && root.left.right==null && root.left.left==null) {
            sum += root.left.val;
        }
        dfsLeft(root.left);
        dfsLeft(root.right);
        return sum;
    }
}