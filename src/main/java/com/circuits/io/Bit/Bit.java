package com.circuits.io.Bit;

import java.util.List;

import com.circuits.io.base.Node;

public class Bit extends Node {
    public Bit(boolean bool) {
        update_state(bool);
    }

    public Bit() {
    }

    public  boolean calculateNewState(List<Node> inp){
        // Bit has no computation
        return getState();
    }

}
