class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        solve(ans, res, nums, vis);
        return ans;
    }

    void solve(List<List<Integer>> ans, List<Integer> res, int[] nums, boolean[] vis) {
        if (res.size() == nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(vis[i]) continue;

            vis[i] = true;
            res.add(nums[i]);
            solve(ans, res, nums, vis);
            res.remove(res.size() - 1);
            vis[i] = false;
        }
    }
}