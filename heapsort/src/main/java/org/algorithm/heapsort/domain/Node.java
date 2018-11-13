package org.algorithm.heapsort.domain;

import org.algorithm.heapsort.solve.AbstractHeapObject;

public class Node implements AbstractHeapObject {

    private Long key;
    private Long value;

    public Node(Long key, Long value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public Long getKey() {
        return key;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
