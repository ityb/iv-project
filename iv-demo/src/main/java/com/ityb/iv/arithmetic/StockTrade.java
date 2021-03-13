package com.ityb.iv.arithmetic;

/**
 * 股票交易
 * 假设你有一个数组，其中第\ i i 个元素是股票在第\ i i 天的价格。
 * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
 */
public class StockTrade {
    public static int maxProfit (int[] prices) {
        if(prices.length == 0) return  0;
        int min = prices[0];
        int max = 0;
        for(int i=1;i<prices.length;i++){
            int curPrice = prices[i];
            min = curPrice > min ? min : curPrice;
            max = (curPrice - min) > max ? (curPrice - min) : max;
        }
        return max;
    }
}
