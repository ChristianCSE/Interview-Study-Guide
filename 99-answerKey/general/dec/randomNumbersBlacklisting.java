import java.util.*; 
class randomNumbersBlacklisitng {

 static public void evenlyDistrib(int[] blacklisting, int n) {
  //let's treat index => actual number rather than -1 offset 
  int[] distribution = new int[n+1];
  boolean[] noTouch = new boolean[n+1]; //all init to False
  for(int banned : blacklisting) {
   noTouch[banned] = true; 
  }
  Random generateRandom = new Random(); 

  for(int i = 0; i < 100; i++) {
   int dummy = (generateRandom.nextInt(n) + 1);
   // System.out.print(dummy + " ");
   if(!noTouch[dummy]) {
    distribution[dummy] += 1; 
   }
  }
  // System.out.println(Arrays.toString(distribution));
  for(int j = 0; j < distribution.length; j++ ){
   System.out.println("["+j+"]= "+ distribution[j]);
  }
 }

 public static void main(String[] args) {
  evenlyDistrib(new int[]{1, 2, 7}, 10);

 }
}