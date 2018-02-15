package com.nc.tree;

public class Task extends Node {
    String name;
    long spentTime = 0;
    private String executor;

    public Task(String executor, String name, Id id) {
        super(id);
        this.name = name;
        this.executor = executor;
    }
}
