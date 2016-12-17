public class tinkeringSinglyLinkedList{
	public static void main(String[] args)
	{
		SinglyLinkedList list = new SinglyLinkedList();
		int[] nodes = {0, 1, 2, 3, 4, 5, 6, 7};
		list.putMultiNodes(nodes);
		list.listToString();

		SinglyLinkedList alist = new SinglyLinkedList();
		int[] anodes = {10, 11, 12, 13, 14, 15, 16, 27};
		alist.putMultiNodes(anodes);
		alist.listToString();
	}
}
