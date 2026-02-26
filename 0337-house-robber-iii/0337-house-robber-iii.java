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
    Map<TreeNode, Integer> map1;
    Map<TreeNode, Integer> map2;

    public int rob(TreeNode root) {
        map1 = new HashMap<>();
        map2 = new HashMap<>();

        return solve(root, false);
    }

    int solve(TreeNode root, boolean isParTaken){
        if(root == null) return 0;
        if(isParTaken && map1.containsKey(root)) return map1.get(root);
        if(!isParTaken && map2.containsKey(root)) return map2.get(root);

        int notTake = solve(root.left, false) + solve(root.right, false);
        int take = 0;
        if(!isParTaken){
            take = root.val + solve(root.left, true) + solve(root.right, true);
        }

        int ans = Math.max(take, notTake);
        if(isParTaken){
            map1.put(root, ans);
        } else {
            map2.put(root, ans);
        }
        return ans;
    }
}