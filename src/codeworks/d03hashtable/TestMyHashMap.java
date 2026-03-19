package codeworks.d03hashtable;

public class TestMyHashMap {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap(7);
        map.put(10,100);
        map.put(20,200);
        map.put(15,150);
        map.put(7,70);
        map.put(17,170);
        map.put(24,240);

        System.out.println("HashMap:");
        map.print();
        System.out.println("\nGet 17: "+map.get(17));
        System.out.println("Get 50: "+map.get(50));
        map.remove(17);
        System.out.println("\nAfter deletion:");
        map.print();
    }
}
