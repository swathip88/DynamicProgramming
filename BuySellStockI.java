class BuySellStockI {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length<2){
            return 0;
        }
        
        int maxProfit = 0;
        int minStockPrice = prices[0];
        for(int i=1;i<length;i++){
            maxProfit = Integer.max(maxProfit, prices[i] - minStockPrice);
            minStockPrice = Integer.min(minStockPrice, prices[i]);
        }
        if(maxProfit <0){
            return 0;
        }
        return maxProfit;
     }
}
