class IncreasingSub {


 public static String incrSequence(String word){

  if(word==null){return "";}
  int maxCount = 1; 
  String currMax = ""+word.charAt(0);

  String cache = currMax;
  int len = word.length();

  for(int i = 1; i < len; i++){
   char curr = word.charAt(i);
   int diff = curr - word.charAt(i-1);
   if(diff > 0){
    cache = cache + curr; 
    if(cache.length() > currMax.length()){
     currMax = cache;
    }
   } else {
    cache = ""+curr;
   }
  }

  System.out.println("incr subsequence: " + currMax);
  return currMax;
 }


  public static void main(String[] args){
   incrSequence("pandora");
   incrSequence("helloabcdpluswhatisthis");
  }
}