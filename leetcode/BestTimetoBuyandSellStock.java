public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                int profit = prices[i] - min;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            } else {
                min = prices[i];
            }

        }
        return maxProfit;
    }

}
