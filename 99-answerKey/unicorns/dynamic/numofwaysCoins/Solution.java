class Solution{


 public static int numberWays(int[] coins, int n){
  //row=coins | col=value
  int len = coins.length+1;
  int[][] table = new int[len][n+1];  
  for(int i= 0; i < len; i++){
   table[i][0] = 1;
  }

  for(int coin = 1; coin <= coins.length; coin++){
   for(int curr = 1; curr <= n; curr++) {
    int currCoin = coins[coin-1];
    System.out.println(currCoin);
    if(currCoin>curr){
     table[coin][curr] = table[coin-1][curr];
    } else{ 
     table[coin][curr] = table[coin][curr- currCoin] + table[coin-1][curr];
    }
   }
  }

  System.out.println(java.util.Arrays.deepToString(table));
  return table[coins.length][n]; 
 }

 public static void main(String[] args){
  int want = 10;
  System.out.println(numberWays(new int[]{1, 2, 3}, 5));
 }
}