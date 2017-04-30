package SinglyLinkedList;


public class SinglyTasks{
	/*
	These are tasks done on Linked Lists
	This doesn't alter the actual Linked List
	 */
	static public void weaveNodes(SinglyLinkedList list)
	{
		Node head = list.getHead();
		Node ahead = head;
		int length = getLength(head);
		for(int i = 0; i < length/2; i++)
		{
			ahead = ahead.next;
		}
		//weave You actually constructed a new List 
		SinglyLinkedList weavedList = new SinglyLinkedList();
		while(ahead != null)
		{
			weavedList.putNode(head.data);
			weavedList.putNode(ahead.data);
			head = head.next;
			ahead = ahead.next;
		}
		System.out.print("Weaved Linked list [Done inside]: ");
		weavedList.listToString();
	}

//These do in fact change them 
//Note we have to do some internal updating
	public  static void Myreversal(SinglyLinkedList list) { 
		Node head = list.getHead(); 
		if(head == null) {
			System.out.println("Empty");
			return;
			}
		else
		{
			Node temp; 
			Node ptr1 = head; 
			Node ptr2 = head.next; 
			while(ptr2 != null)
			{
				if(ptr1 == head)
				{
					temp = ptr2.next; 
					ptr2.next = ptr1; 
					ptr1.next = null; // or else not null catch
					ptr1 = ptr2; 
					ptr2 = temp; 
				}
				else{
					temp = ptr2.next; 
					ptr2.next = ptr1; 
					ptr1 = ptr2; 
					ptr2 = temp; 
				}
			}
			head = ptr1;
		}
		list.newHead(head);
		System.out.print("Reversed [Done inside]: ");
		list.listToString();
	}


	static public int getSum(Node head)
	{
		int sum = 0;
		for(Node ptr = head;  ptr != null; ptr = ptr.next)
		{
			sum += ptr.data;
		}
		return sum;
	}

	static public int getLength(Node head)
	{
		int length = 0;
		Node ptr = head;
		while(ptr != null)
		{
			length++;
			ptr = ptr.next;
		}
		return length;
	}

	public static void main(String[] args)
	{
		SinglyLinkedList list = new SinglyLinkedList();
		int[] nodes = {1, 2, 3, 4, 5, 6, 7, 8};
		list.putMultiNodes(nodes);
		System.out.print("Linked List: ");
		list.listToString();
		
//		These are altering lists:
			weaveNodes(list);
//	These are altering lists: 
		Myreversal(list);
		
		
		list.listReversal();
		System.out.print("Reversed: ");	
		list.listToString();
		
		
		
		
		System.out.print("This is an ordered Singly Linked List: ");
		SinglyLinkedList list2 = new SinglyLinkedList(); 
		int[] nodes2 = {7, 2, 4, 8, 22, 9, 1};
		list2.getMultiOrdered(nodes2);
		list2.listToString();

	}
}
