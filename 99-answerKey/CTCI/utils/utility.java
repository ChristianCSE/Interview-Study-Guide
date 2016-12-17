import java.util.*;
class utility {

  public static void heapSort(int[] arr){
   int len = arr.length;
   int mid = len/2 - 1;
   //make it into a max heap
   for(int i = mid; i  >= 0; i--) {
    heaping(arr, len, i);
   }
   System.out.println("=>" + Arrays.toString(arr));
   //now do heap sort
   //we start with the leftmost node in the lowest level
    for(int i = len-1; i >= 0; i--) {
     swapIt(arr, 0, i);
     heaping(arr, i, 0);
    }
    System.out.println("=>" + Arrays.toString(arr));
  }

	public static void heaping(int[] arr, int len, int currentParent) {
 		int newParent = currentParent;
 		int leftChild = 2*newParent + 1; 
 		int rightChild = 2*newParent+2;
 		if(leftChild<len && arr[newParent]<arr[leftChild]){
 			newParent = leftChild;
 		}
 		if(rightChild<len && arr[newParent]<arr[rightChild]){
 			newParent = rightChild;
 		}
 		if(newParent!=currentParent){
 			swapIt(arr, newParent, currentParent);
 			heaping(arr, len, newParent);
 		}
 	}

	public static void swapIt(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static List<Integer[]> permuteNums(int[] arr) {
		List<Integer[]> allPerms = new ArrayList<>();
		Integer[] hello = new Integer[arr.length];
		int i = 0;
		for(int num: arr){
			hello[i++] = num;
		}
		return permuteNums(hello, 0, arr.length, allPerms);
	}

   public static List<Integer[]> permuteNums(Integer[] arrs, int low, int hi, List<Integer[]> list) {
    if(low==hi){     
     Integer[] clone = arrs.clone(); //don't want to reference the continually swapped array
     list.add(clone);
     return list;
    }
    for(int i = low; i < hi; i++) {
     //swap
     swap(arrs, i, low);
     //recurs
     list = permuteNums(arrs, low+1, hi, list);
     //swap back 
     swap(arrs, low, i);
    }
    return list;
   }
   public static <T> void swap(T[] arrs, int lo, int hi) {
    T temp = arrs[lo];
    arrs[lo] = arrs[hi];
    arrs[hi] = temp;
   }


 public static void main(String[] args){
  // permute("abc");
  List<Integer[]> perms = permuteNums(new int[]{1, 2, 3});
  for(Integer[] allmine: perms){
   System.out.println("=>" +Arrays.deepToString(allmine));
  }
  heapSort(new int[]{3, 2, 5, 4, 6, 7, 1});
 }
}



