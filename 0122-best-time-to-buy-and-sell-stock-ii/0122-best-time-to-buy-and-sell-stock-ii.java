class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2];
        return solve(prices, 0, 1);
    }

    int solve(int[] prices, int i, int canBuy) {
        if (i >= prices.length) return 0;
        if(dp[i][canBuy] != null) return dp[i][canBuy];

        if (canBuy == 1) {
            int buy = -prices[i] + solve(prices, i + 1, 0);
            int skipBuy = solve(prices, i + 1, 1);
            return dp[i][canBuy] = Math.max(buy, skipBuy);
        } else {
            int sell = prices[i] + solve(prices, i + 1, 1);
            int skipSell = solve(prices, i + 1, 0);
            return dp[i][canBuy] = Math.max(sell, skipSell);
        }
    }
}