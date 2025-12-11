class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] i : dp) Arrays.fill(i, -1);
        return solve(grid, dp);
    }
    int solve(int[][] g, int dp[][]){
        int m = g.length;
        int n = g[0].length;

        dp[0][0] = g[0][0];
        
        for(int c = 1; c < n; c++){
            dp[0][c] = dp[0][c-1] + g[0][c];
        }

        for(int r = 1; r < m; r++){
            dp[r][0] = dp[r-1][0] + g[r][0];
        }

        for(int r = 1; r < m; r++){
            for(int c = 1; c < n; c++){
                dp[r][c] = g[r][c] + Math.min(dp[r - 1][c], dp[r][c - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }
}