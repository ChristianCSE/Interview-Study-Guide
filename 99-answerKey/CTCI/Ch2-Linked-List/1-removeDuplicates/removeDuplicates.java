import java.util.*;

/*==========================================
remove duplicates two ways 
==========================================*/
public class removeDuplicates
{

    /*=========================================================
    Remove duplicates. This doesn't imply removing every instance
    The method blow will not work due to the fact that Hashmap 
    orders things by Key not placement
    =============================================================*/
    public static void removeDupes(SingleLinkedList.Node head)
    {
      Set<Integer> repeated = new HashSet<>(); 
      SingleLinkedList.Node ptr = head;  
      while(head != null)
      {
        if(repeated.contains(head.data))
        {
          //skip it that's why we add extra .next
          ptr.next = head.next; 
        }
        else
        {
          //normal traversal 
          repeated.add(head.data);
          ptr = head; 
        }
        //move
        head = head.next; 
      }
    }

  /*===========================================================
    removes every duplicate 
    =============================================================*/
    public static void removeAllDupes(SingleLinkedList.Node head)
    {
      Map<Integer, Integer > map = new LinkedHashMap<>(); 
      SingleLinkedList.Node ptr = head; 
      while(ptr != null)
      {
        Integer data = ptr.data;
        if(map.containsKey(data))
        {
          map.put(data, map.get(data)+1);
        }
        else
        {
          map.put(data, 1); 
        }
        ptr = ptr.next; 
      }
      ptr = head; 
      while(head != null)
      {
        if( (int)map.get(head.data)  > 1)
        { 
          ptr.next = head.next; //skip: hence extra appended next
        }
        else
        {
          ptr = head; 
        }
        head = head.next; 
      }
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

/*======================================================================================
Main method caller that displays both remove duplicat methods
======================================================================================*/
  public static void main(String[] args)
  {
   SingleLinkedList dupe = new SingleLinkedList(); 
   int[] mynodes = new int[]{1, 4, 4, 3, 5, 3};
   dupe.listofints(mynodes);
   dupe.print(dupe.head); 
   removeAllDupes(dupe.head);
   dupe.print(dupe.head); 

   //redo
   dupe = new SingleLinkedList(); 
   mynodes = new int[]{1, 4, 4, 3, 5, 3};
   dupe.listofints(mynodes);
   removeDupes(dupe.head);
   dupe.print(dupe.head); 
  }

}
