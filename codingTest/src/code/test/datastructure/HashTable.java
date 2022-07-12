package code.test.datastructure;

import java.util.Hashtable;

public class HashTable {

    public String key;
    public Object object;

    public HashTable(String key, Object object) {
        this.key = key;
        this.object = object;
    }


    public static int HASH_TABLE_CAPACITY = 1000;
    public HashTable[] data = new HashTable[HASH_TABLE_CAPACITY];
    public int size = 0;

    public HashTable() {

    }


    // key 값을 hash 값으로 변경
    private int getHash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            char val = key.charAt(i);
            hash = (hash + val*(i + 1)) % HASH_TABLE_CAPACITY;
        }
        return hash;
    }

    public Object get(String key) {
        // null 값 안되게
        if (key != null) {
            int hash = getHash(key);
            while (data[hash] != null && !data[hash].key.equals(key)) {
                hash = (hash + 1) % HASH_TABLE_CAPACITY;
            }
            return data[hash] != null ? data[hash].object : null;
        }
        return null;
    }

    public void put(String key, Object object){
        if(key!=null){
            int hash = getHash(key);
            while (data[hash] != null && !data[hash].key.equals(key)) {
                hash = (hash + 1) % HASH_TABLE_CAPACITY;
            }
            data[hash] = new HashTable(key, object);
            size++;
        }
    }

    public Object remove(String key){
        Object removed = null;
        if(key!=null){
            int hash = getHash(key);
            while (data[hash] != null && !data[hash].key.equals(key)) {
                hash = (hash + 1) % HASH_TABLE_CAPACITY;
            }
            if (data[hash] != null) {
                removed = data[hash];
                data[hash] = null;
                size--;
            }
        }
        return removed;
    }

    public int size(){
        return size;
    }


    public String toString() {
        String out = "\n";
        for (int i = 0; i < data.length; i++) {
            HashTable item = data[i];
            if (item != null) {
                out += "key :" + data[i].key+","+ " value: " + data[i].object + "\n";
            }
        }
        return out;
    }

    public static void main(String[] args) {

        /* java util의 Hashtable */
        Hashtable java = new Hashtable();
        java.put("Tokyo", "Japan");
        java.put("Seoul", "Korea");
        java.put("Beijing", "China");
        java.put("Paris", "France");
        System.out.println(java.toString());



        HashTable hashTable = new HashTable();
        hashTable.put("Tokyo", "Japan");
        hashTable.put("Seoul", "Korea");
        hashTable.put("Beijing", "China");
        hashTable.put("Paris", "France");

        System.out.println((String) hashTable.get("Tokyo"));



        System.out.println(hashTable.toString());
    }
}
