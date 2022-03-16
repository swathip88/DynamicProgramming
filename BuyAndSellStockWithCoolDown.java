class BuyAndSellStockWithCoolDown {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
    int[] prices;
    int[][]memo;
    public int maxProfit(int[] prices) {
        this.prices = prices;
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
                doSomething = this.prices[day] + dp(day+2, 0);
            }else{
                doSomething = -this.prices[day] + dp(day+1, 1);
            }
            memo[day][holding] = Math.max(doNothing,doSomething);
        }
        
        return memo[day][holding];
    }
}
