/**
 *This is non-recursive mergersort
 *We are using the same array with ptr1 & ptr2
 */
import java.util.Arrays;
public class MergeSort{
	public static void merge(double[] arr, int ptr1,
		int ptr2, int right, double[] temp)
	{
		int tempIn = ptr1; //used for temp insert, since ptr1 incrs
		int stop1 = ptr2; //ptr2 increases so not permanent
		while(ptr1 < stop1 ||  ptr2 < right )//case1: one still has something
		{
			if(ptr1 < stop1 &&  ptr2 < right )//case2: both have something
			{
				if(arr[ptr1] < arr[ptr2])
				{
					temp[tempIn++] = arr[ptr1++];
				}
				else{
					temp[tempIn++] = arr[ptr2++];
				}
			}
			else if(ptr1 == stop1)//case3: emptied left array
			{
				temp[tempIn++] = arr[ptr2++];
			}
			else if(ptr2 == right)////case3: emptied right array
			{
				temp[tempIn++] = arr[ptr1++];
			}
		}//while()
		//we moved everything into temp
	}

	public static void sort(double[] arr, double temp[])
	{
		int len = arr.length, width, beg;
		int merged = 0;
		for(width = 1; width < len; width = width*2 )
		{
			for(beg = 0; beg < len; beg = beg + 2*width)
			{
				int ptr1, ptr2, right;
				ptr1 = beg;																//ptr1 for "arrayA"
				ptr2 = Math.min(beg + width, len);			//ptr1 for "arrayB"
				right = Math.min(beg + 2*width, len);   //arr[ptr1:right]
				merge(arr, ptr1, ptr2, right, temp);
			}
			for(int i = 0; i < len; i++)
			{
				arr[i] = temp[i];
			}
			System.out.println("Partion " + ++merged
				+ " :  " + Arrays.toString(arr) + "\n");
		}
		System.out.println("Done: " + Arrays.toString(arr));
	}

	public static void main(String[] args)
	{
		double[] arr ={1, 20, 9, 8};
		double[] temp = new double[arr.length];
		sort(arr, temp);
	}
}
