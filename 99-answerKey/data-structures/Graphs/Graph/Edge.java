
public class Edge{

	private int vertexSource;
	private int vertexTarget;
	private double edgeWeight;

	public Edge(int vertexSource, int vertexTarget,
	 double edgeWeight)
	{
		this.vertexSource = vertexSource;
		this.vertexTarget = vertexTarget;
		this.edgeWeight = edgeWeight;
	}

	/*================================
	Setters
	================================**/
	public void increaseWeight(double moreWeight)
	{
		edgeWeight += moreWeight;
	}

	public void resetWeight(double edgeWeight)
	{
		this.edgeWeight  = edgeWeight;
	}


	/*================================
	Getters
	================================**/
	public int getSource()
	{
		return vertexSource;
	}

	public int getTarget()
	{
		return vertexTarget;
	}

	public double getEdgeWeight()
	{
		return edgeWeight;
	}

	public String toString()
	{
		return getSource() + "	-------" + getEdgeWeight() + "----->" + getTarget();
	}

}
