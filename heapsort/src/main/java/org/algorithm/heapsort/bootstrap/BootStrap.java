package org.algorithm.heapsort.bootstrap;

import org.algorithm.heapsort.domain.Node;
import org.algorithm.heapsort.solve.HeapDirectionEnum;
import org.algorithm.heapsort.solve.HeapSort;

import java.util.ArrayList;
import java.util.List;

public class BootStrap {

    public static void main(String[] args) {


        new BootStrap().handle();
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Test st=(Test) ac.getBean("test");
//        st.test();
//        st.heapSort.setHeapCapability(1);
//        System.out.println(st.heapSort);

//        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
//        HeapSort<Node> heapSort = (HeapSort<Node>) ctx.getBean("heapSort");
//        heapSort.setHeapCapability(1);

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

//        for (int i = 0; i < 5; i++) {
//            System.out.println(heapSort.heapPop());
//        }

        heapSort.getHeap().forEach(System.out::println);

        List<Node> arr1 = new ArrayList<>();
        arr1.add(new Node(1L, 1L));
        arr1.add(new Node(1L, 2L));
        arr1.add(new Node(1L, 3L));
        arr1.add(new Node(4L, 4L));
        arr1.add(new Node(5L, 5L));
        heapSort.buildHeap(arr1);

        System.out.println("--------------");
        heapSort.getHeap().forEach(System.out::println);

        System.out.println(heapSort.heapPop());
    }

}
