public class MaxProfit2 {
    // 峰值卖出，第一位不可卖出
    private boolean isPeak(int[] values, int index) {
        if (index == 0) {
            return false;
        } else if (index == values.length - 1) {
            return values[index] >= values[index - 1];
        } else {
            return values[index] >= values[index - 1] && values[index] >= values[index + 1];
        }
    }

    // 谷值买入，最后一位不可买入
    private boolean isValley(int[] values, int index) {
        if (index == 0) {
            return values[index] <= values[index + 1];
        } else if (index == values.length - 1) {
            return false;
        } else {
            return values[index] <= values[index - 1] && values[index] <= values[index + 1];
        }
    }

    public int maxProfit1(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int buy = 0;
        int profit = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (isValley(prices, i)) {
                buy = prices[i];
            } else if (isPeak(prices, i)) {
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        int buy;
        int profit = 0;
        int i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                ++i;
            }
            buy = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                ++i;
            }
            profit += prices[i] - buy;
        }
        return profit;
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        MaxProfit2 maxProfit2 = new MaxProfit2();
        System.out.println(maxProfit2.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
