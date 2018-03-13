package org.algorithm.heapsort.bootstrap;

import org.algorithm.heapsort.domain.Node;
import org.algorithm.heapsort.solve.HeapDirectionEnum;
import org.algorithm.heapsort.solve.HeapSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BootStrap {

    public static void main(String[] args) {

        new BootStrap().handle();
    }

    private void handle() {
        HeapSort<Node> heapSort = new HeapSort<>();

        List<Node> arr = new ArrayList<>(Arrays.asList(
                new Node(1L, 1L),
                new Node(2L, 2L),
                new Node(1L, 1L),
                new Node(2L, 2L),
                new Node(3L, 3L),
                new Node(4L, 4L),
                new Node(5L, 5L),
                new Node(6L, 6L),
                new Node(7L, 7L),
                new Node(8L, 8L),
                new Node(9L, 9L),
                new Node(10L, 10L),
                new Node(11L, 11L),
                new Node(12L, 12L)));
        heapSort.setDirection(HeapDirectionEnum.MAX_ROOT);
        heapSort.setHeapCapability(8);
        heapSort.buildHeap(arr);

        heapSort.getHeap().forEach(System.out::println);

        List<Node> arr1 = new ArrayList<>(Arrays.asList(
                new Node(1L, 1L),
                new Node(1L, 2L),
                new Node(1L, 3L),
                new Node(4L, 4L),
                new Node(5L, 5L)));
        heapSort.buildHeap(arr1);

        System.out.println("insert arr1:");

        heapSort.getHeap().forEach(System.out::println);

        System.out.println("pop: " + heapSort.heapPop());
    }

}
