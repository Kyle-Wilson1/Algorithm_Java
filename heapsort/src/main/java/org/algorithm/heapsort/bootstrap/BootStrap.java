package org.algorithm.heapsort.bootstrap;

import org.algorithm.heapsort.algorithm.HeapDirectionEnum;
import org.algorithm.heapsort.domain.Node;
import org.algorithm.heapsort.algorithm.HeapSort;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.*;

public class BootStrap {

    @Autowired
    private HeapSort heapSort1;

    public static void main(String[] args) {

        new BootStrap().handle();

    }

    private void handle() {
        HeapSort<Node> heapSort = new HeapSort<>();

        List<Node> arr = new ArrayList<>();
        arr.add(new Node(1L, 1L));
        arr.add(new Node(2L, 2L));
        arr.add(new Node(3L, 3L));
        arr.add(new Node(4L, 4L));
        arr.add(new Node(5L, 5L));
        arr.add(new Node(6L, 6L));
        arr.add(new Node(7L, 7L));
        arr.add(new Node(8L, 8L));
        arr.add(new Node(9L, 9L));
        arr.add(new Node(10L, 10L));
        arr.add(new Node(11L, 11L));
        arr.add(new Node(12L, 12L));
        heapSort.setDirection(HeapDirectionEnum.MAX_ROOT);
        heapSort.setHeapCapability(8);
        heapSort.buildHeap(arr);

        for (int i = 0; i < 5; i++) {
            System.out.println(heapSort.heapPop());
        }
        System.out.println("--------------");
        List<Node> respList = heapSort.getHeap();
        respList.forEach(System.out::println);


        heapSort1.setHeapCapability(1);

    }

}
