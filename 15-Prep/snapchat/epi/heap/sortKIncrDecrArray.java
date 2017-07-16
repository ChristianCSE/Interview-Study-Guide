import java.util.*;

class sorKIncrDecrArray {



  public static List<List<Integer>> sortFluctuating(List<Integer> list) {

    List<List<Integer>> allAsc = new ArrayList<>();
    int tickMark = 0;
    String inorder = "increasing";
    int len = list.size();
    for(int i = 1; i <= len; i++) {
      //last element || marked incr, but decr now || marked decr, but incr now
      if( (i == len) || 
        (list.get(i) > list.get(i-1) && inorder.equals("decreasing")) ||
        (list.get(i) < list.get(i-1) && inorder.equals("increasing"))
        ) {
        //make a sublist of the list up to this point!
        List<Integer> sublisting = list.subList(tickMark, i);
        if(inorder.equals("decreasing")) {
          Collections.sort(sublisting);
        }
        tickMark = i; //mark at flucation point
        allAsc.add(sublisting);
        //flip order
        inorder = (inorder.equals("increasing")) ? "decreasing" : "increasing";
      }
    }
    return allAsc;
  }


  public static List<Integer> mergedLists(List<List<Integer>> list) {
    List<Iterator<Integer>> iter = new ArrayList<>();
    for(List singleList : list){
      iter.add(singleList.iterator());
    }

    PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(list.size(), new Comparator<ArrayEntry>(){
      public int compare(ArrayEntry entry1, ArrayEntry entry2) {
        return Integer.compare(entry1.data, entry2.data);
      }
    });

    for(int i = 0; i < iter.size(); i++) {
      if(iter.get(i).hasNext()) {
       minHeap.add( new ArrayEntry(i, iter.get(i).next()));
      }
    }
    List<Integer> completelySorted = new ArrayList<>();
    while(minHeap.peek() != null){
      ArrayEntry currMin = minHeap.poll(); 
      completelySorted.add(currMin.data);
      if(iter.get(currMin.arrayId).hasNext()){
        minHeap.add(new ArrayEntry(currMin.arrayId, iter.get(currMin.arrayId).next()));
      }
    }

    return completelySorted;
  }

  public static void main(String[] args) {
    
    List<Integer> list = new ArrayList<>(
      Arrays.asList(new Integer[]{1, 10, 20, 10, 5, 3, 8, 10, 30, 50, 10, 2, 8})
      );
    System.out.print("Got this: " + mergedLists(sortFluctuating(list)));


  }
}

class ArrayEntry{
  int arrayId;
  Integer data; 
  public ArrayEntry(int arrayId, Integer data) {
    this.arrayId = arrayId;
    this.data = data;
  }
}