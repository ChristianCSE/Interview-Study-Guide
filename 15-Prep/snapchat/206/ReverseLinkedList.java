

class ReversedLinkedList {

  public static ListNode reverseList(ListNode head) {
    
    ListNode prev = null;
    ListNode curr = head;
    ListNode ahead = null;

    while(curr != null) {
      //save ref to curr.next since we will be changing it to prev
      ahead = curr.next; 
      curr.next = prev; //make the ref curr.next point to what prev points to 
      prev = curr; //we are now prev
      curr = ahead; 
    }

    head = prev;
    return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(0);
    ListNode ptr = head;
    for(int i = 1; i < 10; i++) {
      ptr.next = new ListNode(i);
      ptr = ptr.next;
    }
    ptr = head;

    while(ptr != null) {
      System.out.println("LinkedList => " + ptr.val);
      ptr = ptr.next;
    }

    ListNode h = reverseList(head);
    ptr = h;
    while(ptr != null) {
      System.out.println("LL reversed => " + ptr.val);
      ptr = ptr.next;
    }
    
  }
}


class ListNode {
  int val;
  ListNode next = null;
  public ListNode(int val){
    this.val = val;
  }
}