class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) sum += i;
        if(sum % 2 != 0) return false; //ODD SUM CASE
        
        Boolean[][] dp = new Boolean[nums.length][sum + 1];
        return solve(nums, dp, sum/2, 0, 0);
    }
    boolean solve(int[] nums, Boolean[][] dp, int sum, int curr, int i){
        if(curr == sum) return true;
        if(curr > sum || i == nums.length) return false;

        if(dp[i][curr] != null) return dp[i][curr];
        
        boolean take = solve(nums, dp, sum, curr + nums[i], i + 1);
        boolean notTake = solve(nums, dp, sum, curr, i + 1);
        
        return dp[i][curr] = take || notTake;
    }
}