// September 23, 2019
public class IntNodeTest {
	
	public static void main(String[] args) {
		
		// Testing basic functions with one IntNode
		
		IntNode head = new IntNode();
		System.out.println("head.getData:	" + head.getData());
		System.out.println("head.getLink:	" + head.getLink());
		System.out.println("listLength:	" + IntNode.listLength(head));
		System.out.println("search for 0:	" + IntNode.search(head, 0));
		System.out.println("search for 1:	" + IntNode.search(head, 1));
		System.out.println("head.toString:				" + head.toString());
		head.removeNodeAfterThis();
		System.out.println("After head.removeNodeAfterThis:		" + head.toString());
		System.out.println();
		
		// Testing basic functions with two IntNodes
		
		head.addNodeAfterThis(1);
		System.out.println("After head.addNodeAfterThis(1):		" + head.toString());
		System.out.println("listLength: 		" + IntNode.listLength(head));
		System.out.println("search for 0: 		" + IntNode.search(head, 0));
		System.out.println("search for 1:		" + IntNode.search(head, 1));
		System.out.println("search for 2:		" + IntNode.search(head, 2));
		head.removeNodeAfterThis();
		System.out.println("After head.removeNodeAfterThis:		" + head.toString());
		System.out.println();
		
		// Testing add function to create a proper node list
		
		head.addNodeAfterThis(1);
		System.out.println("After head.addNodeAfterThis(1):		" + head.toString());
		head.addNodeAfterThis(2);
		System.out.println("After head.addNodeAfterThis(2):		" + head.toString());
		head.addNodeAfterThis(3);
		System.out.println("After head.addNodeAfterThis(3):		" + head.toString());
		head.addNodeAfterThis(4);
		System.out.println("After head.addNodeAfterThis(4):		" + head.toString());
		head.addNodeAfterThis(5);
		System.out.println("After head.addNodeAfterThis(5):		" + head.toString());
		System.out.println();
		
		// Making a new node to test add/remove in middle of node list
		
		IntNode four = head;
		four = four.getLink();
		four = four.getLink();
		four.addNodeAfterThis(11);
		System.out.println("After four.addNodeAfterThis(11):	" + head.toString());
		System.out.println("listLength(head):	" + IntNode.listLength(head));
		four.removeNodeAfterThis();
		System.out.println("After four.removeNodeAfterThis():	" + head.toString());
		System.out.println("listLength(head):	" + IntNode.listLength(head));
		
		// Testing range of search using previous four node
		
		System.out.println("search for 4(start from 0): 	" + IntNode.search(head, 4));
		System.out.println("search for 4(start from 4): 	" + IntNode.search(four, 4));
		System.out.println("search for 4(start from 3): 	" + IntNode.search(four.getLink(), 4));
		System.out.println("search for 0(start from 0): 	" + IntNode.search(head, 0));
		System.out.println("search for 1(start from 0): 	" + IntNode.search(head, 1));
		System.out.println();
		
		// Testing how to add node before current head node and after tail node
		
		IntNode index = new IntNode(-28, head);
		head = index;
		System.out.println("head.toString:				" + head.toString());
		System.out.println("listLength(head):	" + IntNode.listLength(head));
		index = head.getLink().getLink().getLink().getLink().getLink().getLink();
		index.addNodeAfterThis(28);
		System.out.println("head.toString:				" + head.toString());
		System.out.println("listLength(head):	" + IntNode.listLength(head));
		System.out.println();
		
		// Testing toString print range
		
		index = head;
		System.out.println("index.toString:				" + index.toString());
		index = index.getLink();
		System.out.println("index.toString:				" + index.toString());
		index = index.getLink();
		System.out.println("index.toString:				" + index.toString());
		index = index.getLink();
		System.out.println("index.toString:				" + index.toString());
		index = index.getLink();
		System.out.println("index.toString:				" + index.toString());
		index = index.getLink();
		System.out.println("index.toString:				" + index.toString());
		index = index.getLink();
		System.out.println("index.toString:				" + index.toString());
		index = index.getLink();
		System.out.println("index.toString:				" + index.toString());
		
	}// main
	
}// IntNodeTest
