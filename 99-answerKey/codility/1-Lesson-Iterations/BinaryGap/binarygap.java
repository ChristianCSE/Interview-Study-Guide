import java.util.regex.Matcher;
import java.util.regex.Pattern;

class binarygap{
	//binary gap = max # of zeros b/w 1 and the other 1 in a binary number
	// 1000010001 => 4
	/* 100101  for() lowest valid: 101 => 1+0+4 = 5  */         
		public static int solution(int N) {
		// Integer.toBinaryString(N);
			if (N <= 5) {
				return 0; 
			}
			//String.valueOf(N);
			String number = Integer.toBinaryString(N);
			//int intstring = Integer.parseInt("string");
			//Integer.toString(n,2) // decimal to binary
			if (number.length() <= 2) {
				return 0;
			} 
			//String gaps = "[1-9]0+[1-9]";
			String gaps = "10+1";
			Pattern r = Pattern.compile(gaps);
			Matcher finding = r.matcher(number);
			int max = 0; 
			while (finding.find()) {   
				int possibleGap = finding.group(0).length() - 2 ;
				if ( possibleGap > max) {
					max = possibleGap;
				}
			}
			return max; 
		}
	
	public static String reverse ( String s ) {
		int length = s.length(), last = length - 1;
		char[] chars = s.toCharArray();
		for ( int i = 0; i < length/2; i++ ) {
			char c = chars[i];
			chars[i] = chars[last - i];
			chars[last - i] = c;
		}
		return new String(chars);
	}

 public static void reverseIt() {
 	String reverseMe = "reverse me!";
 	for (int i = 0; i < reverseMe.length(); i++) {
 		reverseMe = reverseMe.substring(1, reverseMe.length() - i)
 		+ reverseMe.substring(0, 1)
 		+ reverseMe.substring(reverseMe.length() - i, reverseMe.length());
		System.out.println(reverseMe);
		System.out.println(reverseMe.substring(1, reverseMe.length() - i));
		System.out.println(reverseMe.substring(0, 1));
		System.out.println(reverseMe.substring(reverseMe.length() - i, reverseMe.length())); 
		}
	System.out.println(reverseMe);
	}

// Example 4:  Write a function that sums up integers from a text file, one int per line.
	public static void sumFile ( String name ) {
		try {
			int total = 0;
			BufferedReader in = new BufferedReader ( new FileReader ( name ));
			for ( String s = in.readLine(); s != null; s = in.readLine() ) {
				total += Integer.parseInt ( s );
			}
			System.out.println ( total );
			in.close();
		} catch ( Exception xc ) {
			xc.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int gaps = solution(1041);
		System.out.println(gaps);
		reverseIt();
	}
}
