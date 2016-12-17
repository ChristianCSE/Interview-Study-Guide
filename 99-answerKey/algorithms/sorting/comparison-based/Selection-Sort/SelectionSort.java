public class SelectionSort{

	//implicit constructor

	public int[] sort(int[] arr)
	{
		int temp;
		int min_index;
		for(int i = 0; i < arr.length; i++)
		{
			//assume min index
			min_index = i;
			for(int  j = i + 1; j < arr.length; j++)
			{
				if(arr[min_index] > arr[j])
				{
					min_index = j;
				}
			}
			//update
			temp = arr[i];
			arr[i] = arr[min_index];
			arr[min_index] = temp;
		}
		return arr;
	}
}
