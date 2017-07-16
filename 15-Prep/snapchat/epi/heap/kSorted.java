import java.util.*;
class kSorted {

  public static List<Integer> sortK(Iterator<Integer> iter, int k) {
    
    PriorityQueue<Integer> minHeap = new PriorityQueue(k, new Comparator<Integer>(){
      public int compare(Integer node1, Integer node2) {
        return Integer.compare(node1, node2);
      }
    });

    for(int i = 0; i < k && iter.hasNext(); i++){
      minHeap.add(iter.next());
    }
    List<Integer> fullySorted = new ArrayList<>();
    
    while(iter.hasNext()){
      minHeap.add(iter.next());
      fullySorted.add(minHeap.poll());
    }
    //now exhaute the minheap until empty
    while(minHeap.peek() != null){
      fullySorted.add(minHeap.poll());
    }

    /*WRONG YOU NEED TO ADD +1 (from k+1 rule) before poll()
    while(minHeap.peek() != null) {
      fullySorted.add(minHeap.poll());
      if(iter.hasNext()) minHeap.add(iter.next());
    }
    */
    return fullySorted;
  }

  public static void main(String[] args) {
    //sortK()
    List<Integer> res = sortK(new ArrayList<>( Arrays.asList(new Integer[]{3, -1, 2, 6, 4, 5, 8}) ).iterator(), 2);
    System.out.println("GOT IT SORTED: " + res);

  }
}