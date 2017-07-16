import java.util.*;


class mergeSortArrays {

  /*
    We have k number of files, where each file has a set of numbers in ascending order.
    We want to group these files into one large file and have that file maintain ascending order. 
   */
  public static List<Integer> mergeSortArrays(List<List<Integer>> list) {
    //set up iterators for each individual list 
    //we can then empty out our arrays as our overall list consumes indiv entries
    List<Iterator<Integer>> iters = new ArrayList<>(list.size());
    for(List<Integer> row: list) {
      iters.add(row.iterator());
    }

    //since we will be returning a list in increasing order we need to be tracking 
    //the min so we add it into our list
    PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(list.size(), new Comparator<ArrayEntry>(){
      @Override
      public int compare(ArrayEntry entry1, ArrayEntry entry2) {
        return Integer.compare(entry1.value, entry2.value);
      }
    });

    //init the min heap with the first elements of each list [they are always the min]
    //need reference to list #
    for(int i = 0; i < iters.size(); i++) {
      if(iters.get(i).hasNext()){
        minHeap.add(new ArrayEntry(iters.get(i).next(), i));
      }
    }

    //our PQ now has our mins(arr) elements now we iterate through the rest
    //and store them in ascending order in a list
    List<Integer> mergedArrays = new ArrayList<>();

    while(minHeap.peek() != null) {
      //remove min and store in our merged array 
      ArrayEntry currMin = minHeap.poll();
      mergedArrays.add(currMin.value);
      if(iters.get(currMin.arrayID).hasNext()) {
        minHeap.add(new ArrayEntry(iters.get(currMin.arrayID).next(), currMin.arrayID));
      }
    }

    return mergedArrays;
  }

  public static void main(String[] args) {
    List<Integer> list1 = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6});
    List<Integer> list2 = Arrays.asList(new Integer[]{3, 4, 5, 9, 10, 11});
    List<Integer> list3 = Arrays.asList(new Integer[]{2, 13, 34, 35});
    List<Integer> list4 = Arrays.asList(new Integer[]{4, 10, 3});
    List<List<Integer>> files = new ArrayList<>();
    files.add(list1);
    files.add(list2);
    files.add(list3);
    files.add(list4);
    System.out.println("Merged Array: " + mergeSortArrays(files));
  }
}

class ArrayEntry {
  Integer value;
  Integer arrayID;
  public ArrayEntry(Integer value, Integer arrayID) {
    this.value = value;
    this.arrayID = arrayID;
  }
}