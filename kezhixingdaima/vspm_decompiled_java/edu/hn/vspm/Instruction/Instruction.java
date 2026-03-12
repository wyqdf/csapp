/*
 * Decompiled with CFR 0.152.
 */
package edu.hn.vspm.Instruction;

import edu.hn.vspm.Machine.VSPMachine;

public abstract class Instruction {
    protected final VSPMachine m;

    public Instruction(VSPMachine machine) {
        this.m = machine;
    }

    public abstract void run() throws Exception;

    public abstract String getString();
}

