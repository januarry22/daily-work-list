package code.test.datastructure;

import java.util.ArrayList;
import java.util.Arrays;

public class Heap {

    public static ArrayList<Integer> heap;

    public static void main(String[] args) {

        heap = new ArrayList<>();
        heap.add(0);

        insert(10);
        insert(8);
        insert(5);
        insert(4);
        insert(20);

        delete();       // max heap 이기 때문에 20 이 삭제됨
        System.out.println(heap.toString());
    }

    public static void insert(int x) {
        heap.add(x);

        int dep = heap.size() - 1;

        while (dep > 1 && heap.get(dep / 2) < heap.get(dep)) {
            int temp = heap.get(dep / 2);
            heap.set(dep / 2, heap.get(dep));
            heap.set(dep, temp);

            dep = dep / 2;
        }
    }

    public static void delete(){

        if(heap.size()-1 <1){
            return;
        }

        int deleted = heap.get(1);

        heap.set(1, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int pos = 1;

        while ((pos*2)<heap.size()){
            int max = heap.get(pos * 2);
            int maxPos = pos *2;
            if(((pos * 2 + 1) < heap.size()) &&
                    max < heap.get(pos * 2 + 1)) {
                max = heap.get(pos * 2 + 1);
                maxPos = pos * 2 + 1;
            }
            if(heap.get(pos) > max) {
                break;
            }


            int temp = heap.get(pos);
            heap.set(pos, heap.get(maxPos));
            heap.set(maxPos, temp);
            pos = maxPos;
        }

    }
}
