class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        return solve(matrix, new int[n][n]);
    }
    
    int solve(int[][] m, int[][] dp){
        int n = m.length;

        for(int c = 0; c < n; c++){
            dp[n - 1][c] = m[n - 1][c];
        }

        for(int r = n - 2; r >= 0; r--){
            for(int c = n - 1; c >= 0; c--){
                if(c == n - 1){ 
                    dp[r][c] = m[r][c] + Math.min(dp[r+1][c], dp[r+1][c-1]);

                } else if(c == 0){
                    dp[r][c] = m[r][c] + Math.min(dp[r+1][c], dp[r+1][c+1]);

                } else {
                    dp[r][c] = m[r][c] +
                        Math.min(dp[r+1][c],
                          Math.min(dp[r+1][c-1], dp[r+1][c+1]));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int x : dp[0]) min = Math.min(min, x);

        return min;
    }
}