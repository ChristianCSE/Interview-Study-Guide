import java.util.Arrays;

public class callSort{

	static int[] selection;
	static int[] bubble;
	static int[] insertion;
	static long startTime;
	static long endTime;


	public static void equalSort(int[] arr1, int[] arr2)
	{

		if(arr1.length != arr2.length){
				System.out.println("Bad comparison, not the same length");
			}
		for(int i = 0; i < arr1.length; i++)
		{
			if(arr1[i] != arr2[i])
			{
				System.out.println("Bad sort!");
				return;
			}
		}
		System.out.println("Proper Sort! They are both equivalent");
	}

	public static void dataPrint(int[] arr, long time)
	{
		System.out.print(Arrays.toString( arr ) + "\n");
		System.out.println("That took " + time + " nanoseconds");
	}


	public static void callInsertion()
	{
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		InsertionSort sort = new InsertionSort();
		System.out.print("Insertion: ");
		startTime = System.nanoTime();
		insertion = sort.sort(arr);
		endTime = System.nanoTime();
		dataPrint(insertion, endTime-startTime);
	}


	public static void callSelection()
	{
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		SelectionSort sort = new SelectionSort();
		System.out.print("Selection: ");
		startTime = System.nanoTime();
		selection = sort.sort(arr);
		endTime = System.nanoTime();
		dataPrint(selection, endTime-startTime);
	}

	public static void callBubble()
	{
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		BubbleSort sort = new BubbleSort();
		System.out.print("Bubble!:   ");
		startTime = System.nanoTime();
		bubble = sort.sort(arr);
		endTime = System.nanoTime();
		dataPrint(bubble, endTime-startTime);
	}

	public static void builtIn()
	{
		int[] arr = {3, 44, 1, 90, 43, 89, 22, 34, 44,  23, 54, 9, 0, 123, 123, 32, 534, 3, 2, 3};
		System.out.print("BuiltIn Sort: ");
		long startTime = System.nanoTime();
		Arrays.sort(arr);
		long endTime = System.nanoTime();
		dataPrint(arr, endTime-startTime);
	}

	public static void runAll(int copies)
	{
		int i =0, j, bubbleTime, selectionTime;
		while(i != copies)
		{
			callSelection();
			callBubble();
			callInsertion();
			i++;
			System.out.println();
		}
		equalSort(selection, insertion);
		equalSort(bubble, insertion);
		equalSort(bubble, selection);
	}

	public static void main(String[] args)
	{
		runAll(1);

	}
}
