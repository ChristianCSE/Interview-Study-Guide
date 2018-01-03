import java.util.*;

class Solution {


  public static Double maxProfit(List<Double> stocks) {
    if(stocks.size() < 2) {
      return 0.00;
    }
    Double lowestBuy = Math.min(stocks.get(0), stocks.get(1));
    Double maxProfit = stocks.get(1) - stocks.get(0); //placeholder!
    for(int i = 2; i < stocks.size(); i++) {
      Double sellingPrice = stocks.get(i);
      maxProfit = Math.max(maxProfit, sellingPrice - lowestBuy);
      // is our new price a better buy?  
      // if so, this will maximize our profit
      lowestBuy = Math.min(lowestBuy, sellingPrice); 
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    List<Double> stocks = Arrays.asList(310.00, 315.00, 275.00, 295.00, 260.00, 270.00, 290.00, 230.00, 255.00, 250.00);
    System.out.println(maxProfit(stocks));
  }
}