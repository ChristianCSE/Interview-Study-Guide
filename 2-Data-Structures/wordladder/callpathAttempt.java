import java.util.*; 

class callpathAttempt{

  public static void main(String[] args)
  {
    String[] myWords = new String[]{"hot","dot","dog","lot","log"};
    Set<String> wordList = new HashSet<>(Arrays.asList(myWords));
    String beginWord = "hit";
    String endWord = "cog";
    //non-static methods; hence need instance of path (Implied constructor)
    PathSolution caller = new PathSolution();
    System.out.println(caller.pathLength(beginWord, endWord, wordList));
  }
