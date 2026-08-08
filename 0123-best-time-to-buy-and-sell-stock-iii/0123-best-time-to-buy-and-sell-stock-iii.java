class Solution {
    Integer[][][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2][3];
        return solve(prices, 0, 0, 2);
    }

    int solve(int[] p, int i, int isBuy, int txn){
        if(i >= p.length || txn == 0) return 0;
        if(dp[i][isBuy][txn] != null) return dp[i][isBuy][txn];

        if(isBuy == 0){
            int buy = -p[i] + solve(p, i+1, 1, txn);
            int notBuy = solve(p, i+1, isBuy, txn);
            return dp[i][isBuy][txn] = Math.max(buy, notBuy);
        } else {
            int sell = (p[i]) + solve(p, i+1, 0, txn - 1);
            int notSell = solve(p, i+1, isBuy, txn);
            return dp[i][isBuy][txn] = Math.max(sell, notSell);
        }
    }
}