package com.circuits.io;

import com.circuits.io.Adder.Adder;
import com.circuits.io.Bit.Bit;
import com.circuits.io.Gate.*;

public class Main {
    public static void main(String[] args) {

        // Main application runner
        System.out.println("Hello World");

        Bit b1 = new Bit();
        Bit b2 = new Bit();
        Bit c1 = new Bit();

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
        Adder adder = new Adder();

        b1.unSet();
        b2.unSet();
        c1.unSet();

        b1.connect(adder);
        b2.connect(adder);

        // boolean ff = exor.calculateNewState(false, false);
        // boolean ft = exor.calculateNewState(false , true);
        // boolean tf = exor.calculateNewState(true, false);
        // boolean tt = exor.calculateNewState(true, true);
        // System.out.println(ff+" "+ft+" "+tf+" "+tt);


        System.out.println(
            adder.calculateNewState(false, false, false)
        );
        System.out.println(
            adder.calculateNewState(true, false, false)
        );
        System.out.println(
            adder.calculateNewState(false, true, false)
        );
        System.out.println(
            adder.calculateNewState(false, false, true)
        );
        
        System.out.println(
            adder.calculateNewState(true, true, true)
        );
        

    }
}