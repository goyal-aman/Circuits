package com.circuits.io.base;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

public abstract class Node {

    private List<Node> inp;
    private List<Node> op;
    private String id;
    Consumer<Boolean> on_change_consumer;
    boolean state;

    private static int count = 0;

    public Node() {
        this.inp = new ArrayList<Node>();
        this.op = new ArrayList<Node>();

        setId();

    }

    public boolean getState() {
        return state;
    }

    private void setId() {
        this.id = this.getClass().getName() + "_" + getAndIncreateCount();
    }

    private int getAndIncreateCount() {
        return ++count;
    }

    protected void update_state(boolean new_state) {
        /* update current state and nofity dependents to recompute */
        this.state = new_state;
        if(this.on_change_consumer!=null){
            System.out.println("\n-----START: "+this.id+"-----");
            this.on_change_consumer.accept(new_state);
            System.out.println("-----END: "+this.id+"-----\n");
        }
        notifyNext();
    }

    public void set() {
        update_state(true);
    }

    public void unSet() {
        update_state(false);
    }

    public List<Node> getOp() {
        return this.op;
    }

    public List<Node> getInp() {
        return this.inp;
    }

    public void notifyNext() {
        this.getOp().forEach(node -> {
            node.compute();
        });

    }

    /**
     * @param <T>
     * @param nodes
     */
    public <T extends Node> void connect(T... nodes) {
        for (Node n : nodes) {
            this.getOp().add(n);
            n.getInp().add(this);
        }
    }

    public void onChange(Consumer<Boolean> consumer) {
        this.on_change_consumer = consumer;
    }

    public abstract void compute();

    public String toString() {
        return String.format(this.getClass().getName() + "{ id:" + id + " state:" + state + "}");
    }

}