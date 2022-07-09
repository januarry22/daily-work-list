package code.test.datastructure;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
* JAVA 트라이
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
