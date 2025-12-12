class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        Integer dp[][] = new Integer[m][n];
        return solve(dungeon, dp, 0, 0);
    }
    int solve(int[][] grid, Integer[][] dp, int r, int c){
        int m = grid.length;
        int n = grid[0].length;
        if(c >= n || r >= m) return Integer.MAX_VALUE;
        if(dp[r][c] != null) return dp[r][c];
        if(r == m - 1 && c == n - 1) return Math.max(1, 1 - grid[r][c]);

        int right = solve(grid, dp, r, c + 1);
        int bottom = solve(grid, dp, r + 1, c);
        
        return dp[r][c] = Math.max(1, Math.min(right, bottom) - grid[r][c]);
    }
}