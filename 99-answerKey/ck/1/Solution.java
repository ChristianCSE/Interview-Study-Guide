class Solution{



 public static int getMaxProfit(int[] stockPrices){
  //Best Profit from purchase 1 and sale 1 
  //max & min != since reliant on order
  int len = stockPrices.length;
  int maxProfit = Integer.MIN_VALUE; 
  for(int i = 0; i < len; i++){
   for(int j =i+1; j < len; j++){
    //int profit = buy - sell
    int profit =stockPrices[j]- stockPrices[i];
     if(profit > maxProfit){
      maxProfit = profit;
     }
   }
  }
  System.out.println(maxProfit);
  return maxProfit;
 }


 public static int betterSolution(int[] stockPricesYesterday){
  int len = stockPricesYesterday.length;
  if(len < 1){
    throw new IllegalArgumentException("length needs be larger than 1");
  }
  int min = stockPricesYesterday[0];
  int maxProfit = stockPricesYesterday[1]-stockPricesYesterday[0];
  
  for(int i = 1; i < len; i++){
    //we found a new min 
    int curr = stockPricesYesterday[i];
    min = (min < curr)? min: curr;
    //now compute min - current
    int profit = curr - min;
    //we utlimately care about profit 
    //not the two values; other than them not being the same moments
    maxProfit = (profit>maxProfit && curr != min)? profit: maxProfit;
  }
  System.out.println(maxProfit);
  return maxProfit;
 }

 public static void main(String[] args){
  int[] stockPricesYesterday = new int[]{10, 7, 5, 4, 3, 1};
  betterSolution(stockPricesYesterday);
  // returns 6 (buying for $5 and selling for $11)int stock
  stockPricesYesterday = new int[]{5, 20, 5, 1, 3, 100};
  betterSolution(stockPricesYesterday);

  stockPricesYesterday = new int[]{5, 20, 1, 2, 0, 3};
  betterSolution(stockPricesYesterday);

  stockPricesYesterday = new int[]{100, 40, 30, 20, 10, 0};
  betterSolution(stockPricesYesterday);
 }
}