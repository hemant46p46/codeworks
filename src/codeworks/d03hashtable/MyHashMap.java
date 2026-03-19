package codeworks.d03hashtable;

public class MyHashMap {
	
	static class MNode {
	    int key;
	    int value;
	    MNode next;
	    MNode(int key, int value) {
	        this.key = key;
	        this.value = value;
	        this.next = null;
	    }
	}

    MNode[] table;
    int capacity;
    int size;

    MyHashMap(int capacity) {
        this.capacity = capacity;
        table = new MNode[capacity];
        size = 0;
    }

    private int hash(int key) {
        return key % capacity;
    }

    private float loadFactor() {
        return (float) size / capacity;
    }
    public void put(int key, int value) {
        int index = hash(key);
        MNode head = table[index];
        while(head != null) {
            if(head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        MNode newNode = new MNode(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
        if(loadFactor() > 0.75)
            rehash();
    }
    public Integer get(int key) {
        int index = hash(key);
        MNode temp = table[index];
        while(temp != null) {
            if(temp.key == key)
                return temp.value;
            temp = temp.next;
        }
        return null;
    }
    public void remove(int key) {
        int index = hash(key);
        MNode temp = table[index];
        MNode prev = null;
        while(temp != null) {
            if(temp.key == key) {
                if(prev == null)
                    table[index] = temp.next;
                else
                    prev.next = temp.next;
                size--;
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }
    private void rehash() {
        MNode[] oldTable = table;
        capacity = capacity * 2;
        table = new MNode[capacity];
        size = 0;
        for(int i=0;i<oldTable.length;i++) {
            MNode temp = oldTable[i];
            while(temp != null) {
                put(temp.key, temp.value);
                temp = temp.next;
            }
        }
    }
    public void print() {
        for(int i=0;i<capacity;i++) {
            System.out.print(i+" -> ");
            MNode temp = table[i];
            while(temp != null) {
                System.out.print("("+temp.key+","+temp.value+") -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
}
