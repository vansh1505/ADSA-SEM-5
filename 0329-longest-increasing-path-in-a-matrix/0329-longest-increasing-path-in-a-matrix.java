class Solution {
    Integer[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        dp = new Integer[matrix.length][matrix[0].length];

        int ans = 1;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                ans = Math.max(ans, solve(matrix, i, j));
            }
        }
        return ans;
    }

    int solve(int[][] matrix, int i, int j){
        int m = matrix.length;
        int n = matrix[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n) return 0;
        if(dp[i][j] != null) return dp[i][j];

        int top = 0, bottom = 0, left = 0, right = 0;
        if(i - 1 >= 0 && matrix[i][j] < matrix[i - 1][j]) top = solve(matrix, i - 1, j);
        if(i + 1 < m && matrix[i][j] < matrix[i + 1][j]) bottom = solve(matrix, i + 1, j);
        if(j + 1 < n && matrix[i][j] < matrix[i][j + 1]) right = solve(matrix, i, j + 1);
        if(j - 1 >= 0 && matrix[i][j] < matrix[i][j - 1]) left = solve(matrix, i, j - 1);

        return dp[i][j] = 1 + Math.max(top, Math.max(bottom, Math.max(left, right)));
    }
}