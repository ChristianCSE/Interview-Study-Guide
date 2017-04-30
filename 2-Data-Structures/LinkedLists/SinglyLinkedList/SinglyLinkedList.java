package SinglyLinkedList;

import LinkedLists.AbstractLinkedList;
/*This is an unordered Linked List*/
public class SinglyLinkedList extends AbstractLinkedList{

	private int size;
	private  Node head;
	//non-static head, hence, internal update, 
	//if you do head = new Node() outside this doesn't influence the head
	public SinglyLinkedList()
	{
		head = null;
		size = 0;
	}
	/*================================================
	Setters: putNode(),  newHead(), putMultiNodes(), removeHead(),
	removeTail(),  deleteNode(), autoLinkedList()
	================================================*/
	
	public void insertOrderSLL(int data)
	{
		Node node = new Node(data);
		//3 cases: general: b/w two nodes, head, empty
		if(head == null)
		{
			head = node; 
			node.next = null; 
		}
		else if(head.data >= node.data)
		{
			node.next = head; 
			head = node; 
		}
		else
		{
			//general case: two pointers 
			 Node ptr1 = head;
			 Node ptr2 = head.next;
			while(ptr2 != null)
			{
				if( ptr2.data >= node.data )
				{
					break;
				}
				ptr1 = ptr2; 
				ptr2 = ptr2.next;
			}//while() 
			ptr1.next = node; 
			node.next = ptr2;
		}
	}
	
	public void getMultiOrdered(int[] nodes)
	{
			for(int i : nodes)
				insertOrderSLL(i);
	}
	
	@Override
	public void putNode(int data)
	{
		size++;
		Node node = new Node(data);
		//this could be the head
		if(head == null)
		{
			head = node;
			head.next = null; //is this needed
		}
		else
		{
			Node ptr = head;
			while(ptr.next != null)
			{
				ptr = ptr.next;

			}
			//found tail
			ptr.next = node; //set tail
			ptr.next.next = null;
		}
	}

	@Override
public void newHead(Node head)
{
	this.head = head;
}

	@Override
public void putMultiNodes(int[] nodes)
{
		for(int i : nodes)
			putNode(i);
}

	@Override
	public Node removeHead() throws Exception
	{
		if(head == null){
			throw new Exception("Empty list");
		}
		Node temp = head; //store head reference before it's moved
		head = head.next;
		return temp;
	}

	@Override
	public Node removeTail()
	{
		//empty linked list
		if(head == null) { return null; }
		Node ptr = head;
			while(ptr.next != null)
			{
				ptr = ptr.next;
			}
			//found tail
			ptr = null;
			return head;
	}

	/**
	 * @param  The node with the data you want to delete
	 * @return    Head with new list adjustments
	 */
	@Override
	public Node deleteNode(int data)
	{
		//empty linked list
		if(head == null) { return null; }
		if(head.data == data)
		{
			if(head.next != null)
			{
				head = head.next;
				return head;
			}
			else
				head = null;
				return null;
		}

		Node ptr = head;
		while(ptr.next != null)
		{
			if(ptr.next.data == data)
			{
				ptr.next = ptr.next.next;
				return head; //this never moved
			}
			ptr = ptr.next;
		}
		return head; //not found
	}


 /**@param  A new unordered SLL of size size*/
	@Override
  public  void autoLinkedList(int size)
  {

    if(size < 1)
    {
      System.out.println("invalid size");
      return;
    }
   if(size < 3)
    {
      size = (2*size) + 1; //1 = head
    }
    this.size = size;
    head = new Node(  (int)( Math.random()*10)  );
    size = size - 1;

    while(size != 0)
    {
      int data = (int)( Math.random()*10);
      putNode(data);
      size--;
    }
  }


	/*============================================
	Getters: getSize(), getHead(), listToString()
	============================================*/
	@Override
 public int getSize()
	{
		return size;
	}
	
	//this should be called getList()
	@Override
	public Node getHead()
	{
		return head;
	}
	
	public  void listReversal() { 
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

	}
	
	
	
	@Override
	public void listToString()
	{
		System.out.print("[");
		String singlyLL = "";
		for(Node ptr = head;  ptr != null;  ptr = ptr.next)
		{
			singlyLL =  singlyLL + ptr.data;
			if(ptr.next != null) {singlyLL =  singlyLL + "->";}
		}
		System.out.print(singlyLL + "]\n");
	}

}
