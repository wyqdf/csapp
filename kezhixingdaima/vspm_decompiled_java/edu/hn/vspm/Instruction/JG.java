/*
 * Decompiled with CFR 0.152.
 */
package edu.hn.vspm.Instruction;

import edu.hn.vspm.Instruction.Instruction;
import edu.hn.vspm.Machine.VSPMachine;

public class JG
extends Instruction {
    private final String m_destination;
    private final String m_source;

    public JG(VSPMachine m, String destination, String source) {
        super(m);
        this.m_destination = destination;
        this.m_source = source;
    }

    @Override
    public void run() throws Exception {
        byte oldv = VSPMachine.regfile.getRegValue("PC");
        byte v = VSPMachine.regfile.getRegValue("R3");
        if (1 == VSPMachine.regfile.getRegValue("G")) {
            VSPMachine.regfile.setRegValue("PC", v);
        } else {
            VSPMachine.regfile.setRegValue("PC", (byte)(oldv + 1));
        }
    }

    @Override
    public String getString() {
        return String.format("jg", new Object[0]);
    }
}

