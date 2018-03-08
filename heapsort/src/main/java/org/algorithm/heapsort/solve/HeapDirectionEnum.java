package org.algorithm.heapsort.solve;

public enum HeapDirectionEnum {

    //大根堆，适用于N个数中求最小的前M个数
    MAX_ROOT(0, "MAX_ROOT", "大根堆"),
    //小根堆，适用于N个数中求最大的前M个数
    MIN_ROOT(1, "MIN_ROOT", "小根堆");

    private Integer id;
    private String name;
    private String remark;

    HeapDirectionEnum(Integer id, String name, String remark) {
        this.id = id;
        this.name = name;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRemark() {
        return remark;
    }
}
