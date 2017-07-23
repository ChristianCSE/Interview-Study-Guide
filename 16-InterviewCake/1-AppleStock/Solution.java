

class Solution {

  public static int maxProfit(int[] prices) {

    int len = prices.length; 
    if(len < 2) return 0;

    int maxProfit = prices[1] - prices[0];
    int minBuy = Math.min(prices[1], prices[0]);
    for(int i = 2; i < len; i++) {
      int candidateSell = prices[i];
      int candidateProfit = candidateSell - minBuy;
      maxProfit = Math.max(candidateProfit, maxProfit);
      minBuy = Math.min(candidateSell, minBuy);
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    int maxP = maxProfit(new int[]{10, 7, 8, 4, 12, 2, 9});
    System.out.println("profit => " + maxP);
    maxP = maxProfit(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 0});
    System.out.println("profit => " + maxP);
  }
}