package com.circuits.io.Adder;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.circuits.io.Gate.AND;
import com.circuits.io.Gate.EXOR;
import com.circuits.io.Gate.OR;
import com.circuits.io.base.Node;

public class Adder extends Node{

    @Override
    public boolean calculateNewState(List<Node> inp) {
        // inp[0th bit.., 1st bit.., 2nd bit., ....., carry_bit]
        boolean xor1 = new EXOR().calculateNewState(inp.subList(0, inp.size()-1));
        boolean and1 = new AND().calculateNewState(inp.subList(0, inp.size()-1));
        

        boolean xor2 = new EXOR().calculateNewState(
            xor1, inp.get(inp.size()-1).getState()
        );


        // and2
        boolean and2 = new AND().calculateNewState(
            xor1, inp.get(inp.size()-1).getState()
        );

        boolean or1 = new OR().calculateNewState(and1, and2);
        String s = inp.stream().map(node -> String.valueOf(node.getState())).collect(Collectors.joining(", "));
        System.out.println("inp:"+s+" op:"+xor2+" "+or1);


        return false;
    }
    
}
