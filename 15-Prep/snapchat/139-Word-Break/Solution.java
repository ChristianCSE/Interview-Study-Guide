
import java.util.*;


class Solution {


  /*
  Completely wrong approach
   */
  public static boolean badWordBreak(String s, List<String> wordDict) {
    boolean[] ans = new boolean[]{false};
    attemptAllPermutations(ans, s, wordDict, "", 0);
    return ans[0];
  }

  public static void attemptAllPermutations(boolean[] ans, String match, List<String> wordDict, String comp, int i){
    
    if(match.length() < comp.length()) {
      return;
    }
    if(match.equals(comp)) {
      ans[0] = true;
      return;
    }
    
    for(int j=i; j < wordDict.size(); j++){
      String compAttempt = comp + wordDict.get(j);
      
      attemptAllPermutations(ans, match, wordDict, compAttempt, i+1);
      if(ans[0]) {
        return;
      }
    }
  }


  public static boolean wordBreak(String s, List<String> wordDict) {
    boolean[] substringToCache = new boolean[s.length()+1]; //matches s.substring(0, index)
    substringToCache[0] = true; //substring(0,0) = true since we can always match it
    //substring = (startindex, endindex)
    for(int i = 1; i <= s.length(); i++) { //ending index 
      for(int j = 0; j < i; j++) {
        //(j, i)
        if(substringToCache[j] && wordDict.contains(s.substring(j, i))){
          System.out.println(s.substring(j, i));
          substringToCache[i] = true;
        }
      }
    }
    return substringToCache[s.length()];
  }








  public static void main(String[] args){

    String candidate = "catdogcat";
    boolean canbuild = wordBreak(candidate, Arrays.asList(new String[]{"cat", "bogs", "dog", "blanks"}));
    System.out.println("=>" + canbuild);
    candidate = "helloworld";
    canbuild = wordBreak(candidate, Arrays.asList(new String[]{"cat", "bogs", "dog", "blanks"}));

    System.out.println("=>" + canbuild);
    


  }
}