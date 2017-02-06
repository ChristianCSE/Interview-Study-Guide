import java.util.*;
class Median {
 

 // public void insert(int num){
 //  size++;
 //  if(size == 1){
 //   maxHeap.add(num);
 //  }
 //  else if(size%2==0 ){
 //   //even insert => insert in maxheap then compare to minheap root if maxheap greater swap
 //   if(size==2){
 //    minHeap.add(num);
 //   }else{
 //    maxHeap.add(num); //
 //   if(maxHeap.peek() > minHeap.peek()){//maxheap root should be smaller than minheap root
 //    Integer leftHandSide = maxHeap.poll();
 //    Integer rightHandSide = minHeap.poll();
 //    maxHeap.add(rightHandSide);
 //    minHeap.add(leftHandSide);
 //   }
 //  }
 //  } else{
 //   //odd case can't let imbalance
 //    maxHeap.add(num);
 //    minHeap.add(maxHeap.poll());
 //  }
 // }

 Queue<Integer> minHeap;
 Queue<Integer> maxHeap;
 int size;
 public Median(){
  size = 0;
 maxHeap = new PriorityQueue<>(10, Collections.reverseOrder()); //  ||less than median|| [max]
 minHeap = new PriorityQueue<>(); // [min]|| greater than median || 
 }

 public void insert(int num){
  //insert to max => (here is the median)
  maxHeap.add(num);
  minHeap.add(maxHeap.poll());
  if(maxHeap.size()<minHeap.size()){
   maxHeap.add(minHeap.poll());
  }
 } 

 public int getMedian(){
  int maxH = maxHeap.size();
  int minH = minHeap.size();
  if(maxH == minH){
   return (maxHeap.peek()+minHeap.peek())/2;
  } else {
   return maxHeap.peek();
  }
 }


 public static void main(String[] args){
  Median caller = new Median();
  caller.insert(10);
  caller.insert(5);
  System.out.println("7======"+caller.getMedian());
  caller.insert(1);
  System.out.println("5======"+caller.getMedian());
  caller.insert(2);
  System.out.println("3======"+caller.getMedian());
  caller.insert(100);
  System.out.println("5======"+caller.getMedian());
  caller.insert(22);
  System.out.println("7======"+caller.getMedian());
 }
}