import java.util.*; 

public class TrieNode{
  Map<Character, TrieNode> children; 

  public TrieNode()
  {
    children = new HashMap<>(); 
  }


  public TrieNode addChild(char key)
  {
    TrieNode child = children.get(key);
    //if null; then child DNE in Trie
    if(child == null)
    {
      child = new TrieNode(); 
      children.put(key, child);
    } 
    return child; 
  }

}
