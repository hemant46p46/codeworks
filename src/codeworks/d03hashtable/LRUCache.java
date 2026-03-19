package codeworks.d03hashtable;

public class LRUCache {
    int capacity;
    int size;
    MyMap map;
    Node head;
    Node tail;
    LRUCache(int capacity){
        this.capacity = capacity;
        map = new MyMap(100);
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
}

class MyMap {
    MapNode[] table;
    int capacity;
    MyMap(int capacity){
        this.capacity = capacity;
        table = new MapNode[capacity];
    }

    int hash(int key){
        return key % capacity;
    }

    public Node get(int key){
        int index = hash(key);
        MapNode temp = table[index];
        while(temp!=null){
            if(temp.key==key)
                return temp.value;
            temp=temp.next;
        }
        return null;
    }

    public void put(int key, Node value){
        int index = hash(key);
        MapNode newNode = new MapNode(key,value);
        newNode.next = table[index];
        table[index] = newNode;
    }

    public void remove(int key){
        int index = hash(key);
        MapNode temp = table[index];
        MapNode prev = null;
        while(temp!=null){
            if(temp.key==key){
                if(prev==null)
                    table[index]=temp.next;
                else
                    prev.next=temp.next;
                return;
            }
            prev=temp;
            temp=temp.next;
        }
    }
}
class MapNode {
    int key;
    Node value;
    MapNode next;
    MapNode(int key, Node value){
        this.key = key;
        this.value = value;
    }
}

class Node {
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}