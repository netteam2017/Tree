package com.nc.tree;

/**
 * Created by user on 06.02.2018.
 */
public class TaskTree extends Tree<Task> {
    public TaskTree(Tree<Task> otherTree) {
        super(otherTree);
    }

    @Override
    Task createNode(Task oldNode, Id newId) {
        return null;
    }

    @Override
    Tree<Task> createTree(Task head) {
        return null;
    }
}
