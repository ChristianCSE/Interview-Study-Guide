import java.util.*;
class Solution {


//["LRUCache","get","put","get","put","put","get","get"]
//[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
 public static void main(String[] args){
  //LRUcache cache = new LRUcache(2);
  //cache.get(2); cache.put(2,6); cache.get(1); cache.put(1,5); cache.put(1,2); cache.get(1); cache.get(2);
  LRUcache cache = new LRUcache(2);
  cache.put(2,1); 
  //cache.print();
  cache.put(3,2);
  //cache.print();
  System.out.println("2=====>"+ cache.get(3));
  //cache.print();
  System.out.println("1=====>"+ cache.get(2));
  //cache.print();
  cache.put(4,3);
  //cache.print();
  System.out.println("1=====>"+ cache.get(2));
  //cache.print();
  System.out.println("-1=====>"+ cache.get(3));
  //cache.print();
  System.out.println("3=====>"+ cache.get(4));
  //cache.print();
 }
}
//cache.print();
class Node {
 int data; 
 int key; //need for size cap
 Node next;
 Node prev;
 public Node(int data, int key){
  this.data=data;
  this.key = key;
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
   System.out.println("get key " + key);
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
    cache.remove(node.key);
   if(node==head){
    head = head.next;
   } else if(node == tail){
    Node prevs = node.prev;
    tail = prevs;
    prevs.next = null;
   }
   else{
   Node prevs = node.prev;
   Node nexts = node.next;
   prevs.next = nexts;
   nexts.prev = prevs;
   }
  }
  public void newInsert(Integer key, Node node){
   System.out.println("newInsert");
    if(head==null){
    head = node;
    tail = node; 
    cache.put(key, node);
   }
   tail.next = node; 
   node.prev = tail;
   tail = node;
   node.next = null;
   cache.put(key, node);
  }

  public void print(){
    if(head==null){return;}
    Node ptr = head;

    System.out.print("head: ");
    while(ptr.next != null){
      System.out.print(ptr.data + "=>");
      ptr = ptr.next;
    }
    System.out.print(ptr.data);
    System.out.println();
  }

  public void put(Integer key, Integer value){
  System.out.println("put");
   Node node = new Node(value, key);
   Node ptr;
   if( (ptr=cache.get(key))!=null){//insert could be an overwrite
     removeNode(ptr);//push to tail of linked list     
     newInsert(key, node);
   }
   //if it doesn't exist now assume new insert check if we have initiated
   else if(head==null){
    head = node;
    tail = node; 
    cache.put(key, node);
   }
   else if(size==cache.size()){
    cache.remove(head.data); //remove key associated with node
    head = head.next; //remove antiquated aka head in our case
    newInsert(key, node);
   }
   else{
    //insert to tail 
    newInsert(key, node);
   }
  }
}