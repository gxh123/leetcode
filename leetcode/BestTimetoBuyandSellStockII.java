public class BestTimetoBuyandSellStockII {

    public static void main(String[] args) {
        int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
        System.out.print(maxProfit(prices));
    }

    // 寻找所有的递增子串
    public static int maxProfit(int[] prices) {
        int lastPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > lastPrice) {
                maxProfit += prices[i] - lastPrice;
            }
            lastPrice = prices[i];
        }
        return maxProfit;
    }

}
