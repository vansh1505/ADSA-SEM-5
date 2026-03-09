class Solution {
    public int subarraySum(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            dp[i] = dp[i - 1] + nums[i];
        }
        
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int si = Math.max(0, i - nums[i]);
            if(si == 0) ans += dp[i];
            else ans += dp[i] - dp[si - 1];
        }
        return ans;
    }
}