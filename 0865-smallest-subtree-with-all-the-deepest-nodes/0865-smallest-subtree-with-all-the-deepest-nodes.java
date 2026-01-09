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
    static int level(TreeNode root){
        if(root==null) return 0;
        return 1 + Math.max(level(root.left),level(root.right));
    }
    
    static TreeNode solve(TreeNode root){
        if(level(root.left) > level(root.right)){
            return solve(root.left);
        }
        else if(level(root.left) < level(root.right)){
            return solve(root.right);
        }
        return root;
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root==null)return root;
        return solve(root);
    }
}