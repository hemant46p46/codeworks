package codeworks.linkedlist;

public class SinglyLinkedList {
	private SNode head;
	SinglyLinkedList(){
		this.head = null;
	}
	protected boolean isEmpty(){
		return this.head==null;
	}
	protected void printList() {
		System.out.println("--------");
		if(isEmpty()) {
			System.out.println("Empty List");
			System.out.println("--------");
			return;
		}
		SNode temp = this.head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		System.out.println("--------");
	}
	protected void addLast(int data) {
		SNode p = new SNode(data);
		if(isEmpty()) {
			this.head = p;
			return;
		}else{
			SNode temp = this.head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = p;
		}
	}
	protected void addFirst(int data) {
		SNode p = new SNode(data);
		if(isEmpty()) {
			this.head = p;
			return;
		}else{
			p.next = this.head;
			this.head = p;
		}
	}
	protected void deleteFirst() {
		if(this.isEmpty()) {
			System.out.println("Can't delete, list is Empty");
			return;
		}
		if(this.head.next == null) {
			this.head = null;
			return;
		}
		this.head = this.head.next;
	}
	protected void deleteLast() {
		if(isEmpty()) {
			System.out.println("Can't delete, List is empty");
			return;
		}
		if(this.head.next==null) {
			this.head = null;
			return;
		}
		SNode temp = this.head;
		while(temp.next.next!=null) {
			temp = temp.next;
		}
		temp.next = null;
	}
	
	protected void reverseList() {
	    if (isEmpty() || head.next == null) {
	        return;
	    }
	    SNode prev = null;
	    SNode curr = head;
	    SNode next = null;
	    while (curr != null) {
	        next = curr.next; 
	        curr.next = prev;
	        prev = curr;     
	        curr = next;  
	    }
	    head = prev;
	}
}
