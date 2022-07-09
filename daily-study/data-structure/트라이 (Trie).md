# 트라이 (Trie)

# 1. 트라이 (Trie)

- Tree자료구조와 같은 모양이지만 저장하는 값이 다른 형태
- 시각 복잡도 O(logN)을 가지는 이진트리에 문자열을 저장 할 경우
- 문자열의 길이 M에 따라 O(M*logN)로 시간복잡도 증가
- 이러한 문제를 개선하기 위해 사용
- 트라이를 사용할 경우 문자열 원소를 찾는데 걸리는 시간복잡도는 **O(M)**

# 2. 트라이의 구조

- 트라이의 루트 노드는 항상 길이 0인 문자열에 대응, 노드가 깊어질 수록 대응되는 문자열도 1증가함
- **루트에서 한 노드까지 내려가는 경로에서 만나는 글자들을 모으면 해당 노드에 대응되는 접두사를 얻을 수 있다**
- 트라이의 한 노드
    - 자손 노드들을 가리키는 포인터들
    - 이 노드가 마지막 노드인지 나타내는 boolean값
        
        [https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FZshOu%2Fbtq2gWW9XUk%2FbsRLFCEiN5P6kwh4bQrKWk%2Fimg.png](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FZshOu%2Fbtq2gWW9XUk%2FbsRLFCEiN5P6kwh4bQrKWk%2Fimg.png)
        

# 3. 구현

- java 에서는 Map 을 사용해서 구현
- <Key, Value> →  <해당 노드에 입력될 문자열 , 다음 트라이 노드>
    - Map의 키 값에는 문자를 이루는 각각의 단어들이 들어가고, 키와 매핑되는 값에는 자식 노드 클래스가 저장
    

```java

import java.util.HashMap;
import java.util.Map;

/*
* JAVA
* */
public class TrieNode {

    Map<Character, TrieNode> childNode = new HashMap<>();
    boolean lastNode;

    TrieNode(){
    }

    public void insert(String str) {
        TrieNode trieNode = this;
        for(char c : str.toCharArray()){

            // c 없으면 추가
            trieNode.childNode.putIfAbsent(c, new TrieNode());
            trieNode = trieNode.childNode.get(c);

            // 마지막 문자일 경우 boolean 종료
            if(c == str.charAt(str.length()-1)) {
                trieNode.lastNode = true;
                return;
            }
        }
    }

    public boolean search(String str) {
        TrieNode trieNode = this;
        for(char c : str.toCharArray()){
            TrieNode node = trieNode.childNode.get(c);

            // 다음 문자가 없으면 false
            if(node == null) {
                return false;
            }
            trieNode = node;
        }

        // 해당 단어로 종료하는 문자가 있는 경우 false
        return trieNode.lastNode;
    }

    public static void main(String[] args){

        TrieNode trie = new TrieNode();

        // 문자열 저장
        trie.insert("carrot");
        trie.insert("radish");
        trie.insert("cat");
        trie.insert("dog");

        System.out.println(trie.search("mow"));		// false
        System.out.println(trie.search("cat"));
        System.out.println(trie.search("dog"));
        System.out.println(trie.search("radish"));
    }
}
```

# 4. 문제점

- 문자열들의 전체 길이 만큼의 노드가 필요하므로 필요로 하는 공간이 너무 큼