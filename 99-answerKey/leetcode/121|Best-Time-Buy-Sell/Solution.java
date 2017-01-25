class Solution {

 public static int maxProfit(int[] prices){
int len = prices.length;
  if(len < 1 ){return 0;}//can't buy/sell 1 stock
  int maxProfit = 0;
  int min = prices[0];
  for(int i= 1; i < len; i++){
   int curr = prices[i];
   int profit = curr - min; //min came before, curr => after
   maxProfit = (maxProfit>profit)? maxProfit:profit;
   min = (min<curr)? min:curr; //any new max will generate highest profit with this min
  }
  System.out.println(maxProfit);
  return maxProfit;
 }

  public static void main(String[] args){
  maxProfit(new int[]{1, 10, 1, 9, 100});
  maxProfit(new int[]{1, 1, 1, 1, 1});
  maxProfit(new int[]{10, 9, 8, 7, 6});
  }
}