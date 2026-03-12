/*
 * Decompiled with CFR 0.152.
 */
package edu.hnu.vspm.Instruction;

import edu.hnu.vspm.Instruction.Instruction;
import edu.hnu.vspm.Machine.VSPMachine;

public class HALT
extends Instruction {
    private final String m_destination;
    private final String m_source;

    public HALT(VSPMachine m, String destination, String source) {
        super(m);
        this.m_destination = destination;
        this.m_source = source;
    }

    @Override
    public void run() throws Exception {
        this.m.stauts = 0;
    }

    @Override
    public String getString() {
        return String.format("halt", new Object[0]);
    }
}

