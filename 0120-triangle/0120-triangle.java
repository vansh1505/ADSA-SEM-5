class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][] = new int[triangle.size()][triangle.size()];
        for(int[] a : dp) Arrays.fill(a, Integer.MIN_VALUE);
        return solve(triangle, dp);
    }

    int solve(List<List<Integer>> t, int[][] dp){
        dp[0][0] = t.get(0).get(0);
        for(int r = 1; r < t.size(); r++){
            dp[r][0] = dp[r - 1][0] + t.get(r).get(0);
        }
        for(int r = 1; r < t.size(); r++){
            for(int c = 1; c < t.get(r).size(); c++){
                if(c == r){
                    dp[r][c] = t.get(r).get(c) + dp[r - 1][c - 1];
                } else {
                    dp[r][c] = t.get(r).get(c) + Math.min(dp[r - 1][c], dp[r - 1][c - 1]);
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i : dp[t.size() - 1]){
            min = Math.min(i, min);
        }
        return min;
    }
}