class Solution {
    public int rob(int[] nums) {
        return solve(nums, new int[nums.length + 1]);
    }
    int solve(int[] nums, int[] dp){
        int n = nums.length;
        if(n == 1) return nums[0];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++){
            int pick = nums[i] + dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n - 1];
    }
}