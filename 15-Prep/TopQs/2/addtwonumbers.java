import java.util.*;


class addtwonumbers{

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    List<Integer> sums = new ArrayList<>();
    ListNode ptr = l1;
    ListNode ptr2 = l2;
    int mult10 = 1;
    int carryOver = 0;
    int sum;
    while(ptr!=null||ptr2!=null) {
      int val1 = (ptr!=null) ? ptr.val : 0;
      int val2 = (ptr2!=null) ? ptr2.val : 0;
      sum = (val1 + val2 + carryOver);
      sums.add(sum%10);
      carryOver = sum/10;
      ptr = (ptr==null)? null:ptr.next;
      ptr2 = (ptr2==null)? null:ptr2.next;
    }
    
    if(carryOver!= 0) {
      sums.add(carryOver);
    }
    ListNode summed = new ListNode(0);
    int endLen = sums.size();
    ptr = summed;

    for(int i = 1; i < endLen; i++) {
      ptr.next = new ListNode(sums.get(i));
      ptr = ptr.next;
    }

    return summed;
  }

  public static void main(String[] args) {
    ListNode head_one = new ListNode(5);
    //head_one.next = new ListNode(4);
    //head_one.next.next = new ListNode(3);
    
    ListNode head_two = new ListNode(5);
    head_two.next = new ListNode(5);
    //head_two.next = new ListNode(6);
    //head_two.next.next = new ListNode(4);
    
    ListNode summed_up = addTwoNumbers(head_one, head_two);
    ListNode ptr = summed_up;
    while(ptr != null) {
      System.out.println(ptr.val);
      ptr = ptr.next;
    }




  }

}

class ListNode {
  int val; 
  ListNode next; 
  public ListNode(int val) {
    this.val = val;
  }
}