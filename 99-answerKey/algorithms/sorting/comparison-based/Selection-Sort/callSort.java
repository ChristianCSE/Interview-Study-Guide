import java.util.Arrays;
public class callSort{


	public static void main(String[] args)
	{
		int[] arr = {3, 44, 1, 90, 43, 89, 22};
		SelectionSort sort = new SelectionSort();
		System.out.println("Selection Sort O(n^2): " + Arrays.toString(sort.sort(arr)));
	}
}
