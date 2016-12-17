import java.util.*; 
public class minMultiple20 {

	//smallest number that's divisible by 1-20. 
	public static void minDiv1to20()
	{
		int num = 100;  
		while(true)
		{
			if(isitdiv(num))
			{
				System.out.println("this is the smallest number evenly" + 
				 "\ndivisible by 1-20: "  + num);
				return;
			}
			if(num == 2147483646)
			{
				break; //catch overflow
			}
			num = num + 2; 
		}
		System.out.println("no valid number: overflow!");
	}

	public static boolean isitdiv(int holder) {
		for(int i = 3; i <= 20; i++){
			if(holder%i != 0){
				return false;
			}
		}
		return true; 
	}

	public static void main(String args[])
	{
		minDiv1to20(); 
	}
}
