import java.util.*; 

public class Trie{ 

  TrieNode root;
  
  public Trie()
  {  
    root = new TrieNode(); 
  }

  public void putword(String key)
  {
    char[] path = key.toCharArray(); 
    int i, len = path.length; 
    TrieNode currNode = root; 
    for(i = 0; i < len; i++)
    {
      currNode = currNode.addChild(path[i]);
    }
    //done
  }

  public void putarr(String[] arr)
  {
    for(String word: arr)
      putword(word);
  }
  public boolean containsPrefix(String word)
  {
    TrieNode currNode = root; 
    int i, len = word.length();
    for(i = 0; i < len; i++)
    {
      char currLetter = word.charAt(i);
      
      if( !currNode.children.containsKey(currLetter) )
      {
        return false; //letter DNE
      }
        currNode = currNode.children.get(currLetter);
    }
    return true; 
  }



}
