package com.circuits.io.Gate;

import java.util.Arrays;
import java.util.List;

import com.circuits.io.base.Node;

public class EXOR extends Node {

    public  boolean calculateNewState(List<Node> inp){  
        boolean or_state = new OR().calculateNewState(inp);
        boolean nand_state = new NAND().calculateNewState(inp);

        return new AND().calculateNewState(or_state, nand_state);
    }


}
