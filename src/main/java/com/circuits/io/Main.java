package com.circuits.io;

import com.circuits.io.Bit.Bit;
import com.circuits.io.Gate.*;

public class Main {
    public static void main(String[] args) {

        // Main application runner
        System.out.println("Hello World");

        Bit b1 = new Bit();
        Bit b2 = new Bit();

        OR orGate = new OR();
        OR orGate2 = new OR();
        NOR nor1 = new NOR();
        AND andGate =new AND();
        NAND nandGate = new NAND();

        orGate.connect(orGate2);

        // System.out.println(b1 + " " + b2 + " " + orGate);

        // orGate.onChange(state -> System.out.println(" state:" + state));
        // orGate2.onChange(state -> System.out.println(" state:" + state));

        EXOR exor = new EXOR();

        b1.unSet();

        b1.connect(exor);
        b2.connect(exor);

        boolean ff = exor.calculateNewState(false, false);
        boolean ft = exor.calculateNewState(false , true);
        boolean tf = exor.calculateNewState(true, false);
        boolean tt = exor.calculateNewState(true, true);
        
        System.out.println(ff+" "+ft+" "+tf+" "+tt);

    }
}