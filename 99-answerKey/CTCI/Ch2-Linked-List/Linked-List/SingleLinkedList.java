import java.util.*;


public class SingleLinkedList
{
  /*==========================================
  Node: Singly LL Node (inner class)
  ==========================================*/
  public class Node
  {
    Node next; 
    int data; 
    
    public Node(int data) 
    {
      this.data = data; //empty linked list
      next = null; 
    }
  }//Node()
  
  /*==========================================
  Singly LL Implementation 
  ==========================================*/
  public static Node head; 
  public static int size;
  
  //constructor
  public SingleLinkedList()
  {
    head = null;
    size = 0; 
  }

  public void putNode(int newnode)
  { 
    size++; 
    Node node = new Node(newnode);
    Node ptr = head; 
    if(head == null) 
    {
      head = node; 
      node.next = null; 
    }
    else
    {
      while(ptr.next != null)
      {
        ptr = ptr.next; //we break at an empty spot
      }
      ptr.next = node; 
      node.next = null; 
    }
  }

  public void listofints(int[] list)
  {
    for(int i: list)
      putNode(i);
  }

  //usr can just ask for a singly LL
  public void autoSinglyLL(int size)
  {

    if(size < 1)
    {
      System.out.println("invalid size");
      return;
    }
   if(size < 3)
    {
      size = (2*size) + 1; //1 = head
    }
    this.size = size; 
    head = new Node( (int)( Math.random()*10) );     
    size = size - 1;

    while(size != 0)
    {
      int data = (int)( Math.random()*10);
      putNode(data);
      size--; 
    }
  }

  public void print(Node head)
  {
    Node ptr = head; 
    System.out.print("[");

    while(ptr != null)
    {
      if(ptr.next != null)
      {
      System.out.print(ptr.data + ", ");
      }
      else
      {
        System.out.print(ptr.data);
      }
      ptr = ptr.next; 
    }
    System.out.print("]\n");
  }    

  public int getSize()
  {
    return this.size; 
  }

    public void printHM(Map map)
    {
      Iterator it = map.entrySet().iterator(); 
      while(it.hasNext())
      {
        Map.Entry pair = (Map.Entry) it.next(); 
        System.out.println( pair.getKey() + "   " + pair.getValue());
      }
    }

  public static void main(String[] args)
  {

   A01_SingleLinkedList singleLL = new A01_SingleLinkedList(); 
   int[] mynodes = new int[]{1, 4, 4, 3, 5, 3};
   singleLL.listofints(mynodes);
   singleLL.print(singleLL.head); 
  }
}
