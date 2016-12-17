public class InsertionSort{
	public static void sort(int[] arr)
	{
		int len = arr.length, i, j;
		for(i = 1; i < len; i++)
			for(j = i; j > 0 && arr[j] < arr[j-1]; j--)
			{
				swap(arr, j, j-1);
			}
			System.out.println(java.util.Arrays.toString(arr));
	}
	public static void swap(int[] arr, int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void main(String[] args)
	{
		sort(new int[]{8, 2, 1, 4});
	}
}
 
