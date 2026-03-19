package codeworks.d03hashtable;

public class DoubleHashing {

    int[] table;
    int size;
    int count;
    DoubleHashing(int size) {
        this.size = size;
        table = new int[size];
        count = 0;
        for(int i=0;i<size;i++)
            table[i] = -1;
    }

    private int hash1(int key) {
        return key % size;
    }

    private int hash2(int key) {
        return 5 - (key % 5);
    }

    public void insert(int key) {
        if(count == size) {
            System.out.println("Hash table full");
            return;
        }
        int h1 = hash1(key);
        int h2 = hash2(key);
        int i = 0;
        int index;
        while(i < size) {
            index = (h1 + i*h2) % size;
            if(table[index] == -1 || table[index] == -2) {
                table[index] = key;
                count++;
                return;
            }
            i++;
        }
        System.out.println("Insertion failed");
    }

    public boolean search(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);
        int i = 0;
        int index;
        while(i < size) {
            index = (h1 + i*h2) % size;
            if(table[index] == -1)
                return false;
            if(table[index] == key)
                return true;
            i++;
        }
        return false;
    }

    public void delete(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);
        int i = 0;
        int index;
        while(i < size) {
            index = (h1 + i*h2) % size;
            if(table[index] == -1) {
                System.out.println("Key not found");
                return;
            }
            if(table[index] == key) {
                table[index] = -2;
                count--;
                return;
            }
            i++;
        }
        System.out.println("Key not found");
    }

    public void print() {
        for(int i=0;i<size;i++) {
            if(table[i] == -1)
                System.out.println(i+" -> EMPTY");
            else if(table[i] == -2)
                System.out.println(i+" -> DELETED");
            else
                System.out.println(i+" -> "+table[i]);
        }
    }
}