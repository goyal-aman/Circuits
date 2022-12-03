
package com.circuits.io.Gate;

import java.util.List;

import com.circuits.io.base.Node;

public class NOR extends Node {

    @Override
    public  boolean calculateNewState(List<Node> inp){
        boolean new_state = new OR().calculateNewState(inp);
        return !new_state;
    }

}
