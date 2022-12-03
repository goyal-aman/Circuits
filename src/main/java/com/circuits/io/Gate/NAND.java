

package com.circuits.io.Gate;

import java.util.List;

import com.circuits.io.base.Node;

public class NAND extends Node {
    
    public boolean calculateNewState(List<Node> inp){
        return !(new AND().calculateNewState(inp));
    }
}
