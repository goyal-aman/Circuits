

package com.circuits.io.Gate;

import java.util.List;

import com.circuits.io.base.Node;

public class AND extends Node {
    
    public boolean calculateNewState(List<Node> inp){
        for (Node n : inp) {
            if (!n.getState()) {
                return false;
            }
        }
        return true;
    }
}
