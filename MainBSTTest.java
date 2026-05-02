public class MainBSTTest {
    public static void main(String[] args) {

        BST<Integer, String> tree = new BST<>();

        for (int i = 0; i < 10; i++) {
            tree.put(i, "val" + i);
        }

        for (Integer key : tree.iterator()) {
            System.out.println("key is " + key + " and value is " + tree.get(key));
        }

        System.out.println("Size: " + tree.size());
    }
}