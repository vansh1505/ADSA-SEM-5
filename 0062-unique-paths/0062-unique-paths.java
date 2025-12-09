class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        return solve(0, 0, m, n, dp);
    }

    int solve(int r, int c, int m, int n, int[][] dp) {
        if (r == m - 1 && c == n - 1) return 1;
        if (r >= m || c >= n) return 0;
        if(dp[r][c] != -1) return dp[r][c];

        return dp[r][c] = solve(r + 1, c, m, n, dp) + solve(r, c + 1, m, n, dp);
    }
}