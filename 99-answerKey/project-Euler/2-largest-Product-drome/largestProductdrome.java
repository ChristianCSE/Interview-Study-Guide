import java.util.*; 

public class largestProductdrome {

	private static int loopthroghthem() {
		int i,j; 
		int yourdrome = 0;
		for(i = 100; i < 1000; i++){
			for(j = 100; j < 1000; j++){
				if(theRealDrome(i, j)){
					if((i*j) > yourdrome){
						yourdrome = i*j;	
					} 
				}
			}
		}
		return yourdrome; 
	}


	private static boolean theRealDrome(int outer, int inner)
	{	
		int potenialDrome = outer*inner; 
		String[] drome = (((Integer)potenialDrome).toString()).split("");
		int len = drome.length - 1;
		int i; 
		for(i = 0; i <= len/2; i++)
		{
			if(! drome[i].equals(drome[len-i]) )
			{
				return false; 
			}
		}
			return true; 
	}

	private static boolean oldDrome(int i, int j) {
		int potentialdrome = i * j; 
		String maybes = Integer.toString(potentialdrome);
		int length = maybes.length();
		int o, p = 0; 
		for(o = 0, p = length - 1; o < length/2; o++, p--){
			String front = maybes.substring(o, o+1);
			String back;
			if(p == length - 1){
				 back = maybes.substring(p);
			}
			else
			{
				back = maybes.substring(p, p+1);
			} 
			if(front.compareTo(back) != 0){
				return false; 
			}
		}
		return true; 
	}

	public static void main (String args[])
	{
		int holder = loopthroghthem(); 
		System.out.println(holder);
	}

}
