class BuyAndSellStockIV {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/submissions/
    int[] prices;
    int[][][]memo;
    public int maxProfit(int k, int[] prices) {
        //Top Down Solution
        this.prices = prices;
        memo = new int[prices.length][k+1][2];
        
        return dp(0,k,0);
    }
    
    private int dp(int day, int noOfTransactions, int holding){
        
        if(noOfTransactions == 0 || day == this.prices.length){
            return 0;
        }
        
        if(memo[day][noOfTransactions][holding] == 0){
            int doNothing = dp(day + 1, noOfTransactions, holding);
            int doSomething;
            if(holding == 1){
                doSomething = prices[day] + dp(day+1, noOfTransactions-1, 0);
            }else{
                doSomething = -prices[day] + dp(day+1, noOfTransactions, 1);
            }    
            
            memo[day][noOfTransactions][holding] = Math.max(doSomething, doNothing);
        }
        return memo[day][noOfTransactions][holding];
    }
}
