

class Solution {



  public static void main(String[] args) {
    MyQueue queue = new MyQueue();
    queue.add(10);
    queue.add(20);
    queue.add(30);
    queue.add(40);
    //returns in reverse order
    
    System.out.println(queue.poll());
    
    System.out.println(queue.poll());

    queue.add(50);

    System.out.println(queue.poll());
    

  }
}