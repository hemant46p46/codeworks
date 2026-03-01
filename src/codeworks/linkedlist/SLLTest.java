package codeworks.linkedlist;

public class SLLTest {
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.printList();
		sll.addLast(10);
		sll.addLast(20);
		sll.printList();
		
		sll.addFirst(100);
		sll.addFirst(200);
		sll.printList();
		
		sll.deleteFirst();
		sll.printList();
		
		sll.deleteLast();
		sll.printList();
		
		sll.addFirst(1000);
		sll.addFirst(2000);
		sll.addFirst(3000);
		sll.printList();
		sll.reverseList();
		sll.printList();
	}
}