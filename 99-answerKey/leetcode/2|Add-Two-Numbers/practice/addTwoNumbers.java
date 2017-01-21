import java.util.*;

class addTwoNumbers{

  //inner class defined
  public class ListNode{
    int val; 
    ListNode next; 
     
     //no access modifier => default
      ListNode(int x)
      {
        val = x; 
      }  
  }

  public ListNode putNode(int newnode)
  { 
    size++; 
    ListNode head = new ListNode(newnode);
    while(ptr.next != null)
    {
      ptr = ptr.next; //we break at an empty spot
    }
    ptr.next = node; 
    node.next = null; 
    return node;
  }

  public void listofints(int[] list)
  {
    ListNode head;
    for(int i: list)
      if(i==0){head = new ListNode(list[i]);}
  }




  public ListNode addTwoNumbers(ListNode l1, ListNode l2)
  {
    ListNode linkedSum = new ListNode(l1.val + l2.val);
    while((l1 = l1.next) != null && (l2 = l2.next) != null)
    {    
      ListNode sum = new ListNode(l1.val + l2.val);
      linkedSum.next = sum; 
      linkedSum = linkedSum.next; 
    }
      return linkedSum;  
  }

  
  
  public static void main(String[] args)
  {



  }
}
