/*
 * Decompiled with CFR 0.152.
 */
package edu.hnu.vspm.Instruction;

import edu.hnu.vspm.Instruction.Instruction;
import edu.hnu.vspm.Machine.VSPMachine;

public class JMP
extends Instruction {
    private final String m_destination;
    private final String m_source;

    public JMP(VSPMachine m, String destination, String source) {
        super(m);
        this.m_destination = destination;
        this.m_source = source;
    }

    @Override
    public void run() throws Exception {
        byte oldv = VSPMachine.regfile.getRegValue("PC");
        byte v = VSPMachine.regfile.getRegValue("R3");
        VSPMachine.regfile.setRegValue("PC", v);
    }

    @Override
    public String getString() {
        return String.format("jmp", new Object[0]);
    }
}

