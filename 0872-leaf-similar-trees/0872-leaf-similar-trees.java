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
    
    List<Integer> t1l = new ArrayList<>();
    List<Integer> t2l = new ArrayList<>();
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        dfs(root1, t1l);
        dfs(root2, t2l);
        
        if(t1l.size() != t2l.size()){
            return false;
        }
        
        for(int i=0; i<t1l.size();i++){
            if(!t1l.get(i).equals(t2l.get(i))){
                return false;
            }
        }
        
        return true;
        
    }
    
    public void dfs(TreeNode node, List<Integer> list){
        if(node.left == null && node.right == null){
            list.add(node.val);
            return;
        }
        
        if(node.left != null){
            dfs(node.left, list);
        }
        
        if(node.right !=null){
            dfs(node.right, list);
        }
    }
}