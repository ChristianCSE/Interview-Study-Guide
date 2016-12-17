import java.util.*;
//get the 1001th prime 
public class thprime {

	private static boolean isitprime(long tester) {
		for(long i = 3; i < tester; i = i + 2){
			if(tester%i == 0)
			{
				return false;
			}
		}
		return true; 
	}

	public static void get1001th()
	{
		long th = 1; //2 = 1st prime
		long tester = 3; //start at the 2nd valid prime
		while(true)
		{
			if(isitprime(tester))
			{
				th++; 
				if(th == 10001)
				{
				break; 
				}
			}
			tester = tester + 2; //skip evens
		}
		System.out.println(tester + "is the " + th + "th prime");
	}
	
	public static void main (String args[])
	{
		get1001th();
	}

}
