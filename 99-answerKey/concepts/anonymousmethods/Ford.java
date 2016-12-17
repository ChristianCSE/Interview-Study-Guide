public class Ford extends CarShop implements Car
{

	int miles;
	String color;
	int year;

	public Ford(int miles, String color, int year)
	{
		this.miles = miles;
		this.color = color;
		this.year = year;
	}

	public int getMileage()
	{
		return miles;
	}

	public String getColor(){
		return color;
	}

	public int getYearModel()
	{
		return year;
	}

	public void emptySet(int i)
	{

	}
}
