package codeworks.d03hashtable;

public class TestDoubleHashing {
    public static void main(String[] args) {

        DoubleHashing h = new DoubleHashing(7);

        h.insert(10);
        h.insert(20);
        h.insert(15);
        h.insert(7);
        h.insert(17);

        System.out.println("Hash Table:");
        h.print();

        System.out.println("\nSearch 15: " + h.search(15));
        System.out.println("Search 99: " + h.search(99));

        h.delete(15);

        System.out.println("\nAfter deletion:");
        h.print();
    }
}
