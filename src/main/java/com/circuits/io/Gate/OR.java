package com.circuits.io.Gate;

import com.circuits.io.base.Node;

public class OR extends Node {

    @Override
    public void compute() {
        for (Node n : getInp()) {
            if (n.getState()) {
                update_state(true);
                return;
            }
        }
        update_state(false);
    }

}
