class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = Integer.MAX_VALUE;
        int maxprofit = 0;

        for(int price : prices){
            minBuy = Math.min(minBuy,price);
            int profit = price - minBuy;
             maxprofit = Math.max(profit,maxprofit);
        }
        return maxprofit;
    }
}