import java.util.*; 
class pathAttempt{

  public int pathLength(String beingWord, String endWord, Set<String> wordList)
  {
    if(beingWord.length() != endWord.length()) {return -1;}
    wordList.add(endWord);
    WordLadder firstPath = new WordLadder(beingWord, 1);
    Queue<WordLadder> pathsqueue = new ArrayDeque<>(); 
    pathsqueue.add(firstPath);
    while(!pathsqueue.isEmpty())
    {
      WordLadder currPath = pathsqueue.remove(); 
      String pathEndsHere = currPath.atWord;
      int pathLength = currPath.pathLength;
      if(pathEndsHere.equals(endWord)){return pathLength;}
      Iterator<String> it = wordList.iterator(); 
      while(it.hasNext())
      {
        String myWord = it.next(); //it.next() don't make repeated calls
        if(diffByOne(pathEndsHere, myWord))
        {
          //make new path
          pathsqueue.add(new WordLadder(myWord, pathLength+1));
          it.remove();
        }//if()
      }//while()
    }//while()
    return -1; 
  }

  public boolean diffByOne(String wordAt, String branchTo)
  {
    int diffs = 0; 
    for(int i = 0; i < wordAt.length(); i++)
    {
      if( !(wordAt.charAt(i) == branchTo.charAt(i) ) )
      {
        diffs++;
        if(diffs > 1){return false;}
      }
    }
    return true; 
  }

}

class WordLadder{
  String atWord; 
  int pathLength; 
  public WordLadder(String atWord, int pathLength)
  {
    this.atWord = atWord;
    this.pathLength = pathLength; 
  }
}
