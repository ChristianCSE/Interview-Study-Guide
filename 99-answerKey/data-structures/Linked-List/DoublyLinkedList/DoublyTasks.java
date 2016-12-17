package DoublyLinkedList;
public class DoublyTasks
{
	//don't want client to see in main
	public static void caller(DoublyLinkedList list, String where)
	{
		if( "head".equals(where) )
		{
			try {
				list.removeHead();
			}
			catch( Exception e)
			{
				System.out.println("Removing from an empty list");
			}
		}
		else if( "tail".equals(where) )
		{
			try {
				Node hold = list.removeTail();
			}
			catch( Exception e)
			{
				System.out.println("Removing from an empty list");
			}
		}
		else
				System.out.println("Invalid Request!");
	}


	public static void removeCaller(DoublyLinkedList list, int data)
	{
		try{
			list.deleteNode(data);
		} catch (Exception e)
		{
			System.out.println("Removing from an empty list");
		}
	}

	public static void main(String[] args)
	{
		DoublyLinkedList list = new DoublyLinkedList();
		list.putMultiNodes(5, 6, 9, 12, 15);
		System.out.println("Complete List: ");
		list.listToString();
		System.out.println("Removed Head: ");
		caller(list, "head");
		list.listToString();
		System.out.println("Removed Tail: ");
		caller(list, "tail");
		list.listToString();
		int data = 9;
		System.out.println("Removing desired: "  + data);
		removeCaller(list, data);
		list.listToString();
	}
}
