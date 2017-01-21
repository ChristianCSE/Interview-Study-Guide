/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.*; 
public class Solution {
 
    public static boolean isPalindrome(ListNode head){
    ListNode ptr = head; 
    List<Integer> candidate = new ArrayList<>(); 
    while(ptr!= null) {      
     candidate.add(ptr.val);
     ptr = ptr.next;
    }     
    
    //have string now do palindrome check 
    int len = candidate.size();
    if(len == 0|| len ==1){return true;}
    int start = 0;
    int end = len-1;
    for(start = 0; start <= len/2; start++, end--){
     if((int)candidate.get(start)!=(int)candidate.get(end)){
      return false;
     }
    }
    return true;
   }

   public static void main(String[] args){
    ListNode head = new ListNode(-1);
    ListNode second = new ListNode(1);
    ListNode clonetwo = new ListNode(1);
    ListNode third = new ListNode(-1);
    head.next = second;
    second.next = clonetwo;
    clonetwo.next = third;
    System.out.println(isPalindrome(head));
     }
}

class ListNode {
 int val;
 ListNode next;
 public ListNode(int val){
  this.val = val;
 }


}