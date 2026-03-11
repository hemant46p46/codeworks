package codeworks.doublylinkedlist;

public class DLLTest {
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.printList();
		dll.addFirst(10);
		dll.addFirst(20);
		dll.addFirst(30);
		dll.printList();
		
		dll.addLast(100);
		dll.addLast(200);
		dll.addLast(300);
		dll.printList();
		
//		dll.deleteFirst();
//		dll.deleteLast();
//		dll.deleteFirst();
//		dll.deleteLast();
//		dll.printList();
		
		dll.reverseList();
		System.out.println("After reverse");
		dll.printList();
	}
}
