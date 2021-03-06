# 해시 테이블 (Hash Table)

## 1. 해시 구조

- Hash Table : 키 (Key)에 데이터(Value)를 저장하는 데이터 구조
- <Key, Value> 형태
- key를 hash 로 변경하여 저장 하기 때문에 매우 빠른 검색 속도
- Java 에서는 HashMap을 지원하기 때문에 따로 구현이 필요 없음

## 2. 용어

- 해시(Hash): 임의 값을 고정 길이로 변환하는 것
- 해시 테이블(Hash Table): 키 값의 연산에 의해 직접 접근이 가능한 데이터 구조
- 해싱 함수(Hashing Function) : Key에 대해 산술 연산을 이용해 데이터 위치를 찾을 수 있는 함수
- 해시 값(Hash Value) 또는 해시 주소(Hash Address): Key 를 해싱 함수로 연산해서, 해시 값을 알아내고, 이를 기반으로 해시 테이블에서 해당 Key에 대한 데이터위치를 찾을 수 있음
- 슬롯(Slot) : 한 개의 데이터를 저장할 수 있는 공간
- 저장할 데이터에 대해 Key를 추출할 수 있는 별도 함수도 존재할 수 있음

## 3. 구현

- get(key) - key 값으로 데이터 가져오기
- put(key, value) - 데이터 저장
- remove(key) - key 값으로 데이터 삭제
- size() - size
- toString() - 출력

```java

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
```

## 4. 해시 테이블 장단점

- 장점
    - 데이터 저장/읽기 속도가 빠름(검색 속도가 빠름)
    - 해시는 키에 대한 데이터가 있는지(중복)확인이 쉬움
- 단점
    - 일반적으로 저장공간이 좀더 많이 필요하다
    - 여러 키에 해당하는 주소가 동일할 경우 충돌을 해결하기 위한 별도 자료구조가 필요
- 주요 용도
    - 검색이 많이 필요한 경우
    - 저장, 삭제, 읽기가 빈번한 경우
    - 캐쉬 구현시 (중복 확인이 쉽기 때문)