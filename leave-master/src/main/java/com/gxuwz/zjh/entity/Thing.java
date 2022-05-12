package com.gxuwz.zjh.entity;

public abstract class Thing {
    private String Id;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
    @Override
    public String toString() {
        return "thing";
    }
}