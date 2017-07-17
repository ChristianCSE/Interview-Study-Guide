import java.util.*; 

class kLargestInOrderHeap {


  public static List<Integer> kLargest(List<Integer> arrayHeap, int k) {
    if( k <= 0) {
      return null;
    }

    PriorityQueue<HeapEntry> maxHeap = new PriorityQueue<HeapEntry>(16, new Comparator<HeapEntry>(){
      public int compare(HeapEntry a, HeapEntry b) {
        return (-1)*Integer.compare(a.value, b.value);
      }
    });

    maxHeap.add(new HeapEntry(0, arrayHeap.get(0)));

    List<Integer> result = new ArrayList<>(); 
    for(int i = 0; i < k; i++) {

      Integer candiateIdx = maxHeap.peek().index;
      result.add(maxHeap.remove().value);

      Integer leftChild = 2*candiateIdx + 1; 
      if(leftChild < arrayHeap.size()) {
        maxHeap.add(new HeapEntry(leftChild, arrayHeap.get(leftChild)));
      }

      Integer rightChild = 2*candiateIdx + 2;
      if(rightChild < arrayHeap.size()) {
        maxHeap.add(new HeapEntry(rightChild, arrayHeap.get(rightChild)));
      }
    }

    return result;
  }

  public static void main(String[] args) {
    List<Integer> maxHeapArray = Arrays.asList(new Integer[]{40, 38, 39, 26, 28, 32, 35, 25, 23});
    List<Integer> kMax = kLargest(maxHeapArray, 7);
    System.out.println("in order => "+ kMax);
  }
}

class HeapEntry {

  int index;
  int value;

  public HeapEntry(int index, int value) {
    this.index = index; 
    this.value = value; 
  }

}