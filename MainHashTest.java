public class MainHashTest {
    public static void main(String[] args) {

        MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>(10);

        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(i, "name" + i);
            table.put(key, i);
        }

        table.printBuckets();

        System.out.println("Size: " + table.size());
    }
}