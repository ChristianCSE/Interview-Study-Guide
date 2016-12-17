public class Solution
{

	public static void moveZeroes(int[] nums)
	{
		int len = nums.length;
		if(len < 2)
		{
			return;
		}
		for(int i = len-1; i >= 0; i--){
			if(nums[i]==0){
					for(int ptr = i; ptr < len-1; ptr++)
					{
						int temp = nums[ptr];
						nums[ptr] = nums[ptr+1];
						nums[ptr+1] = temp;
					}//for()
				}//if()
			}//for()
    }

    public static void testerArr(int[] arr)
    {
		moveZeroes(arr);
		System.out.println(java.util.Arrays.toString(arr));
    }

	public static void main(String[] args)
	{
		testerArr(new int[]{0, 1, 0, 3, 12});
		testerArr(new int[]{0, 0, 1});
	}
}


