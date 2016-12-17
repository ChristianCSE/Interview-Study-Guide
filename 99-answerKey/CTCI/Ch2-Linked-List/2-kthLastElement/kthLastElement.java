import java.util.*; 
import java.lang.*; 

/*===========================================================================
Return kth last node from a singly linked list
===========================================================================*/
public class kthLastElement
{

  /*===========================================================================
  Throw exception if an illegal request is made
  ===========================================================================*/
  public class InvalidKthRequest extends Exception{
    public InvalidKthRequest(String error)
    {
      System.out.println(error);
    }
  }

  public void kthCheck(int kthLast, int wantkthLast) throws InvalidKthRequest
  {
    if(kthLast < wantkthLast)
    {
       throw new InvalidKthRequest("Invalid kth request");
    }
  }
  
  /*===========================================================================
  actual method
  ===========================================================================*/
  public SingleLinkedList.Node removekthLast(SingleLinkedList.Node head, int wantkthLast) 
  {
    SingleLinkedList.Node tail = head; 
    int kthLast = 1; //counted head
    
    while(tail.next != null)
    {
      tail = tail.next; 
      kthLast++; 
    }
    try{
      kthCheck( kthLast,  wantkthLast); 
      
    }catch (InvalidKthRequest e)
    {
      e.printStackTrace(); 
      return null; 
    }
    int i; 
    tail = head; 
    for(i = kthLast; i > wantkthLast; i--)
    {
      tail = tail.next; 
    }
    return tail; 

  }

  public static void main(String[] args)
  {
    SingleLinkedList linked = new SingleLinkedList(); 
    int[] conncetions = new int[]{1, 2, 4, 5, 6};
    linked.listofints(conncetions);
    int kth = 13;
    linked.print(linked.head);
    kthLastElement caller = new kthLastElement();
    SingleLinkedList.Node kLastNode = caller.removekthLast( linked.head, kth );
    kLastNode = caller.removekthLast( linked.head, 3);
    System.out.println(kLastNode.data);
  }

}
