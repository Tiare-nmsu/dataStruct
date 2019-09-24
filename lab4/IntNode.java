// September 23, 2019
public class IntNode {
	
	private int data;
	private IntNode link;
	
	/**
	*	@function IntNode()
	*	Construct an IntNode object with data = 0  and link = null
	* 	@precondition none
	*/
	public IntNode() {
		data = 0;
		link = null;
	}// default constructor
	
	/**
	*	@function IntNode(int newData, IntNode newNode)
	*	Copy constructs an IntNode given the data and link
	*	@param	newData
	*	 The data of the new IntNode constructed
	*	@param	newNode
	*	 The link of the new IntNode constructed
	* 	@precondition none
	*/
	public IntNode(int newData, IntNode newNode){
		data = newData;
		link = newNode;
	}// copy constructor
	
	/**
	*	@function int getData()
	*	Get data of current node
	*	@return int
	*	The current value of data
	* 	@precondition none
	*/
	public int getData() {
		return data;
	}
	/**
	*	@function IntNode getLink()
	*	Get link of current node
	*	@return IntNode
	*	The current value of link
	* 	@precondition none
	*/
	public IntNode getLink() {
		return link;
	}
	/**
	*	@function setData(int newData)
	*	Set a new value for data
	*	@param	newData
	*	 The new value of data
	* 	@precondition none
	*/
	public void setData(int newData) {
		data = newData;
	}
	/**
	*	@function setLink(IntNode newNode)
	*	Set new value of link
	*	@param	newNode
	*	 The new value of link
	* 	@precondition none
	*/
	public void setLink(IntNode newNode) {
		link = newNode;
	}
	
	/**
	*	@function String toString()
	*	Help print an IntNode list starting with current IntNode
	*	@return String
	*	The IntNode list
	* 	@precondition none
	*/
	public String toString() {
		
		String list = "" + data;
		IntNode cursor = link;
		
		while(cursor != null) {
			list = list + "->" + cursor.getData();
			cursor = cursor.getLink();
		}// end while
		
		return list;
		
	}// to String
	
	/**
	*	@function addNodeAfterThis(int newdata)
	*	Add a node after current node
	*	@param newdata
	*	 The data of the new node to be added
	* 	@precondition none
	*/
	public void addNodeAfterThis(int newdata) {		
		
		IntNode add = new IntNode(newdata, link);
		link = add;
		
	}// addNodeAfterThis
	
	/**
	*	@function removeNodeAfterThis()
	*	Remove node after current node
	* 	@precondition
	* 	current node should be initialized or constructed
	*/
	public void removeNodeAfterThis() {
		if(getLink() == null)
			return;
		IntNode next = getLink();
		next = next.getLink();
		setLink(next);
		
	}// removeNodeAfterThis
	
	/**
	*	@function int listLength(IntNode head)
	*	Returns length of node list
	*	@param	head
	*	The first node to begin counting from
	*	@return int
	*	The number of nodes in list from head
	* 	@precondition
	* 	head is not null
	*/
	public static int listLength(IntNode head) {
		if(head.getLink() == null)
			return 1;
		else {
			
			int cnt = 0;
			IntNode cursor = head;
			
			while(cursor != null) {
				cnt++;
				cursor = cursor.getLink();
			}// while
			
			return cnt;
		
		}// else
	}// listLength
	
	/**
	*	@function boolean search(IntNode head, int data)
	*	Returns whether a value appears in node list given from head node
	*	@param	head
	*	The first node to begin searching from
	*	@param	data
	*	Value to search for
	*	@return boolean
	*	True if value found, false if value not found
	* 	@precondition 
	* 	head is not null
	*/
	public static boolean search(IntNode head, int data) {
		
		IntNode cursor = head;
		
		while(cursor != null) {
			
			if(cursor.getData() == data)
				return true;
			
			cursor = cursor.getLink();
			
		}// while
		
		return false;
		
	}// search
	
}// IntNode end
