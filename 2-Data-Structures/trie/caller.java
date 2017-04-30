public class caller{


  public static void main(String[] args)
  {
    String[] arr = new String[]{"cat", "catnip", "cats", "cool", "want", "wanter"};
    Trie myTrie = new Trie(); 
    myTrie.putarr(arr);
    String[] prefixes = new String[]{"cat", "catsp", "lol", "catn", "nono", "wan", "ca", "wantered"};
    for(String see: prefixes)
      System.out.println(myTrie.containsPrefix(see) + " " + see + " in my Trie");
  }
}
