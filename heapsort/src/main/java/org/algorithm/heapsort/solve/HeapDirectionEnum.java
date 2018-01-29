package org.algorithm.heapsort.solve;

public enum HeapDirectionEnum {

    MAX_ROOT(0, "MAX_ROOT", "大根堆"),
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
