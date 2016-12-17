package DoublyLinkedList;
import LinkedLists.AbstractDoublyLinkedList;


public class DoublyLinkedList extends AbstractDoublyLinkedList
{
	private int size;
	Node head;
	Node tail;

	public DoublyLinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}


//put last
@Override
	public void putNode(int data) {
		size++;
		Node node = new Node(data);
		if(head == null)
		{
			head = node;
			head.next = tail;
			tail = head; //!!!or else null pointer!!!
		}
		else
		{
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
	}

//old way BUT with tail pointer avoid this
	public void oldPutNode(int data)
	{
		Node node = new Node(data);
		if(head == null){
			head = node;
			head.next = tail;
			tail = head; //!!!or else null pointer!!!
		}
		else {
			Node ptr = head;
			while(ptr != null)
			{
				ptr = ptr.next;
			}
			ptr = node;
		}
	}

//place in the front
	@Override
	public void newHead(int data) {
		Node node = new Node(data);
		//empty list is always a possibility
		if(head == null)
		{
			head = node;
		}
		else
		{
			head.prev = node;
			node.next = head;
			head = node;
		}
	}

	@Override
	public void putMultiNodes(int... nodes) {
		for(int i : nodes)
			putNode(i);
	}

	@Override
	public Node removeHead() throws Exception {
		if(head == null)
		{
				throw new Exception("Empty list");
		}
		else
		{
			head = head.next;
		}
		return head;
	}

	//should returning tail be done?
	@Override
	public Node removeTail() throws Exception {
		if(head == null)
		{
			throw new Exception("Empty list");
		}
		else{
			tail = tail.prev;
			tail.next = null; //you need this since you will still point to next
		}
		return tail;
	}


	@Override
	public void deleteNode(int data) throws Exception
	{ //again 3 cases: empty, head, general
		if(head == null)
		{
			throw new Exception("Empty list");
		}
		else if(head.data == data)
		{
			head = null;
			return;
		}
		else
		{//general case
			Node ptr1 = head;
			Node ptr2 = head.next;
			boolean foundit = false;
			while(ptr2 != null)
			{
				if(ptr2.data == data)
				{
					 foundit = true;
					break;
				}
				else
				{
					ptr1 = ptr2;
					ptr2 = ptr2.next;
				}
			}
			//is ptr2.next null or value?
			//matters since <---> connection
			if(ptr2.next == null && foundit)
			{
				//this is the last node: cut connections
				ptr1.next = null;
				ptr2.prev = null;
				return;
			}
			else if(foundit)
			{
				//this mean the previous POINTER of the node after ptr2
				ptr2.next.prev = ptr1;
				ptr1.next = ptr2.next;
				//cut all connections
				ptr2.next = null;
				ptr2.prev = null;
			}
			else
				return;
		}
	}

	@Override
	public void autoLinkedList(int size)
	{
    if(size <= 2)
    {
      System.out.println("Must be larger than 2 nodes");
      return;
    }
    else{
    this.size = size;
    while(size != 0)
    		{
		      int data = (int)( Math.random()*10);
		      putNode(data);
		      size--;
    		}//while
		}//else
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	@Override
	public void listToString() {
		System.out.print("[");
		String doublyLL = "";
		for(Node ptr = head;  ptr != null;  ptr = ptr.next)
		{
			doublyLL =  doublyLL + ptr.data;
			if(ptr.next != null) {doublyLL =  doublyLL + "<---->";}
		}
		System.out.print(doublyLL + "]\n");
	}

}
