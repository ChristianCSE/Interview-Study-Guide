import java.util.*; 



//BFS 


class Solution {



  public int ladderLength(String beginWord, String endWord, Set<String> wordList){


    Set<String> visited = new HashSet<>();
    //need to grow out both lists 
    Set<String> beginList = new HashSet<>(); 
    Set<String> endList = new HashSet<>(); 
    beginList.add(beginWord);
    endList.add(endWord);
    int pathLen = 0;
    while(!beginList.isEmpty() && !endList.isEmpty()) {
      //we need to grow out each list (smaller takes priority)
      //we will assume beginList as the one we want to grow
      if(beginList.size() > endList.size()) {
        Set<String> temp = beginList; // will be our new endList 
        beginList = endList;
        endList = temp;
      }

      //now we traverse through each word in our set 
      //we have to flush out the previous words with our current branches 
      
      Set<String> newPath = new HashSet<String>();
      //branch out each word to the next transformation 
      for(String candidate: beginList) {
        //we have to swap each individual letter one at a time 
        char[] splitWord = candidate.toCharArray();
        for(int i = 0; i < candidate.length(); i++) {
          
          for(char a = 'a'; a <= 'z'; a++) {
            //save init letter 
            char initLetter = splitWord[i];
            splitWord[i] = a; //branch out to new word

            String newWord = new String(splitWord);

            if(endList.contains(newWord)){
              return pathLen + 1; 
            }

            //if it exists in our dictionary (it is a possible path) & we haven't visited it 
            if(wordList.contains(newWord) && !visited.contains(newWord)) {
              visited.add(newWord);
              newPath.add(newWord);
            }
            splitWord[i] = initLetter; //revert back to old letter
            
          }
        }
      }
      pathLen++;
      beginList = newPath;
    }
    return 0;
  }



  public static void main(String[] args) {
    
    Set<String> set = new HashSet<>();
    
    String[] arr = new String[]{"hot","dot","dog","lot","log"};
    for(String str: arr) {
      set.add(str);
    }
    Solution caller = new Solution();
    int ans = caller.ladderLength("hit", "cog", set);
    System.out.println("ans=>" + ans);

  }
}