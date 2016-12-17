import java.util.*;
import java.io.*;
import java.util.regex.Pattern;
public class testing{

	public static void formLinks(InputStream sourceWlink, int vertices) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(sourceWlink));
		Pattern spaced = Pattern.compile(" ");
		int[][] sourceTarget = new int[vertices][];
		int[] linksToID;
		String connections;
		String[] allTargets;
		int i = 0, j;
		while( (connections = reader.readLine()) != null )
		{
			connections = connections.trim();
			if(connections.isEmpty())
			{
				sourceTarget[i] = new int[0]; //safe-guard from future null checks.
			}
			else
			{
				allTargets = connections.split(" ");
				linksToID = new int[allTargets.length]; // contain all ID of nodes connected to
				for(j = 0; j < linksToID.length; j++)
				{
					linksToID[j] = Integer.parseInt(allTargets[j]);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception
	{
		int vertices = 100;
		String LINK_FILE = "wiki-links.txt";
		formLinks( new FileInputStream(LINK_FILE) , vertices) ;
	}
}
