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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> pList = new ArrayList<>();
        List<Integer> qList = new ArrayList<>();
        dfs(p, pList); dfs(q, qList);
        return pList.equals(qList);
    }

    void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
            return;
        }
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
