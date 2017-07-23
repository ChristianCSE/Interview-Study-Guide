
import java.util.*;

//We have to find all simple words from a bunch of simple and compound words

class WordBreak {


  public static List<String> pureWords(String[] words) {
    List<String> reference = new ArrayList<>(); 
    for(String word: words) {
      reference.add(word);
    }
    List<String> pure = new ArrayList<>();
    for(String candidate: reference) {
      boolean store = isPure(candidate, reference);
      if(store) pure.add(candidate);
    }

    return pure;
  }


  public static boolean isPure(String candidate, List<String> dict) {
    boolean[] substringCache = new boolean[candidate.length()+1];
    substringCache[0] = true;
    for(int i = 1; i <= candidate.length(); i++) {
      for(int j = 0; j < i; j++) {
        //.substring(j, i)
        if( substringCache[j] && dict.contains(candidate.substring(j, i)) && !candidate.substring(j, i).equals(candidate)) {
          System.out.println("=>" + candidate + " ===>  " + candidate.substring(j, i));
          substringCache[i] = true;
          break;
        }
      }
    }
    System.out.println(substringCache[candidate.length()] + "    ===" + candidate);
    return !substringCache[candidate.length()];
  }

  public static void main(String[] args) {
    String[] dict = new String[]{"chat","ever","snapchat","snap","salesperson","per","person","sales","son","whatsoever","what","so"};
    List<String> pure = pureWords(dict);
    System.out.print(pure);


    //output:
    //what, so, ever, sales, per, son, chat, Snap

  }
}