package org.algorithm.heapsort.solve;

import java.util.ArrayList;
import java.util.List;

public class HeapSort<T extends AbstractHeapObject> {

    private List<T> sourceData;
    private HeapDirectionEnum direction;
    private List<T> heap;
    private int heapCapability;

    public void setDirection(HeapDirectionEnum direction) {
        this.direction = direction;
    }

    public void setHeapCapability(int heapCapability) {
        this.heapCapability = heapCapability;
    }

    public List<T> getHeap() {
        return heap;
    }

    synchronized public void buildHeap(List<T> sourceData) {

        this.sourceData = sourceData;

        //初始化堆容量
        if (heap == null) {
            heap = new ArrayList<>(heapCapability);
        }

        sourceData.forEach(x -> {
            //如果堆中元素还没有达到最大值，则插入到堆尾并向上调整，否则替换根元素并向下进行调整
            if (heap.size() < heapCapability) {
                heapUp(x);
            } else {
                if (direction == HeapDirectionEnum.MAX_ROOT && x.getKey() < heap.get(0).getKey()
                        || direction == HeapDirectionEnum.MIN_ROOT && x.getKey() > heap.get(0).getKey()) {
                    heap.set(0, x);
                    heapDown(0);
                }
            }
        });

    }

    /**
     * @param current the value to be added at the tail
     */
    private void heapUp(T current) {
        int i, j;
        heap.add(current);
        i = heap.size() - 1;
        j = (i - 1) / 2; //j指向i的父结点

        while (i > 0) {
            if (direction == HeapDirectionEnum.MAX_ROOT && heap.get(j).getKey() >= current.getKey()
                    || direction == HeapDirectionEnum.MIN_ROOT && heap.get(j).getKey() <= current.getKey()) {
                break;
            }
            heap.set(i, heap.get(j));
            i = j;
            j = (i - 1) / 2;
        }
        heap.set(i, current);
    }

    /**
     * @param top the location where the value will be adjusted down
     */
    private void heapDown(int top) {
        int j = 2 * top + 1;
        T x = heap.get(top);
        int heapSize = heap.size() - 1;

        while (j <= heapSize) {
            if (j + 1 <= heapSize && (
                    direction == HeapDirectionEnum.MAX_ROOT && heap.get(j + 1).getKey() > heap.get(j).getKey()
                            || direction == HeapDirectionEnum.MIN_ROOT && heap.get(j + 1).getKey() < heap.get(j).getKey()))
                j++;
            if (direction == HeapDirectionEnum.MAX_ROOT && heap.get(j).getKey() <= x.getKey()
                    || direction == HeapDirectionEnum.MIN_ROOT && heap.get(j).getKey() >= x.getKey()) {
                break;
            }
            heap.set(top, heap.get(j));
            top = j;
            j = 2 * top + 1;
        }
        heap.set(top, x);
    }

    public T heapPop() {
        T ret = heap.get(0);

        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapDown(0);

        return ret;
    }

}
