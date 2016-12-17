public class test{


	public static void emptySet(Car aCar)
	{
		for(int i = 0; i < 10; i++)
		{
			aCar.emptySet(i);
		}
	}
	public static void main(String[] args)
	{
		Car emptyCar = new Ford(0, "blue", 2016);
		emptySet(emptyCar);

		emptySet(new Ford(900, "red", 1999) {
			@Override
			public void emptySet(int i)
			{
				System.out.println(i);
			}
		});

		Car myCar = new Ford(90, "blue", 2010);
		emptySet(myCar);

	}
}
