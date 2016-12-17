class stringcompression{


	public static String compression(String candidate)
	{
		candidate = candidate + " "; //last letter 
		int length = candidate.length();
		char[] seperated = candidate.toCharArray();
		String possibleAlt = ""; 
		int count = 1; 
		for(int i = 1; i < length; i++)
		{
			if(seperated[i] != seperated[i-1])
			{	
				possibleAlt = possibleAlt + seperated[i-1] + "" + count; 
				count = 1; //reset count
			}
			else
				count++;
		}
		int newLength = possibleAlt.length(); 
		if(length <= newLength)
		{
			return candidate;
		}
		return possibleAlt;
	}


	public static void main(String[] a)
	{
		String longated = "aabcccccaaa";
		System.out.println(compressIt(longated)); 
		System.out.println(compression(longated));
		longated = "aaccaa";
		System.out.println(compressIt(longated)); 
		System.out.println(compression(longated));
	}
}
