
import java.util.*;

 class Solution {

  public static boolean landZero(int[] bridge, int start){
   //can move left or right
   int len = bridge.length;
   Deque<Integer> current = new ArrayDeque<>();
   List<Integer>  visted = new ArrayList<>();
   current.push(start);
   while(!current.isEmpty()){
    int indexOn = (int)current.poll(); //index
    int jump = bridge[indexOn]; //jump
    int left = indexOn - jump;
    int right = indexOn + jump;

    if(markJump(bridge, left)){
     if(bridge[left] ==0){return true;}
     if(!visted.contains(left)){
      visted.add(left);
      current.push(left);
     }
    }
    if(markJump(bridge, right)){
     if(bridge[right]==0){return true;}
     if(!visted.contains(right)){
      visted.add(right);
      current.push(right);
     }
    }
   }
   return false; 
  }

  public static boolean markJump(int[] bridge, int dir){
    if(dir < bridge.length && dir >= 0 ){
     return true;
    }
    else{
     return false; 
    }
  }



  public static void main(String[] args) {
   System.out.println(landZero(new int[]{1, 2, 3, 1, 2, 1, 1}, 1)); //false
   System.out.println(landZero(new int[]{1, 0, 2, 1, 2, 1, 1}, 2)); //true
   System.out.println(landZero(new int[]{1, 1, 2, 1, 2, 0, 3}, 2)); //false
  }
 }