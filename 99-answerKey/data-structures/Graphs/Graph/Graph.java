import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph{



	private List<Edge>[] sources;
	//Edge = sourceVertex----edgeWeight------->targetVertex

	@SuppressWarnings("unchecked")
	public Graph(int size)
	{
		sources = (ArrayList<Edge>[])new ArrayList[size];
		initarr(sources, size);
	}


	public void initarr(List<Edge>[] sources, int size)
	{
		for(int i = 0; i < size; i++)
		{
			sources[i] = new ArrayList<Edge>();
		}
	}

	public List<Edge> getOtherSources(int target)
	{
		return sources[target];
	}




	public Edge setDirectedEdge(int vSource, int vTarget,
	 double eWeight)
	{
		List<Edge> sources = getOtherSources(vTarget);
		Edge edge = new Edge(vSource, vTarget, eWeight);
		sources.add(edge)
	}


}
