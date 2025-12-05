class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++) dp[i] = -1;
        return solve(n, dp);
    }
    static int solve(int n, int[] dp){
        if(n <= 0) return 0;
        if(n <= 2) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = solve(n - 1, dp) + solve(n - 2, dp) + solve(n - 3, dp);
    }
}