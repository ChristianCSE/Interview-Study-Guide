import java.util.*;

class getMedian {

  public static void getMedian(List<Integer> list){

    Iterator<Integer> iter = list.iterator();

    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(16, Collections.reverseOrder());

    while(iter.hasNext()) {
      //first submit always to minHeap (default to it for showing median when maxlength < minlength)
      if(minHeap.size() == 0) {
        minHeap.add(iter.next());
      } else {
        Integer element = iter.next();
        //remember, minheap contains the larger elements!
        if(minHeap.peek() < element) minHeap.add(element);
        else maxHeap.add(element);
      }

      //minHeap should always be maxHeap.size() + 1 nothing more 
      if(minHeap.size() > maxHeap.size() + 1) {
        maxHeap.add(minHeap.poll());
      }
      else if(minHeap.size() < maxHeap.size()) {
        minHeap.add(maxHeap.poll());
      }

      Integer currMedian = (minHeap.size() == maxHeap.size()) ? (  (minHeap.peek() + maxHeap.peek()) / 2 ) : minHeap.peek();
      System.out.println("Current Median: " + currMedian);
    }

    Integer finMedian = (minHeap.size() == maxHeap.size()) ? (  (minHeap.peek() + maxHeap.peek())/2 ) : minHeap.peek(); 
    System.out.println("<==========================================>");
    System.out.println("Final Median of entire stream: "+ finMedian);
  }


  public static void main(String[] args) {

    //1, 3, 7, 6, 4, 8, 2, 0, 5 => 4
    List<Integer> even_list = Arrays.asList(new Integer[]{1, 3, 7, 6, 4, 8, 2, 0, 5});
    getMedian(even_list);

    //1, 3, 7, 6, 4, 5, 2, 0 => 3+4/2 = 3.5 
    List<Integer> odd_list = Arrays.asList(new Integer[]{1, 3, 7, 6, 4, 5, 2, 0});
    getMedian(odd_list);
  }
}