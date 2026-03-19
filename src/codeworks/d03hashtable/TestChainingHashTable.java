package codeworks.d03hashtable;

public class TestChainingHashTable {
    public static void main(String[] args) {

        ChainingHashTable h = new ChainingHashTable(7);

        h.insert(10);
        h.insert(20);
        h.insert(15);
        h.insert(7);
        h.insert(17);
        h.insert(24);

        System.out.println("Hash Table:");
        h.print();

        System.out.println("\nSearch 17: "+h.search(17));
        System.out.println("Search 99: "+h.search(99));

        h.delete(17);

        System.out.println("\nAfter Deletion:");
        h.print();
    }
}
