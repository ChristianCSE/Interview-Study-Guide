public class BubbleSort{

	public int[] sort(int[] arr){
		int k = arr.length -1, i, temp;
		boolean wire = false;
		while(!wire){
			wire = true;
			for( i = 0; i < k; i++)
			{
				if (arr[i] > arr[i+1])
				{
					temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					wire = false;
				}
			}//for()
			k--;
		}//while()
		return arr;
	}

}
