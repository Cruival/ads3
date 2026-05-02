public class MyHashTable<K, V> {
    private class HashNode<K, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }
        private HashNode<K, V>[] chainArray;
        private int M = 11;
        private int size;

        public MyHashTable(){
            chainArray = (HashNode<K, V>[]) new HashNode[M];
            size = 0;
        }
        public MyHashTable(int M){
            this.M = M;
            chainArray = (HashNode<K, V>[]) new HashNode[M];
            size = 0;
        }
        public static int hashCode(int[] a){
            if(a == null){
                return 0;
            }
            int hash = 1;
            for(int i = 0; i < a.length; i++){
                hash = 31 * hash + a[i];
            }
            return hash;
        }
        private int hash(K key){
            return (key.hashCode() & 0x7fffffff) % M;
        }
        public void put(K key, V value){
            int index = hash(key);
            HashNode<K, V> head = chainArray[index];

            while (head != null) {
                if (head.key.equals(key)) {
                    head.value = value;
                    return;
                }
                head = head.next;
            }
            size++;
            head = chainArray[index];
            HashNode<K, V> newNode = new HashNode<>(key, value);
            newNode.next = head;
            chainArray[index] = newNode;

        }
        public V get(K key){
            int index = hash(key);

            HashNode<K, V> head = chainArray[index];

            while (head != null) {
                if (head.key.equals(key)) {
                    return head.value;
                }
                head = head.next;
            }
            return null;

        }
        public V remove(K key){
            int index = hash(key);

            HashNode<K, V> head = chainArray[index];
            HashNode<K, V> prev = null;

            while (head != null) {
                if (head.key.equals(key)) {
                    size--;

                    if (prev != null) {
                        prev.next = head.next;
                    } else {
                        chainArray[index] = head.next;
                    }

                    return head.value;
                }
                prev = head;
                head = head.next;
            }

            return null;
        }
        public boolean contains(V value){
            for (int i = 0; i < M; i++) {
                HashNode<K, V> head = chainArray[i];

                while (head != null) {
                    if (head.value.equals(value)) {
                        return true;
                    }
                    head = head.next;
                }
            }
            return false;
        }
        public K getKey(V value){
            for (int i = 0; i < M; i++) {
                HashNode<K, V> head = chainArray[i];

                while (head != null) {
                    if (head.value.equals(value)) {
                        return head.key;
                    }
                    head = head.next;
                }
            }
            return null;
        }
    public int size() {
        return size;
    }
    public void printBuckets() {
        for (int i = 0; i < M; i++) {
            int count = 0;
            HashNode<K, V> head = chainArray[i];

            while (head != null) {
                count++;
                head = head.next;
            }

            System.out.println("bucket" + i + ":" + count);
        }
    }
}

