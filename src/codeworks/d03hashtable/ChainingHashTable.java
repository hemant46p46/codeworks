package codeworks.d03hashtable;



public class ChainingHashTable {
	static class Node {
	    int data;
	    Node next;

	    Node(int data) {
	        this.data = data;
	        this.next = null;
	    }
	}
	
    Node[] table;
    int size;
    ChainingHashTable(int size) {
        this.size = size;
        table = new Node[size];
    }
    private int hash(int key) {
        return key % size;
    }

    public void insert(int key) {
        int index = hash(key);
        Node newNode = new Node(key);
        if(table[index] == null) {
            table[index] = newNode;
            return;
        }
        Node temp = table[index];
        while(temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    public boolean search(int key) {
        int index = hash(key);
        Node temp = table[index];
        while(temp != null) {
            if(temp.data == key)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public void delete(int key) {
        int index = hash(key);
        Node temp = table[index];
        Node prev = null;
        while(temp != null) {
            if(temp.data == key) {
                if(prev == null)
                    table[index] = temp.next;
                else
                    prev.next = temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.println("Key not found");
    }

    public void print() {
        for(int i=0;i<size;i++) {
            System.out.print(i+" -> ");
            Node temp = table[i];
            while(temp != null) {
                System.out.print(temp.data+" -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
}