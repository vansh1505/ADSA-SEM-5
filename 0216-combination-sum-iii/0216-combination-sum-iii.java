class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        solve(1, n, k, new ArrayList<>());
        return res;
    }

    void solve(int n, int tar, int rem, List<Integer> ans){
        if(tar < 0) return;
        if(n == 10){
            if(tar == 0 && rem == 0){
                res.add(new ArrayList<> (ans));
            }
            return;
        }

        ans.add(n);
        solve(n + 1, tar - n, rem - 1, ans);
        ans.remove(ans.size() - 1);

        solve(n + 1, tar, rem, ans);
    }
}