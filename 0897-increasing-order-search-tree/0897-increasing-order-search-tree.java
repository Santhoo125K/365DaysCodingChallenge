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
    
    public ArrayList<TreeNode> list = new ArrayList<>(); 
    
    void inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.left);
        list.add(root);
        inorder(root.right);
        
    }
    
    public TreeNode increasingBST(TreeNode root) {
        
        inorder(root);
        
        list.add(null);
        
        for(int i=0;i<list.size() - 1; i++){
            
            list.get(i).left=null;
            list.get(i).right=list.get(i+1);
        }
        
        return list.get(0);
    }
}