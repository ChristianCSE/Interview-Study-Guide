
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// Given a stream of unsorted integers, find the median element in sorted order at any given time.
// http://www.ardendertat.com/2011/11/03/programming-interview-questions-13-median-of-integer-stream/
public class Solution{

 public Queue<Integer> minHeap; //greater than median where ordering is minheap
 public Queue<Integer> maxHeap; //less than median where ordering is maxheap
 public int numOfElements;
 
 public Solution() {
  minHeap = new PriorityQueue<Integer>();
  maxHeap = new PriorityQueue<Integer>(10, new MaxHeapComparator()); 
  numOfElements = 0;
 }
 
 public void addNumberToStream(Integer num) {
  maxHeap.add(num);
  if (numOfElements%2 == 0) {
   if (minHeap.isEmpty()) {
    numOfElements++;
    return;
   }
 
   else if (maxHeap.peek() > minHeap.peek()) {
    System.out.println("===="+minHeap);
    System.out.println("===="+maxHeap);
    Integer maxHeapRoot = maxHeap.poll();
    Integer minHeapRoot = minHeap.poll();
    maxHeap.add(minHeapRoot);
    minHeap.add(maxHeapRoot);
   } 
  } else {
   minHeap.add(maxHeap.poll());
   System.out.println("min=>"+minHeap);
   System.out.println("max=>"+maxHeap);
  }
  numOfElements++;
 }
 
 public void add(Integer num){
  //max Heap => [less than median][root: greatest value] [root: lowest value][greater than median] <= min heap
  if(maxHeap.isEmpty()){
    maxHeap.add(num);
    numOfElements++;
  }
  else if(minHeap.isEmpty()){
    minHeap.add(num);
    numOfElements++;
  } else if (num > maxHeap.peek()){
    minHeap.add(num);
    numOfElements++;
  } else{
    maxHeap.add(num);
  }
 }

 public Integer getMed(){
  if(maxHeap.size()==minHeap.size()){
    return (maxHeap.peek()+minHeap.peek())/2;
  }
  else{
    return (maxHeap.size()>minHeap.size())?maxHeap.peek(): minHeap.peek();
  }
 }


 public Double getMedian() {
  if (numOfElements%2 != 0)
   return new Double(maxHeap.peek());
  else
   return (maxHeap.peek() + minHeap.peek()) / 2.0; 
 }
 
 private class MaxHeapComparator implements Comparator<Integer> {
  @Override
  public int compare(Integer o1, Integer o2) {
   return o2 - o1;
  }
 }
 
 public static void main(String[] args) {
  Solution streamMedian = new Solution();
  
  streamMedian.addNumberToStream(10);
  System.out.println(streamMedian.getMedian()); // should be 1
  
  streamMedian.addNumberToStream(20);
  streamMedian.addNumberToStream(8);

  System.out.println(streamMedian.getMedian()); // should be X
  streamMedian.addNumberToStream(12);
  streamMedian.addNumberToStream(2);
  System.out.println(streamMedian.getMedian()); // should be 5
  
  streamMedian.addNumberToStream(3);
  streamMedian.addNumberToStream(8);
  streamMedian.addNumberToStream(9);
  System.out.println(streamMedian.getMedian()); // should be 6.5
 }
}