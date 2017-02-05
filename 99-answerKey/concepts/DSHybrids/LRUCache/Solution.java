import java.util.*;
class Solution {


 public static void main(String[] args){
  LRUcache cache = new LRUcache(3);
  cache.put(1, 1);
  cache.print();
  cache.put(2, 2);
  cache.print();
  System.out.println("=====>" + cache.get(1));       // returns 1
  cache.print();
  cache.put(3, 3);    // evicts key 2
  cache.print();
  System.out.println("=====>" + cache.get(2));       // returns -1 (not found)
  cache.print();
  cache.put(4, 4);    // evicts key 1
  cache.print();
  System.out.println("=====>" + cache.get(1));       // returns -1 (not found)
  cache.print();
  System.out.println("=====>" + cache.get(3));       // returns 3
  cache.print();
  System.out.println("=====>" + cache.get(4));       // returns 4
  cache.print();
 }
}

class Node {
 int data; 
 Node next;
 Node prev;
 public Node(int data){
  this.data=data;
  next=null;
  prev=null;
 }
}

class LRUcache{
  Map<Integer, Node> cache;
  int size;
  Node head; //oldest 
  Node tail; //newest
  public LRUcache(int size){
   cache = new HashMap<>(size);
   this.size = size; 
   head = null;
   tail = null;
  }

  //refresh get; hence now placed in tail
  public int get(Integer key){
   System.out.println("get " + key);
   Node candidate;
   if((candidate=cache.get(key)) !=null){
    removeNode(candidate);
    newInsert(key, candidate);
    return candidate.data;
   }
   return -1;
  }

  public void removeNode(Node node){
    System.out.println("removeNode");
   if(node==head){
    head = head.next;
    head.prev = null;
   } else {
   Node prevs = node.prev;
   Node nexts = node.next;
   prevs.next = nexts;
   nexts.prev = prevs;
   }
  }
  public void newInsert(Integer key, Node node){
   System.out.println("newInsert");
   tail.next = node; 
   node.prev = tail;
   tail = node;
   node.next = null;
   cache.put(key, node);
  }

  public void print(){
    Node ptr = head;
    while(ptr.next != null){
      System.out.print(ptr.data + "=>");
      ptr = ptr.next;
    }
    System.out.print(ptr.data);
    System.out.println();
  }

  public void put(Integer key, Integer value){
    System.out.println("put");
   Node node = new Node(value);
   Node ptr;
   //insert could be an overwrite
   if( (ptr=cache.get(key))!=null){
    //push to tail of linked list
     removeNode(ptr);
     cache.remove(key);
     newInsert(key, node);
   }
   //if it doesn't exist now assume new insert
   //check if we have initiated
   else if(head==null){
    head = node;
    tail = node; 
    cache.put(key, node);
   }
   else if(size==cache.size()){
    //remove antiquated aka head in our case
    cache.remove(head.data);
    head = head.next;
    newInsert(key, node);
   }
   else{
    //insert to tail 
    newInsert(key, node);
   }
  }
}