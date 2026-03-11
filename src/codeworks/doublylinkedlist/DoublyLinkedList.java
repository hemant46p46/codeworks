package codeworks.doublylinkedlist;

public class DoublyLinkedList {
	DNode head;
	public DoublyLinkedList() {
		this.head = null;
	}
	protected boolean isEmpty() {
		return this.head==null;
	}
	protected void addFirst(int x) {
		DNode p = new DNode(x);
		if(this.head==null) {
			this.head = p;
			return;
		}
		p.next = this.head;
		this.head.prev = p;
		this.head = p;
	}
	protected void addLast(int x) {
		DNode p = new DNode(x);
		if(this.head==null) {
			this.head = p;
			return;
		}
		DNode temp = this.head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = p;
		p.prev = temp;
	}
	protected void printList() {
		if(isEmpty()) {
			System.out.println("DLL is Empty");
			return;
		}
		DNode temp = this.head;
		System.out.println("---------");
		while(temp!=null) {
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
		System.out.println("---------");
	}
	protected void deleteFirst() {
		if(isEmpty()) {
			System.out.println("List is Empty");
			return;
		}
		if(this.head.next==null) {
			this.head = null;
			return;
		}
		this.head = this.head.next;
		this.head.prev=null;
	}
	protected void deleteLast() {
		if(isEmpty()) {
			System.out.println("List is Empty");
			return;
		}
		if(this.head.next==null) {
			this.head = null;
			return;
		}
		DNode temp = this.head;
		while(temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
	}
	protected void reverseList() {
		if(this.head==null || this.head.next == null) {
			return;
		}

		
		DNode curr = this.head, temp = null;
		while(curr != null) {
			temp = curr.prev;
			curr.prev = curr.next;
			curr.next = temp;
			
			curr = curr.prev;
		}
		if(temp!=null) {
			this.head = temp.prev;
		}
	}
}
