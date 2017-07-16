import java.util.*; 
class k_largest {
  


  public static ArrayList<String> topK(int k, Iterator<String> iter) {
    PriorityQueue<String> minHeap = new PriorityQueue<>(k, new Comparator<String>(){
      //overwrite comparator for descending ordering [min is at top]
      //s1 = new, s2 = old
      // default is s2.length(), s1.length()
      public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
      }
    });

    while(iter.hasNext()) {
      minHeap.add(iter.next());
      if(minHeap.size() > k) {
        minHeap.poll(); //remove top element 
      }
    }

    return new ArrayList<>(minHeap);
  }


  public static void main(String[] args){
    String[] words = new String[]{"a", "ab", "abc", "abcdef", "abcdefg", "abcdefgh", "abcd", "abcde"};
    ArrayList<String> word_list = new ArrayList<>(Arrays.asList(words));
    Iterator it = word_list.iterator(); 
    ArrayList<String> top_k_words = topK(3, it);
    System.out.println(top_k_words);
    
  }
}