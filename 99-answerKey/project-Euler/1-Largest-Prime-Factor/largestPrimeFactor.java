import java.util.*; 

public class largestPrimeFactor {
	
	
	public static void main (String args[]){
		long i = 2;
		long hi = 600851475143L;
		long largest_prime_factor = 0; 
		
		while(i < hi){
			if(hi % i == 0)
			{
				if(isdivprime(i)){
					largest_prime_factor = i;
					System.out.println(largest_prime_factor);
				}
			}
			i++;
		}
	System.out.println("this is the largest "
			+ "prime factor of the number " + largest_prime_factor);
	}

	private static boolean isdivprime(long i) {
		if(i == 2){
			return true;
		} 
		long tracer = 2; 
		// boolean isprime = true; 
		for(long ending = 2; ending < i; ending++){
			if(i%ending == 0){
				return false;
			}	
		}
		return true;
	}

}
