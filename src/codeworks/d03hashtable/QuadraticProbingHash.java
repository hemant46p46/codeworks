package codeworks.d03hashtable;

public class QuadraticProbingHash {
    int[] table;
    int size;
    int count;

    QuadraticProbingHash(int size) {
        this.size = size;
        table = new int[size];
        count = 0;
        for(int i=0;i<size;i++)
            table[i] = -1; // EMPTY
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(int key) {
        if(count == size) {
            System.out.println("Hash Table Full");
            return;
        }
        int hash = hash(key);
        int i = 0;
        int index;
        while(i < size) {
            index = (hash + i*i) % size;
            if(table[index] == -1 || table[index] == -2) {
                table[index] = key;
                count++;
                return;
            }
            i++;
        }
        System.out.println("Cannot insert key");
    }

    public boolean search(int key) {
        int hash = hash(key);
        int i = 0;
        int index;
        while(i < size) {
            index = (hash + i*i) % size;
            if(table[index] == -1)
                return false;
            if(table[index] == key)
                return true;
            i++;
        }
        return false;
    }

    public void delete(int key) {
        int hash = hash(key);
        int i = 0;
        int index;
        while(i < size) {
            index = (hash + i*i) % size;
            if(table[index] == -1) {
                System.out.println("Key not found");
                return;
            }
            if(table[index] == key) {
                table[index] = -2; // mark deleted
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
