package code.test.datastructure;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * JAVA - 그래프 구현
 * */
public class GraphLinkedList {

    /* 연결리스트  */
    private ArrayList<ArrayList<Integer>> listGraph;

    public GraphLinkedList(int size) {
        listGraph = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<size +1; i++){
            listGraph.add(new ArrayList<Integer>());
        }
    }

    public ArrayList<ArrayList<Integer>> getArray() {
        return listGraph;
    }

    /* 연결리스트로 정점 (vertex) 추가(삭제) 가 */
    public void addVertex(int x){
        listGraph.add(new ArrayList<Integer>());
    }

    /* 단방향 연결
     *   x -> y
     * */
    public void addDiretedEdge(int x, int y) {
       listGraph.get(x).add(y);
    }

    /* 양방향 연결
    * x <-> y
    * */
    public void addCompleteEdge(int x, int y) {
        listGraph.get(x).add(y);
        listGraph.get(y).add(x);
    }

    public void print() {
        for (int i = 1; i < listGraph.size(); i++) {
            System.out.print("정점(vertex) "+i+"-> ");
            for (int j = 0; j < listGraph.get(i).size(); j++) {
                System.out.print(" "+listGraph.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        GraphLinkedList graph = new GraphLinkedList(5);

        graph.addVertex(6);

        graph.addCompleteEdge(1, 2);
        graph.addCompleteEdge(1, 3);
        graph.addDiretedEdge(1,5);

        graph.addCompleteEdge(3, 4);
        graph.addCompleteEdge(3, 5);

        graph.print();

    }

}
