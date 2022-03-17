class BuyAndSellStockWithTransactionFee {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/
    int[] prices;
    int[][]memo;
    int fee;
    public int maxProfit(int[] prices, int fee) {
        this.prices = prices;
        this.fee = fee;
        memo = new int[prices.length][2];
        
        return dp(0,0);
    }
    
    private int dp(int day, int holding){
        if(day >= this.prices.length){
            return 0;
        }
        
        if(memo[day][holding] == 0){
            int doNothing = dp(day + 1, holding);
            int doSomething;
            if(holding == 1){
                doSomething = -this.fee + this.prices[day] + dp(day+1, 0) ;
            }else{
                doSomething = -this.prices[day] + dp(day+1, 1) ;
            }
            memo[day][holding] = Math.max(doNothing,doSomething);
        }
        
        return memo[day][holding];
    }
    
    
    
}

//Simplest solution
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}
