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
        orGate.connect(orGate2);

        System.out.println(b1 + " " + b2 + " " + orGate);

        orGate.onChange(state -> System.out.println(" state:" + state));
        orGate2.onChange(state -> System.out.println(" state:" + state));

        b1.connect(orGate);
        b2.connect(orGate);

        b1.set();
        b1.unSet();

        b2.set();
        b1.set();

    }
}