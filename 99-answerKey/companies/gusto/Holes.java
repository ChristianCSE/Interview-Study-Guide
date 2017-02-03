class Holes {

 public static int a_next_server_number(int[] arr){
  java.util.Arrays.sort(arr);
  int i = 1; 
  for(int num : arr){
    if(num == i){
      i++;
    } else{
      return i; 
    }
  }
  System.out.println(i);
  return i;
 }


  public static void main(String[] args){
   a_next_server_number(new int[]{5, 3, 1});
   a_next_server_number(new int[]{3, 2, 1});
   a_next_server_number(new int[]{5, 3, 7});
   //==> 3,5,7 if(index 0 )
   //1-99 105 => return 100
  }
}

// >> tracker = Tracker.new

// >> tracker.next_server_number([5, 3, 1])
// 2

// >> tracker.next_server_number([5, 4, 1, 2])
// 3

// >> tracker.next_server_number([3, 2, 1])
// 4

// >> tracker.next_server_number([2, 3])
// 1

// >> tracker.next_server_number([])
// 1